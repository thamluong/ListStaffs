package org.o7planning.tutorial.springmvcjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.o7planning.tutorial.springmvcjdbc.model.Company;
import org.springframework.jdbc.core.RowMapper;

public class CompanyMapper  implements RowMapper<Company>{
	@Override
	   public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
	       int  id_company = rs.getInt(1);
	       String name_company = rs.getString(2);
	 
	       return new Company(id_company, name_company);
	   }
}
