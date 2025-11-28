package org.ups.model;

import java.time.LocalDate;

import org.ups.util.Test;

/*
 * 
 *   class
 *   variables
 *   
 *      access scpecifer, data type, name of the variable and assign a data to variable 
 *      
 *      public Integer userId = 123L;
 *      
 *      
 *       access specifiers 
 *       
 *       public  -- any one can access the data   (scope)
 *       private   -- the scope is only inside the class 
 *       protected  -- the scope of the data is only inside a package 
 *       default  -- if you don't specify any scope the dafault will be public 
 *       
 *       
 *      // single line commment 
 *      
 *      
 *      Varaibles 
 *      
 *     local   --- can be access only inside the methods
 *     global -- can be access trough out the class 
 *     static -- 
 *      
 *   
 *   
 *   methods
 *   
 *   
 *   interface  
 *   only methods 
 *   No imlementation can be done in interface
 *   
 *   abstract class
 *    only abstract data members can be accessed 
 *   
 *   
 *   enums
 *     constants 
 *     
 *     
 *     datatypes
 *     
 *        primitive data type 
 *        int 
 *        char
 *        String 
 *        boolean
 *         date
 *         
 *         
 *         INTEGER
 *         LONG
 *         
 *         
 *        non primitve data types 
 *     
 *      
 *      Packages
 *      
 *      model / POJO 
 *         plan old java objects  -- user
 *     controller
 *        you will have same classes but they controll the flow where to go and what to recieve
 *     service    
 *        interfaces and classes 
 *        to process the business logic the actual implemnetaion flow to validate data and send to your database
 *      repository
 *        the interface to save data to database or process any actual transactions db queries or joins your SQL 
 *      util 
 *        constants, enums any additional classes 
 *        
 *      
 *      // OOPS 
 *      
 *             Inheritance
 *                the process of getting prooeties from parent to child classes 
 *                key word to inherit the properties is "Extends"  "Aggregation" 
 *                
 *                class user extends addreess
 *                  username
 *                  userid 
 *                  
 *                  
 *                 multiple inheritance from multiple classes are not possible 
 *                  
 *                 
 *                  
 *                class address 
 *                  street
 *                  zipcode
 *                  house number
 *                  landmark  
 *                  
 *                user is going to acquire the propeties of address class 
 *                
 *                
 *             Polymorphism 
 *             Abstraction
 *             Encapsulation
 *             
 *             
 *             
 *             
 *      // Decision making statements 
 *          if 
 *          else
 *          
 *          nested if 
 *          
 *          switch 
 *          
 *      
 *         
 *             
 *      // Control Statements        
 *          
 *          Loops
 *          
 *          do 
 *          while 
 *          
 *          for loop 
 *          
 *          for each loop 
 *          
 *          break statement
 *          
 *          continue statement
 * 
 */


public class User extends Test{
	

	private Long userId;   //default
	
	private String userName;
	
	private String password;
	
	private String email;
	 
	private Integer phoneNumber;
	
	private Integer role;
	
	private LocalDate myObj = LocalDate.now(); // Create a date object	
	
	private boolean status;   // local or global 
	
	Test test;   // aggregation
	
	
	
	
	
	public Test getTest() {
		return test;
	}


	public void setTest(Test test) {
		this.test = test;
	}


	public User() {
		System.out.println("USer default constructor is called");
	}
	
	
	public User(String userName) {
		this.userName =  userName;
		System.out.println("USer userName constructor is called");
	}
	
	
   //getter and setter methods in your model or pojo classes
	
	
	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;   // this keyword refers to current class objects 
	}
	
	
	void addUser(){
		// business logic 
		userName = "12121212";
		String lastName = "Sam";  // local varaible 
		
	
		
		status = true;   
	}


//	void testUser() {
//		
//		userName = "Sam Adam";
//		//lastName = "Sam";   // defined this local variable 
//		
//		status = true;  
//	}

}
