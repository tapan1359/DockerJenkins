package com.third.project3.service;

import java.util.List;

import com.third.project3.model.Student;

public interface StudentService {
	public List<Student> getStudents();
	
	Student getStudentById(int id );
	
	String save(Student st);
	
	String update(Student st);
	
	String delete(int id);

}
