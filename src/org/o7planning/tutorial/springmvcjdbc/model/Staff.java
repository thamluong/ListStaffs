package org.o7planning.tutorial.springmvcjdbc.model;

public class Staff {
	private int id_company;
	private int id_staff;
	private String name_staff;
	private String info_staff;
	private String avatar_staff;
	private String name_company;
	
	
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	public Staff(int id_company, int id_staff, String name_staff, String info_staff, String avatar_staff, String name_company) {
		super();
		this.id_company = id_company;
		this.name_company = name_company;
		this.id_staff = id_staff;
		this.name_staff = name_staff;
		this.info_staff = info_staff;
		this.avatar_staff = avatar_staff;
	}
	
	public int getId_company() {
		return id_company;
	}
	public void setId_company(int id_company) {
		this.id_company = id_company;
	}
	public int getId_staff() {
		return id_staff;
	}
	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
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
	public String getName_company() {
		return name_company;
	}
	public void setName_company(String name_company) {
		this.name_company = name_company;
	}
	
}
