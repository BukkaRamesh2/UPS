package org.ups.util;

import org.ups.model.User;

public class Test {
	
	
	String name;
	String password;
	
	public String streetName;
	public String zipCode;
	
	public Test(){
		System.out.println("default constructor of test is called");
		
	}// default constructir
	
	public Test(String name){
		System.out.println("name constructor of test is called");
		
	} // parameterised constructor

	public Test(String password, String name){
		System.out.println("name and password constructor of test is called");
		
	}// 2 params


	
	
	public static void main(String[] args) {
		System.out.println("Print this output in console");
		System.out.println(testUser());

	}
	
	
	
	public static String testUser() {
		System.out.println("Print this output in console");
		
		User user = new User();  // create object user
		user.setPassword("Test user name");  // called variable and assigned data to it 
		//user.password =    // private 
		//user.email = "test@gmail.com";
		
		
		return "Test";
	}

}
