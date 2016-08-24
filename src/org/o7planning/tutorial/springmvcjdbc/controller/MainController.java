package org.o7planning.tutorial.springmvcjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.o7planning.tutorial.springmvcjdbc.dao.CompanyDAO;
import org.o7planning.tutorial.springmvcjdbc.dao.StaffDAO;
import org.o7planning.tutorial.springmvcjdbc.model.Company;
import org.o7planning.tutorial.springmvcjdbc.model.Staff;
import org.o7planning.tutorial.springmvcjdbc.model.StaffAddedByWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private StaffDAO staffDAO;
	private static String StrResponseByWS = "";
	private static List<Staff> staffs_addByWS = new ArrayList<Staff>();
	private static String present_response_string = "";

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listStaff(ModelMap mmodel) {
		staffs_addByWS = new ArrayList<Staff>();
		present_response_string = "";

		List<Staff> listStaffs = staffDAO.list();
		List<Company> listCompanys = companyDAO.list();
		mmodel.put("listStaff", listStaffs);
		mmodel.put("listCompany", listCompanys);
		return "index";
	}


	@RequestMapping(value = { "/staffs-acompany" }, method = RequestMethod.GET)
	public String listStaff_aCompany(ModelMap mmodel,HttpServletRequest request){

		String company_id = request.getParameter("company_id");
		if (company_id.equals("0"))
			mmodel.put("listStaff", staffDAO.list());
		else mmodel.put("listStaff", staffDAO.listObjectStaff(company_id));
		return "index";
	}


	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStaff(@RequestParam("id") String id){
		staffDAO.deleteStaff(id.trim());
		return "index";
	}


	@RequestMapping(value = "/add-staff", method = RequestMethod.GET)
	public String addDialog(ModelMap mmodel) {
		List<Company> listCompanys = companyDAO.list();
		mmodel.put("listCompany", listCompanys);
		return "addstaff";
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStaff(@ModelAttribute Staff ct, ModelMap mmodel){

		staffDAO.addStaff(ct);
		int id_staff = staffDAO.list().get(staffDAO.list().size() - 1).getId_staff();
		mmodel.put("id_staff", id_staff);	
		return "result";
	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailStaff(@RequestParam String id,ModelMap mmodel){
		Staff newct = staffDAO.detailStaff(id);
		mmodel.put("detail_staff", newct);
		return "detail_file";
	}

	//==================================================================================================//
	//==================================================================================================//
	/* Here is RequestMappings for Service*/
	/**/
	
	@RequestMapping(value = "/get-response-service", method = RequestMethod.GET)
	private @ResponseBody void addStaffByWS(@RequestParam("id_staff") String idstr) {
		System.out.println("\nStrResponseByWS = ["+idstr+"]");
		StrResponseByWS = idstr;
	}

	@RequestMapping(value="/add-staff-service", method=RequestMethod.GET)
	public String addStaff(ModelMap mmodel){
		StaffAddedByWebService staff = new StaffAddedByWebService();
		List<Staff> staffs2 = new ArrayList<Staff>();
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/Staffs/StaffService";


		String[] strArray = StrResponseByWS.split(",");

		//restTemplate.getForObject(uri) is to get content of the URI
		//Here we get content of the .xml file
		for(int i = 0; i < strArray.length; i++) {
			staff = restTemplate.getForObject(uri+"/users/{id}", StaffAddedByWebService.class, strArray[i]);

			if((staffDAO.isExisted(staff.getName_staff())) == 1)
				staffs2.add(new Staff(2, 0, staff.getName_staff(), staff.getInfo_staff(), staff.getAvatar_staff(), "FSoft"));	
			else {
				if(present_response_string.contains(strArray[i]+",") == false){
					System.out.println(strArray[i]+" is selected");
					staffs_addByWS.add(new Staff(2, 0, staff.getName_staff(), staff.getInfo_staff(), staff.getAvatar_staff(), "FSoft"));
					present_response_string += strArray[i]+",";
				} } }

		mmodel.put("staffs2", staffs2);
		mmodel.put("staffs_addByWS", staffs_addByWS);

		return "addStaffByWebService";
	}


	@RequestMapping(value="/updateDbByWS", method=RequestMethod.GET)
	public @ResponseBody void updateDbByWS(ModelMap mmodel){
		System.out.println("\nController starts updateDB ");

		staffDAO.updateDb(staffs_addByWS);
		System.out.println("\nController finishes updateDB ");
	}

	@RequestMapping(value="/null-add-staff", method=RequestMethod.GET)
	public String null_staffs_addByWS(ModelMap mmodel){
		staffs_addByWS = new ArrayList<Staff>();
		present_response_string = "";
		mmodel.put("staffs_addByWS", staffs_addByWS);
		return "addStaffByWebService";
	}

	//==================================================================================================//
	//==================================================================================================//

}