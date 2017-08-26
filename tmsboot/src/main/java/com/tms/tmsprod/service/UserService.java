package com.tms.tmsprod.service;

import java.util.List;

import com.tms.tmsprod.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(String username);
	boolean addUser(User user);
	boolean userExist(User user);
}
