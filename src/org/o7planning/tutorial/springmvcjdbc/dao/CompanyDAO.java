package org.o7planning.tutorial.springmvcjdbc.dao;

import java.util.List;
import org.o7planning.tutorial.springmvcjdbc.model.Company;

public interface CompanyDAO {
	public List<Company> list();
	public void add(String name_company);
}
