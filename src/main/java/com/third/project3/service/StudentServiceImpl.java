package com.third.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.third.project3.dao.StudentDao;
import com.third.project3.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;
	
	@Override
	public List<Student> getStudents() {
		return dao.getStudents();
	}
	
	@Override
	public Student getStudentById(int id )
	{
		Student st =  dao.getStudentById(id);
		return st;
}

	
	public String save(Student st) {
		dao.save(st);
		return "Created!!";
	}
	
	public String update(Student st) {
		dao.update(st);
		return st + "updated!!";
	}

	@Override
	public String delete(int id) {
		dao.delete(id);
		return id + "---" + "Deleted!!";
	}
}
