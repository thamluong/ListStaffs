package org.o7planning.tutorial.springmvcjdbc.model;

import java.io.Serializable;

//@XmlRootElement(name = "user")
public class StaffAddedByWebService implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name_department;
	
	private int id_staff ;
	private int  id_department ;
	
	private String name_staff ;
	private String info_staff ;
	private String avatar_staff ;
	private String position_staff;
	private String cert_staff;
	private String info_cert;
	private String multi_cert;	  
	private String salary_month;

	public StaffAddedByWebService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffAddedByWebService(String name_department, int id_staff, int id_department, String name_staff, String info_staff, 
			String avatar_staff,String position_staff,String cert_staff,String info_cert, String multi_cert, String salary_month)
	{
		super();
		this.name_department = name_department;
		this.id_staff = id_staff;
		this.id_department = id_department;

		this.name_staff = name_staff;
		this.info_staff = info_staff;
		this.avatar_staff = avatar_staff;
		this.position_staff = position_staff;
		this.cert_staff = cert_staff;
		this.info_cert = info_cert;
		this.multi_cert = multi_cert;
		this.salary_month= salary_month;
	}

	public String getInfo_cert() {
		return info_cert;
	}
	
	public void setInfo_cert(String info_cert) {
		this.info_cert += "  -  "+info_cert + "\n";
	}
	public int getId_staff() {
		return id_staff;
	}
	
	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}
	public int getId_department() {
		return id_department;
	}
	
	public void setId_department(int id_department) {
		this.id_department = id_department;
	}
	public String getName_department() {
		return name_department;
	}
	
	public void setName_department(String name_department) {
		this.name_department = name_department;
	}
	public String getName_staff() {
		return name_staff;
	}
	
	public void setName_staff(String name_staff) {
		this.name_staff = name_staff;
	}
	public String getInfo_staff() {
		return info_staff;
	}
	
	public void setInfo_staff(String info_staff) {
		this.info_staff = info_staff;
	}
	public String getAvatar_staff() {
		return avatar_staff;
	}
	
	public void setAvatar_staff(String avatar_staff) {
		this.avatar_staff = avatar_staff;
	}
	public String getPosition_staff() {
		return position_staff;
	}
	
	public void setPosition_staff(String position_staff) {
		this.position_staff = position_staff;
	}
	public String getCert_staff() {
		return cert_staff;
	}
	
	public void setCert_staff(String cert_staff) {
		this.cert_staff = cert_staff;
	}
	public String getSalary_month() {
		return salary_month;
	}
	
	public void setSalary_month1(String salary_month) {
		this.salary_month = salary_month;
	}

	public String getMulti_cert() {
		return multi_cert;
	}
	
	public void setMulti_cert(String multi_cert) {
		this.multi_cert = multi_cert;
	}


}
