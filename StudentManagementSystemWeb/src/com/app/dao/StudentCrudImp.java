package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Student;

public class StudentCrudImp implements StudentCrud {
	Connection connect=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String username="root";
	String password="123456";
	String url="jdbc:mysql://localhost/studentdb";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connect=DriverManager.getConnection(url, username, password);
		return connect;
	}

	@Override
	public Student addStudent(Student student) {
		String query="insert into student values(?,?,?,?)";
		try {
			ps=getConnection().prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getSurname());
			ps.setString(4, student.getPhone());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connect.close();
				ps.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		String query="update student set address=?,surname=?,phone=? where name=?";
		try {
			ps=getConnection().prepareStatement(query);
			ps.setString(1, student.getAddress());
			ps.setString(2, student.getSurname());
			ps.setString(3, student.getPhone());
			ps.setString(4, student.getName());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		finally{
//			try {
//				connect.close();
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		return null;
	}

	@Override
	public Student deleteStudent(Student student) {
		String query="delete from student where name=?";
		try {
			ps=getConnection().prepareStatement(query);
			ps.setString(1, student.getName());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}

	@Override
	public List<Student> getAllStudent() {
		List<Student> std=new ArrayList<Student>();
		String query="select * from student";
		try {
			ps=getConnection().prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setSurname(rs.getString("surname"));
				student.setPhone(rs.getString("phone"));
				std.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connect.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return std;
	}

	@Override
	public Student getStudentByName(String name) {
		Student student=new Student();
		String query="select * from student where name=?";
		try {
			ps=getConnection().prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()){
				student.setAddress(rs.getString("address"));
				student.setSurname(rs.getString("surname"));
				student.setPhone(rs.getString("phone"));
				student.setName(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connect.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}

}
