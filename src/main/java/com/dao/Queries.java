package com.dao;

public interface Queries {

	public String createStudent = "INSERT INTO `gtp5a_trainee`.`student` (`studentId`, `studentName`, `studentAge`, `studentGrade`) VALUES (?,?,?,?)";
}
