package com.app.servicelayer;


import java.util.ArrayList;
import java.util.List;

import com.app.dao.StudentCrud;
import com.app.dao.StudentCrudImp;
import com.app.model.Student;

public class StudentService {
	public void addStudent(Student student){
		StudentCrud sc=new StudentCrudImp();
		sc.addStudent(student);
	}
	
	public List<Student> getAllStudent(){
		List<Student> lis=new ArrayList<>();
		StudentCrud sc=new StudentCrudImp();
		lis=sc.getAllStudent();
		return lis;
	}
	
	public void updateStudent(Student student){
		StudentCrud sc=new StudentCrudImp();
		sc.updateStudent(student);
	}
	
	public Student getStudentByName(String name){
		Student student=null;
		StudentCrud sc=new StudentCrudImp();
		student=sc.getStudentByName(name);
		return student;
	}
	
	public void deleteStudent(Student student){
		StudentCrud sc=new StudentCrudImp();
		sc.deleteStudent(student);
	}
}
