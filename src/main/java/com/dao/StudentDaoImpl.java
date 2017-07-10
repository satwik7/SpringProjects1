package com.dao;

import java.sql.SQLDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pojos.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	public boolean createStudent(Student student) {
		System.out.println("Info recieved to Dao layer: " + student);
		int noOfRecordsUpdated = 0;

		try {
			noOfRecordsUpdated = jdbcTemplate.update(Queries.createStudent, new Object[] { student.getStudentId(),
					student.getStudentName(), student.getStudentAge(), student.getStudentGrade() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			noOfRecordsUpdated = 0;
		}
		if (noOfRecordsUpdated != 0) {
			return true;
		} else {
			return false;
		}
	}
}