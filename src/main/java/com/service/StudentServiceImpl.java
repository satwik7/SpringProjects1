package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.pojos.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentDao studentdao;
	
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	public boolean createStudent(Student student) {
		System.out.println("Information received to service layer "+student);
		boolean result = studentdao.createStudent(student);
		return result;
	}
	

}
