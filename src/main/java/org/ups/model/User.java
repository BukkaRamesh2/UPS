package org.ups.model;

import java.time.LocalDate;

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
 *     
 *     
 * 
 */


public class User {
	
	
	

	Long userId;   //default
	
	public String userName;
	
	private String password;
	
	protected String email;
	 
	Integer phoneNumber;
	
	Integer role;
	
    LocalDate myObj = LocalDate.now(); // Create a date object	
	
	boolean status;   // local or global 
	
	
	void addUser(){
		// business logic 
		userName = "12121212";
		String lastName = "Sam";  // local varaible 
		
	
		
		status = true;   
	}
	
	void testUser() {
		
		userName = "Sam Adam";
		//lastName = "Sam";   // defined this local variable 
		
		status = true;  
	}

}
