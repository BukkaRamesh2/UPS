package org.ups.controller;

import org.ups.model.User;

public class UserController extends User{
	
	public static void main(String[] args) {
		User user = new User();
		//user.getTest().streetName = "121212"; // aggregation
		
		user.zipCode = "213123123";  // extends
		
		UserController controller = new UserController();
		controller.addUser("Samuel", "password");
	}
	
	

}
