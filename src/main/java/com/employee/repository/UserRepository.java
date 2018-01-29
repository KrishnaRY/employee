package com.employee.repository;

import java.util.List;

import com.employee.model.RegisterUser;

public interface UserRepository {

	void persist(RegisterUser registerUser);
	List<RegisterUser> getAllUsers();
	void updateUser(RegisterUser registerUser);
	void deleteUser(int user_ID);
	int getUserCount(String username);
	List<RegisterUser> getUser(String username, String password);
	List<RegisterUser> getUser(int userId);
}
