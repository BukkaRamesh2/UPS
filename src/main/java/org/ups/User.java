package org.ups.model;

import java.time.LocalDate;

/*
 * 
 *   class
 *   variables
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
 *     
 *     
 * 
 */

public class User {
	
	
	Long userId;
	
	String userName;
	
	String password;
	
	String email;
	 
	Integer phoneNumber;
	
	Integer role;
	
    LocalDate myObj = LocalDate.now(); // Create a date object	
	
	boolean status;

}
