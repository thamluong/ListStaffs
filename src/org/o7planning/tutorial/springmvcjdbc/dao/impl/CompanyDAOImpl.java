package org.o7planning.tutorial.springmvcjdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;
 
import org.o7planning.tutorial.springmvcjdbc.dao.CompanyDAO;
import org.o7planning.tutorial.springmvcjdbc.mapper.CompanyMapper;
import org.o7planning.tutorial.springmvcjdbc.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyDAOImpl extends JdbcDaoSupport implements CompanyDAO{
	@Autowired
	   public CompanyDAOImpl(DataSource dataSource) {
	       this.setDataSource(dataSource);
	   }
	
	@Override
	   public List<Company> list() {
	       String sql = "Select * from list_company";
	       
	       Object[] params = new Object[] {};
	       CompanyMapper mapper = new CompanyMapper();
	 
	       List<Company> listCompany = this.getJdbcTemplate().query(sql, params, mapper);
	       return listCompany;
	   }
	
	@Override
	public void add(String name_company){
		String sql = "insert into list_staffs.list_company (name_company) values (?)";
		this.getJdbcTemplate().update(sql, name_company);
	}
}
