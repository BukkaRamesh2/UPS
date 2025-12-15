
package org.ups.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ups.exception.UserNotFoundException;
import org.ups.model.User;
import org.ups.service.UserServiceImpl;

@RestController
@RequestMapping("User")
public class UserController extends User{
	
	
	
//	public static void main(String[] args) {
//		User user = new User();
//		//user.getTest().streetName = "121212"; // aggregation
//		
//		user.zipCode = "213123123";  // extends
//		
//		UserController controller = new UserController();
//		controller.addUser("Samuel", "password");
//	}
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	 @PostMapping("/createUser")
     public void addUser(@RequestBody User user) {
		 userServiceImpl.addUser(user);
     }

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody User user) throws UserNotFoundException{
		userServiceImpl.updateUser(user);
	}
	
	@GetMapping("/getUser/{role}")
	public User getUser(@PathVariable String role) {
		 // create user object
		return userServiceImpl.getUser(role);
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userServiceImpl.deleteUser(userId); 
	}
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userServiceImpl.getAllUsers();
	}
	
	
	

}
