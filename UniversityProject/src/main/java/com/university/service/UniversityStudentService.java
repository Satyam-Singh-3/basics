package com.university.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.entity.Student;
import com.university.entity.University;
import com.university.repository.StudentRepository;
import com.university.repository.UniversityRepository;

@Service
public class UniversityStudentService {

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private StudentRepository studentRepository;

	// Save All Students

	public University saveAll(University university) {
		return universityRepository.save(university);
	}

	// Get All students

	public List<University> getAllStudentsFromUniversity() {
		return universityRepository.findAll();
	}

	// Get students By Dept.Name

	public List<University> getByDeptName(String dept) {
		List<University> list = universityRepository.findByDept(dept);
		if (!list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<University>();
		}
	}

	// Fetch only low performing (marks below 40) students from Physics Dept.

	public List<Student> lessThanFourty(String dept) {
		List<University> universities = universityRepository.findByDept(dept);

		List<Student> students = new ArrayList<>();
		List<Student> stdList = null;
		for (University university : universities) {
			stdList = university.getStudent();
		}
		for (Student student : stdList) {
			if (student.getMarks() < 40) {
				students.add(student);
			}
		}

		return students;
	}

	// Fetch low performing (marks below 40) students from all depts

	public List<Student> lessThanFourtyForAllDepartment() {
		List<University> list = universityRepository.findAll();
		List<Student> lowPerformingStudentList = new ArrayList<>();

		for (University university : list) {
			List<Student> students = university.getStudent();
			for (Student student : students) {
				if (student.getMarks() < 40) {
					lowPerformingStudentList.add(student);
				}
			}
		}

		return lowPerformingStudentList;

	}

	// . Add 10 marks to all high performing students (marks above 60)

	public List<Student> addMarks() {
		List<University> list = universityRepository.findAll();
		List<Student> studentList = new ArrayList<Student>();
		for (University university : list) {
			List<Student> students = university.getStudent();
			for (Student student : students) {
				if (student.getMarks() > 60) {
					student.setMarks(student.getMarks() + 10);
					studentList.add(student);
				}
			}

		}
		studentRepository.saveAll(studentList);

		return studentList;

	}

	// Restricate or Remove all the least performing students (marks below 10)

	public List<Student> removeLeastPerformerStudent() {
		List<Student> studeList = studentRepository.findAll();
		List<Student> removeStudent = new ArrayList<>();
		for (Student student : studeList) {
			if (student.getMarks() < 10) {
				removeStudent.add(student);
			}
		}
		studentRepository.deleteAll(removeStudent);
		return removeStudent;
	}

	// Sort the students within their departments based on their marks

	public List<Student> sortStudentBasedOnMarks(String dept) {
		List<University> list = universityRepository.findByDept(dept);
		List<Student> sortedListOfStudent = new ArrayList<>();
		for (University university : list) {
			List<Student> students = university.getStudent();

			for (Student student : students) {
				sortedListOfStudent.add(student);
			}
		}
		Collections.sort(sortedListOfStudent, Comparator.comparing(Student::getMarks));
		return sortedListOfStudent;

	}

	// Sort the students within their departments based on their name

	public List<Student> sortStudentBasedOnNames(String dept) {
		List<University> list = universityRepository.findByDept(dept);
		List<Student> sortedListOfStudent = new ArrayList<>();
		for (University university : list) {
			List<Student> students = university.getStudent();

			for (Student student : students) {
				sortedListOfStudent.add(student);
			}
		}
		Collections.sort(sortedListOfStudent, Comparator.comparing(Student::getSname));

		return sortedListOfStudent;

	}

	// set student credit
	public String studentCredit(int id) {
		Student st = studentRepository.findById(id).get();
		
		LocalDate joiningDate = st.getJoiningDate();
		LocalDate passedoutdate = st.getPassedoutdate();
//		System.out.println(joiningDate);
//		System.out.println(passedoutdate);
		Long credits=null ;
		
		if(passedoutdate.getYear()-joiningDate.getYear()>=4)
		{
			Long diffDays = ChronoUnit.DAYS.between(joiningDate, passedoutdate);
			credits = diffDays*8;
			System.out.println(credits);
			st.setCredit(credits);
			
			studentRepository.save(st);
			System.out.println("hi");
			
		}
		
		
		
//		Student student = new Student();
//		LocalDate start_date = null;
//		LocalDate last_date = null;
//		start_date = student.getJoiningDate();
//		last_date = student.getPassedoutdate();
//		Long diffDays = ChronoUnit.DAYS.between(joiningDate, passedoutdate);
//		
//		System.out.println(diffDays);
//
//		Long total_credit = diffDays * 8;
//		students.setCredit(total_credit);
//
//		studentRepository.save(students);

		return "credit added to student\t" + credits;

	}
	
	
	public Student getStudentById(Integer sid) {
		Student student=studentRepository.findById(sid).get();
		return student;
	}
	

	public List<Student> getStudentByDeptId(Integer did) {
		University universities=universityRepository.findById(did).get();
		List<Student>students=universities.getStudent();
		return students;
	}
	
	public List<Student> getStudentBysname(String sname) {
		return studentRepository.getStudentBysname(sname);
		
	}

}