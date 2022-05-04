package com.tectoro.ems.controller;

import java.util.List;

import com.tectoro.ems.domain.Department;
import com.tectoro.ems.service.DepartmentService;
import com.tectoro.ems.service.impl.DepartmentServiceImpl;

public class DepartmentController {
	
	private static DepartmentService deperatmentService= new DepartmentServiceImpl();
	
	public List<Department> getDepartment(){
		
		List<Department> department= null;
		try {
			department= deperatmentService.getDepartment();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return department;
	}
	
	public Department getDepartmentById(int deptId) throws Exception {
		
		Department department= deperatmentService.getDepartmentById(deptId);
		
		return department;
	}
	
	public Department addDepartment(Department department) {
		
		Department departmentOutput= new Department();
		try {
			departmentOutput= deperatmentService.addDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentOutput;
	}
	
	public Department updateDepartmaent(Department department) {
		
		Department departmentOutput= new Department();
		try {
			departmentOutput= deperatmentService.updateDepartmaent(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentOutput;
	}
	
	public String deleteDepartment(int deptId){

		String departmentOutput1= deperatmentService.deleteDepartment(deptId);
		
		return "delete operation is successfull";
	}

	public static void main(String[] args) throws Exception {
		
		DepartmentController deptController = new DepartmentController();
		List<Department> dept = new DepartmentController().getDepartment();
		for(Department department:dept) {
			System.out.println("Department details:");
			System.out.println("Department Id:"+department.getDeptId());
			System.out.println("Department Name:"+department.getDeptName());
		}
		Department dept1=new DepartmentController().getDepartmentById(3);
		System.out.println("==========================");
		System.out.println("Department id:"+dept1.getDeptId());
		System.out.println("Department Name:"+dept1.getDeptName());
		/*
		System.out.println("==========================");
		Department insertDepartment = new Department();
		insertDepartment.setDeptId(5);
		insertDepartment.setDeptName("Production");
		Department departmentOutput = new DepartmentController().addDepartment(insertDepartment);
		if(departmentOutput!= null) {
			System.out.println("Insert operation in Departm:-");
			System.out.println("Region Id:"+departmentOutput.getDeptId()+"\t"+"Department name:"+departmentOutput.getDeptName());	
		}
		else
		{
			System.out.println("Department already exists in the database");
		}
		
		System.out.println("==========================");
		Department updateDepartment = new Department();
		updateDepartment.setDeptId(5);
		updateDepartment.setDeptName("Management");
		Department departmentOutput1 = new DepartmentController().updateDepartmaent(updateDepartment);
		if(departmentOutput1!= null) {
			System.out.println("update operation in Department:-");
			System.out.println("Region Id:"+departmentOutput1.getDeptId()+"\t"+"Department name:"+departmentOutput1.getDeptName());	
		}
		else
		{
			System.out.println("Department already exists in the database");
		}
		*/
		System.out.println("=================================");
		System.out.println("Delete operation in Department:");
		String delete=new DepartmentController().deleteDepartment(5);
		System.out.println(delete);
		
	}	

}
