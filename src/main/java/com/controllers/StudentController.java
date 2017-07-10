package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pojos.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	public StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseStatus(value= HttpStatus.OK)
	public @ResponseBody boolean createStudent( Student student){
		System.out.println("Information received from Student: "+student);
		boolean result = studentService.createStudent(student);
		return result;
	}

}
