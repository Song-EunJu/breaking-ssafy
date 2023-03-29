package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptService {

	private DeptDAO deptDao = new DeptDAO();
	public boolean registDept(Dept dept) throws Exception{
		return deptDao.insertDept(dept);
	}
	public boolean removeDept(int deptNo) throws Exception{
		return deptDao.deleteDept(deptNo);
	}
	public void modifyDept(Dept dept) throws Exception{
		deptDao.updateDept(dept);
	}
	public Dept	getDept(int deptNo) throws Exception {
		return deptDao.getDept(deptNo);
	}
	public List<Dept>	getDepts() throws Exception {
		return deptDao.getDepts();
	}
	public List<Dept> getDeptsByName(String deptName) throws Exception {
		return deptDao.getDeptsByName(deptName);
		
	}
}
