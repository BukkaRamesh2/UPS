package org.ups.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.ups.model.User;

public class UserServiceImpl  implements UserService {
	
	public String streetName;
	public String zipCode;
	
	
	List<User> userList = new ArrayList<>();  // index starts from 0  numbers = [10,20,30,40]     numbers[3]
	
	List<String> loginHistory = new LinkedList<>();   // three bit memeory refernces  // [10,20,30,40]  10 [0|10|1] , [1|20|2] 
	
	Set<String> roleSet = new HashSet<>();
	//Set<String> roleSet = new LinkedHashSet<>();
	Set<String> sortedNames = new TreeSet<>(); // natural sorting order 
	
	Map<Integer, User> userMap = new HashMap<>();  // hash value  using equals methods validate the hash and save the data 
	Map<Integer, User> sortMap = new TreeMap<>();
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		if(user.getUserId() <= 0) {
			System.out.println("Invalid user id");
		} else {
			System.out.println("THe userID is valid userId: "+user.getUserId());
			
		}
		
		userList.add(user);
		userMap.put(user.getUserId().intValue(), user);
		roleSet.add(user.getRole());
		sortedNames.add(user.getUserName());
		sortMap.put(user.getUserId().intValue(), user);
		
		System.out.println("User added : "+user);
		
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		User u = userMap.get(user.getUserId());
		
		if(u != null && u.getUserName().contains("a")) {
			if(u.getRole().equals("user")) {
				System.out.println("User is updated" +u);
			}
		} else if(u.getUserName().contains("a")) {
			System.out.println("THe user contains a in his name");
		}
		else {
			System.out.println("User not found");
		}
		
		
	}
	
	@Override
	public User getUser(String role) {
		// TODO Auto-generated method stub
		
		
		
		switch(role) { // developer
		case "Admin":
			System.out.println("The role assigned is admin ");
			break;
		case "User"	:
			System.out.println("THe role assigned is user");
			break;
		case "Staff":
			System.out.println("THe role assigned is staff");
			break;	
		default :
			System.out.println("The role assigned is not exisits in our list");
			
		}
		
		
		return userMap.get(role);
	}
	
	
	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	/*
	 * 
	 *   class implements interface
	 *   class extends class
	 *   
	 *   interface cannot implents another interface 
	 *   it can only extends
	 * 
	 * 
	 * 
	 */

}
