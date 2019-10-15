package com.vastika.userinfosystem.dao;

import java.util.List;

import com.vastika.userinfosystem.model.User;

public interface UserDao {
	
	int saveUser(User user);
	
	List<User> getAllUserInfo();
	
	void deleteUserInfo(int id);				// creating method for delete button in the user table.
	
	int updateUser(User user);

}
