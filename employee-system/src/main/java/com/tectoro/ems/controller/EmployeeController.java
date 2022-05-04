package com.tectoro.ems.controller;

import java.util.List;

import com.tectoro.ems.domain.Country;
import com.tectoro.ems.domain.Employee;
import com.tectoro.ems.domain.Location;
import com.tectoro.ems.service.EmployeeService;
import com.tectoro.ems.service.impl.EmployeeServiceImpl;

public class EmployeeController {
	
	private static EmployeeService service= new EmployeeServiceImpl();
	
	public List<Employee> getEmployee(){
		
		List<Employee> employees = null;
		try {
			employees = service.getEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee getEmployeeById(int empId) throws Exception{
		
		Employee employee= service.getEmployeeById(empId);
		return employee;
	}
	
	public List<Employee> getEmployeeByDepartment(int deptId){
		List<Employee> employee=null;
		try {
		employee= service.getEmployeeByDepartment(deptId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> getEmployeeByJob(int jobId){
		List<Employee> employee=null;
		try {
		employee= service.getEmployeeByJob(jobId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}
	
	public Employee addEmployee(Employee employee) {
		
		Employee empOutput= new Employee();
		try {
			empOutput= service.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empOutput;
		
	} 
	
	public Employee updateEmployee(Employee employee) {

		Employee empOutput= new Employee();
		try {
			empOutput= service.updateEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empOutput;

	} 
	
	public String deleteEmployee(int empId) {
		String regionOutput= service.deleteEmployee(empId); 
		if( regionOutput!=null) {		
			return "deleted sucessfullly";
		}
	
		return "table is already exists";
	}
	
	

	public static void main(String[] args) throws Exception {
		EmployeeController employeeController =  new EmployeeController();
		List<Employee> employees =  employeeController.getEmployee();
		for(Employee employee : employees ) {
			
			System.out.println("**************************************************");
			 System.out.println("empid : "+employee.getEmpId());
			 System.out.println("firstname : "+employee.getFirstName());
			 System.out.println("lastname : "+employee.getLastName());
			 System.out.println("salary : "+employee.getSalary());
			 System.out.println("email : "+employee.getEmail());
			 System.out.println("phoneno : "+employee.getPhoneNum());
			 System.out.println("mgrid : "+employee.getManagerId());
			 System.out.println("deptid : "+employee.getDeptId());
			 System.out.println("locationcode : "+employee.getLocationCode());
			 System.out.println("jobid : "+employee.getJobId());
			 System.out.println("hiredate : "+employee.getHireDate());
			 System.out.println("**************************************************");
		}
		
		Employee employee1 =  new EmployeeController().getEmployeeById(1001);
		System.out.println("Employee details by employee id:");
		System.out.println("empid : "+employee1.getEmpId());
		 System.out.println("firstname : "+employee1.getFirstName());
		 System.out.println("lastname : "+employee1.getLastName());
		 System.out.println("salary : "+employee1.getSalary());
		 System.out.println("============================");
			Location location1 = new Location();
			location1.setLocationCode("brt");
			location1.setPostalCode(45511);
			location1.setCity("brazileas");
			location1.setStreetAddress("balane");
			location1.setStateProvience("braz");
			Country count= new Country(); 
			location1.setCountry(count);;
			location1.getCountry().setCode("BR");
			Location locationOutput = new LocationController().addLocation(location1);
			if(locationOutput!= null) {
				System.out.println("Insert operation in country:-");
				System.out.println("Location code:"+locationOutput.getLocationCode()+"\t"
									+"postal code:"+locationOutput.getPostalCode()+"\t"
									+"city:"+locationOutput.getCity()+"\t"							
									+"street adress:"+locationOutput.getStreetAddress()+"\t"
									+"StateProvience:"+locationOutput.getStateProvience()+"\t"
									+"country:"+locationOutput.getCountry().getCode());
									
			}
			else
			{
				System.out.println("employee already exists in the database");
			}
		 System.out.println("email : "+employee1.getEmail());
		 System.out.println("phoneno : "+employee1.getPhoneNum());
		 System.out.println("mgrid : "+employee1.getManagerId());
		 System.out.println("deptid : "+employee1.getDeptId());
		 System.out.println("locationcode : "+employee1.getLocationCode());
		 System.out.println("jobid : "+employee1.getJobId());
		 System.out.println("hiredate : "+employee1.getHireDate());
		 System.out.println("**************************************************");
		
		 List<Employee> employees1 =  employeeController.getEmployeeByDepartment(3);
			for(Employee employee : employees1 ) {
				
				System.out.println("Employee details by department id:");
				 System.out.println("empid : "+employee.getEmpId());
				 System.out.println("firstname : "+employee.getFirstName());
				 System.out.println("lastname : "+employee.getLastName());
				 System.out.println("salary : "+employee.getSalary());
				 System.out.println("email : "+employee.getEmail());
				 System.out.println("phoneno : "+employee.getPhoneNum());
				 System.out.println("mgrid : "+employee.getManagerId());
				 System.out.println("deptid : "+employee.getDeptId());
				 System.out.println("locationcode : "+employee.getLocationCode());
				 System.out.println("jobid : "+employee.getJobId());
				 System.out.println("hiredate : "+employee.getHireDate());
				 System.out.println("**************************************************");
			}
		
			List<Employee> employees2 =  employeeController.getEmployeeByJob(104);
			for(Employee employee : employees2 ) {
				
				System.out.println("Employee details by job id:");
				 System.out.println("empid : "+employee.getEmpId());
				 System.out.println("firstname : "+employee.getFirstName());
				 System.out.println("lastname : "+employee.getLastName());
				 System.out.println("salary : "+employee.getSalary());
				 System.out.println("email : "+employee.getEmail());
				 System.out.println("phoneno : "+employee.getPhoneNum());
				 System.out.println("mgrid : "+employee.getManagerId());
				 System.out.println("deptid : "+employee.getDeptId());
				 System.out.println("locationcode : "+employee.getLocationCode());
				 System.out.println("jobid : "+employee.getJobId());
				 System.out.println("hiredate : "+employee.getHireDate());
				 System.out.println("**************************************************");
			}
			/*
			System.out.println("============================");
			Employee employee = new Employee();
			employee.setDeptId(3);
			employee.setFirstName("Ramesh");
			employee.setLastName("sahu");
			employee.setSalary("36000");
			employee.setEmail("ram@email");
			employee.setPhoneNum(12364);
			employee.setManagerId(1002);
			employee.setDeptId(3);
			employee.setLocationCode("uga");
			employee.setJobId(104);
			employee.setHireDate("12-09-2018");
			employee.setEmpId(1006);
			
			Employee employeeOutput1 = new EmployeeController().addEmployee(employee);
			if(employeeOutput1!= null) {
				System.out.println("Insert operation in country:-");
				System.out.println("empid:"+employeeOutput1.getEmpId()+"\t"
									+"firstname:"+employeeOutput1.getFirstName()+"\t"
									+"lastname:"+employeeOutput1.getLastName()+"\t"
									+"salary:"+employeeOutput1.getSalary()+"\t"
									+"email:"+employeeOutput1.getEmail()+"\t"
									+"phoneno:"+employeeOutput1.getPhoneNum()+"\t"
									+"mgrid:"+employeeOutput1.getManagerId()+"\t"
									+"deptid:"+employeeOutput1.getDeptId()+"\t"
									+"locationcode:"+employeeOutput1.getLocationCode()+"\t"
									+"jobid:"+employeeOutput1.getJobId()+"\t"
									+"hiredate:"+employeeOutput1.getHireDate()+"\t"
									);	
			}
			else
			{
				System.out.println("employee already exists in the database");
			}
			
			System.out.println("============================");
			Employee employee2 = new Employee();
			employee2.setDeptId(3);
			employee2.setFirstName("suresh");
			employee2.setLastName("sahu");
			employee2.setSalary("39000");
			employee2.setEmail("sue@email");
			employee2.setPhoneNum(12454);
			employee2.setManagerId(1001);
			employee2.setDeptId(2);
			employee2.setLocationCode("bng");
			employee2.setJobId(103);
			employee2.setHireDate("12-10-2018");
			employee2.setEmpId(1006);
			
			Employee employeeOutput2 = new EmployeeController().updateEmployee(employee2);
			if(employeeOutput2!= null) {
				System.out.println("Insert operation in country:-");
				System.out.println("empid:"+employeeOutput2.getEmpId()+"\t"
									+"firstname:"+employeeOutput2.getFirstName()+"\t"
									+"lastname:"+employeeOutput2.getLastName()+"\t"
									+"salary:"+employeeOutput2.getSalary()+"\t"
									+"email:"+employeeOutput2.getEmail()+"\t"
									+"phoneno:"+employeeOutput2.getPhoneNum()+"\t"
									+"mgrid:"+employeeOutput2.getManagerId()+"\t"
									+"deptid:"+employeeOutput2.getDeptId()+"\t"
									+"locationcode:"+employeeOutput2.getLocationCode()+"\t"
									+"jobid:"+employeeOutput2.getJobId()+"\t"
									+"hiredate:"+employeeOutput2.getHireDate()+"\t"
									);	
			}
			else
			{
				System.out.println("employee already exists in the database");
			}
			*/
			
			System.out.println("=================================");
			System.out.println("Delete operation in Region:");
			String delete=new EmployeeController().deleteEmployee(1006);
			System.out.println(delete);
			
			
			
			
	}
	
	

}
