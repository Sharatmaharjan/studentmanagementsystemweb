package com.app.dao;

import com.app.model.User;

public interface UserDao {
	public User login(User user) throws ClassNotFoundException;

}
