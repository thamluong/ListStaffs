package org.o7planning.tutorial.springmvcjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.o7planning.tutorial.springmvcjdbc.model.Staff;
import org.springframework.jdbc.core.RowMapper;

public class StaffMapper implements RowMapper<Staff> {
	@Override
	   public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
	       int  id_company = rs.getInt(1);
	       int id_staff = rs.getInt(2);
	       String name_staff = rs.getString(3);
	       String info_staff = rs.getString(4);
	       String avatar_staff = rs.getString(5);
	       String name_company = rs.getString(6);
	      	 
	       return new Staff(id_company, id_staff, name_staff, info_staff, avatar_staff, name_company);
	   }
	 
}
