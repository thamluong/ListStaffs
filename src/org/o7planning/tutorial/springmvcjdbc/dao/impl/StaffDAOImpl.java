package org.o7planning.tutorial.springmvcjdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.o7planning.tutorial.springmvcjdbc.dao.StaffDAO;
import org.o7planning.tutorial.springmvcjdbc.mapper.StaffMapper;
import org.o7planning.tutorial.springmvcjdbc.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffDAOImpl extends JdbcDaoSupport implements StaffDAO{

	@Autowired
	public StaffDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Staff> list() {
		String sql = "select list_staff.*,list_company.name_company from list_staffs.list_company "
				+ " inner join list_staffs.list_staff on list_company.id_company=list_staff.id_company order by id_staff";

		Object[] params = new Object[] {};
		StaffMapper mapper = new StaffMapper();
		List<Staff> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}


	public List<Staff> listObjectStaff(String  id){
		String sql = "select list_staff.*,list_company.name_company from list_staffs.list_company "
				+ " inner join list_staffs.list_staff on list_company.id_company=list_staff.id_company "
				+ " where list_staff.id_company="+id;

		StaffMapper mapper = new StaffMapper();
		List<Staff> list = this.getJdbcTemplate().query(sql,  mapper);
		return list;
	}


	public void deleteStaff(String id){
		String sql="DELETE FROM list_staffs.list_staff WHERE id_staff="+id;
		this.getJdbcTemplate().update(sql);
		return;
	}


	public int addStaff(Staff ct){
		String sql="insert into list_staffs.list_staff ( id_company, name_staff, info_staff, avatar_staff) "
				+ " values (?,?,?,?)";
		this.getJdbcTemplate().update(sql,ct.getId_company(),ct.getName_staff(),ct.getInfo_staff(),ct.getAvatar_staff());
		return -1;
	}


	public Staff detailStaff(String id){
		String sql = "select list_staff.*,list_company.name_company from list_staffs.list_company "
				+ " inner join list_staffs.list_staff on list_company.id_company=list_staff.id_company "
				+ " where list_staff.id_staff="+id;

		StaffMapper mapper = new StaffMapper();	 
		Staff ct = this.getJdbcTemplate().queryForObject(sql, mapper);
		return ct;
	}


	public void updateDb(List<Staff> staffs){
		int n = staffs.size();
		Staff staff = new Staff();
		while(--n >= 0){
			staff = staffs.get(n);
			System.out.print(staff.getName_staff());
			if(isExisted(staff.getName_staff()) == 0){
				System.out.println(" not exist");

				String sql="insert into list_staffs.list_staff ( id_company, name_staff, info_staff, avatar_staff) "
						+ "values ('"+staff.getId_company()+"','"+
						staff.getName_staff()+"','"+staff.getInfo_staff()+"','"+staff.getAvatar_staff()+"')";
				try{
					this.getJdbcTemplate().update(sql);
					System.out.println("Update successful");
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}}}
	}


	public int isExisted(String name){
		String sql = "SELECT id_staff FROM list_staffs.list_staff"
				+ " where (name_staff,info_staff,avatar_staff) "
				+ " in ( select name_staff,info_staff,avatar_staff from company.staff)"
				+ " and name_staff='"+name+"'";

		try{
			this.getJdbcTemplate().queryForObject(sql, Integer.class);
			//System.out.println(" existed");
			return 1;
		}catch(Exception ex){
			//System.out.println(ex.getMessage());
			//System.out.println(" not existed");
			return 0;
		}
	}
}
