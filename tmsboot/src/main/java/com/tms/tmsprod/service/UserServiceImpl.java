package com.tms.tmsprod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.tmsprod.dao.UserDao;
import com.tms.tmsprod.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(String username) {
		User obj = userDao.getUserById(username);
		return obj;
	}

	@Override
	public boolean addUser(User user) {
		if(userDao.userExist(user.getUsername())){
			return false;
		}else{
			userDao.addUser(user);
			return true;
		}
	}

	@Override
	public boolean userExist(User user) {
		String username = user.getUsername();
		String pass = user.getPassword();
		User used = this.getUserById(username);
		if(used!=null){
			if(used.getPassword().equals(pass) && used.getUsername().equals(username)){
				return true;
			}else{
				return false;
			}
		} else {
			return false;
		}
		
	}
}
