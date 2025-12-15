package org.ups.service;


import java.util.List;

import org.ups.exception.InvalidUserException;
import org.ups.exception.UserNotFoundException;
import org.ups.model.User;

public interface UserService {
	
	
	public void addUser(User user);

	
	public void updateUser(User user) throws UserNotFoundException;
	
	
	public User getUser(String role);
	
	
	public void deleteUser(Long userId);
	
	public List<User> getAllUsers();
	
}
