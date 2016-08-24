package org.o7planning.tutorial.springmvcjdbc.dao;

import java.util.List;

import org.o7planning.tutorial.springmvcjdbc.model.Staff;

public interface StaffDAO {
	public List<Staff> list();
	public List<Staff> listObjectStaff(String id);
	
	public void deleteStaff(String id);
	public int addStaff(Staff ct);
	public Staff detailStaff(String id);
	public void updateDb(List<Staff> staffs);
	public int isExisted(String name);
}
