package org.o7planning.tutorial.springmvcjdbc.model;

public class Company {
	private int id_company;
	private String name_company;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public Company(int id_company, String name_company) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
	}
	public int getId_company() {
		return id_company;
	}
	public void setId_company(int id_company) {
		this.id_company = id_company;
	}
	public String getName_company() {
		return name_company;
	}
	public void setName_company(String name_company) {
		this.name_company = name_company;
	}
	
	
}
