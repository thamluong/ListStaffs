package org.o7planning.tutorial.springmvcjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NameCompanyMapper implements RowMapper<String> {
	@Override
	   public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString(2);
	}
	
}
