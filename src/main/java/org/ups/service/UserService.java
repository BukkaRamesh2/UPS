package org.ups.service;

import java.util.List;

import org.ups.model.User;

public interface UserService {
	
	
	public void addUser(User user);

	
	public void updateUser(User user);
	
	
	public User getUser(String role);
	
	
	public void deleteUser();
	
	public List<User> getAllUsers();
	
}
