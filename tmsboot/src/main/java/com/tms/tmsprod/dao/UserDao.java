package com.tms.tmsprod.dao;

import java.util.List;

import com.tms.tmsprod.model.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUserById(String username);
	void addUser(User user);
	boolean userExist(String username);
}
