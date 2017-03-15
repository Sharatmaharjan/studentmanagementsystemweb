package com.app.dao;

import java.util.List;

import com.app.model.Student;

public interface StudentCrud {
	Student addStudent(Student student);
	Student updateStudent(Student student);
	Student deleteStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentByName(String name);
	

}
