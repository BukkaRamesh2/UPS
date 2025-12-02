package org.ups.service;

import org.ups.model.User;

public interface UserService {
	
	
	public User addUser(User user);

	
	public User updateUser(User user);
	
	
	public User getUser();
	
	public void deleteUser();
	
}
