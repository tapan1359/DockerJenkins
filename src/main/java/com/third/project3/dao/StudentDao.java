package com.third.project3.dao;

import java.util.List;

import com.third.project3.model.Student;

public interface StudentDao {
	
	public List<Student> getStudents();
	
	Student getStudentById(int id );

	String save(Student st);
	
	String update(Student st);
	
	String delete(int id);
}

