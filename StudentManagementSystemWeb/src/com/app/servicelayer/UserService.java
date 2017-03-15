package com.app.servicelayer;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImp;
import com.app.model.User;

public class UserService {
	
	public User login(User user) throws ClassNotFoundException{
	UserDao userdao=new UserDaoImp();
	User user1=userdao.login(user);
//	if(user1.getUsername()==null){
//		System.out.println("Invalid username or password.");
//	}
//	else{
//		System.out.println("Welcome: "+user1.getUsername().toUpperCase());
//	}
	return user1;
	}
}
