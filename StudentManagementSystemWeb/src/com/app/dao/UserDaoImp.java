package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.model.User;


public class UserDaoImp implements UserDao {
	Connection connect=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	String username="root";
	String password="123456";
	String url="jdbc:mysql://localhost:3306/userdb1";
	
	public Connection getConnection() throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}

	

	@Override
	public User login(User user) throws ClassNotFoundException {
		User user1=new User();
		String query="select * from user where username=? and password=?";
		try {
			ps=getConnection().prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());	//what if no user exists? rs=null. 
			rs=ps.executeQuery();
			while(rs.next()){		//if(rs!=null)
				user1.setUsername(rs.getString("username"));
				user1.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		
		return user1;
	}

}
