package com.third.project3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.third.project3.model.Student;
import com.third.project3.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/get")
	public ResponseEntity<List<Student>> getStudent()
	{
		List<Student> student=service.getStudents();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/st/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getEmployee(@PathVariable("id") int id)
	{
		Student st = service.getStudentById(id);
		if (st == null)
		{
			return new ResponseEntity<Student>(st,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(st, HttpStatus.OK);
}
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String saveStudent(@Valid @RequestBody Student student ) {
		
		String st = service.save(student);
		return st;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public String update(@Valid @RequestBody Student student) {
		
		String st = service.update(student);
		return st;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public String update(@Valid @RequestBody @PathVariable ("id") int id) {
		
		String st = service.delete(id);
		return st;
	}
	
	

}
