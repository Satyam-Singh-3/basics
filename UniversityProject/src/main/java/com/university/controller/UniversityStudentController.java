package com.university.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university.entity.Student;
import com.university.entity.University;
import com.university.service.UniversityStudentService;

@RestController
public class UniversityStudentController {

	@Autowired
	UniversityStudentService service;

	@PostMapping("/save")
	public University saveAllStudent(@RequestBody University university) {
		return service.saveAll(university);
	}

	@GetMapping("/get")
	public List<University> findAllStudentsFromUniversity() {
		return service.getAllStudentsFromUniversity();
	}

	@GetMapping("/find/{dept}")
	public List<University> findStudent(@PathVariable String dept) {
		return service.getByDeptName(dept);
	}

	@GetMapping("/low_performane/{dept}")
	public List<Student> lessThan(@PathVariable String dept) {
		return service.lessThanFourty(dept);

	}

	@GetMapping("/get_low")
	public List<Student> lessThanFourt() {
		return service.lessThanFourtyForAllDepartment();
	}

	@GetMapping("/add_marks")
	public List<Student> getHighPerformerStudent() {
		return service.addMarks();
	}

	@DeleteMapping("/remove")
	public List<Student> removeLeatPerformerStudent() {
		return service.removeLeastPerformerStudent();
	}

	@GetMapping("/sort_By_marks/{dept}")
	public List<Student> getSortedStudentByMarks(@PathVariable String dept) {
		return service.sortStudentBasedOnMarks(dept);
	}

	@GetMapping("/sort_By_names/{dept}")
	public List<Student> getSortedStudentByNames(@PathVariable String dept) {
		return service.sortStudentBasedOnNames(dept);
	}

	@GetMapping("/credit/{id}")
	public String getCredit(@PathVariable int id) {
		return service.studentCredit(id);
	}

	
	  @GetMapping("/get_by_id/{id}")
	  public Student getStudentByid(@PathVariable Integer id) { 
		  return service.getStudentById(id); 
		  }
	  
	  @GetMapping("/get_by_deptid/{did}") 
	  public List<Student>getStudentByDeptId(@PathVariable Integer did){ 
		  return  service.getStudentByDeptId(did);
		  }
	  
	  @GetMapping("get_student_by_name/{sname}")
	  public List<Student> getStudentBysname(@PathVariable String sname) {
	  return service.getStudentBysname(sname);
}
}
