package com.example.demo.service;

import java.util.List;

import com.example.demo.Models.Student;

public interface StudentService {

	 String saveStudent(Student student);

	List<Student> getAllStudents();
	
	Student updateStudent(String id, String name, String address);
	
	Student removeStudent(String id);
	
}
