package org.ups.model;

import java.time.LocalDate;
import java.util.Objects;

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
 *                method overloading --  
 *                   saveUser(sting userName)
 *                   
 *                   saveUser(String userName, String address)
 *                   
 *                   
 *                
 *                method overiding   -- the data ;ogic willl be pulled from the very latest method 
 *                    saveUser(String  userName)
 *                      save user and validate age
 *                    
 *                    saveUser(String userName)
 *                     save user with out any validation 
 *                
 *             
 *             
 *             
 *             Abstraction
 *                hiding the data memebers visible to other classes 
 *             
 *             Encapsulation  
 *             
 *                wrappinf od data memebers and business logic togeteher 
 *                POJO classes or entity classes 
 *             
 *             
 *             
 *             
 *      // Decision making statements 
 *          if 
 *          if
 *          if
 *          if
 *          if
 *          
 *          else
 *          
 *          nested if 
 *          
 *          switch 
 *          
 *          if(condition){
 *          business logic
 *          }
 *          
 *           if(condition){
 *              business logic
 *          } else {
 *             give a valid logic
 *          }
 *          
 *           if(condition1){
 *               if(condition 2){
 *               business logic
 *               }
 *          } else {
 *             give a valid logic
 *          }
 *          
 *           if(condition1){
 *               if(condition 2){
 *               business logic
 *               }
 *          } else if(condition 3){
 *             give a valid logic
 *          } else {
 *              none of your condition matches
 *          }
 *          
 *          
 *          switch(condition):
 *          case 1: 
 *          logic
 *          break;
 *          case 2:
 *          logic
 *          break;
 *          case 3:
 *          break;
 *          default: 
 *             logic 
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
 *          
 *          
 *         Collections 
 *           // Interfaces and classes 
 *          
 *           LIST   -- arraylist tjhe data is stored in arrays format 
 *              will save duplicate data
 *              will not follow any specific order 
 *           SET   -- will not store any duplicate values and set maintains insertion order and also natural sorting order 
 *             hascode and equals mechanism 
 *             data member the set colelction will generate hascode that is of interger data type 
 *             equals methos is going to validate the genetrated hascode the data type is boolean 
 *             
 *           
 *           MAP   -- Key value format 
 *              -- duplcaiutes -- maintains insertion order and also natural sorting order
 *              hashmap
 *              
 *              
 *              
 *            Classes 
 *                 LIST -- Arraylist and LinkedList
 *                 SET  -- HashSet, LinkedHashSet and TreeSet
 *                 MAP -- HashMap, LinkedHashMap and TreeMap
 *                 
 *                 
 *              List<User> 
 *          
 *          
 *          
 *          // Exceptions 
 *          
 *          Checked exceptions
 *            compile time errors 
 *            
 *            the compile will gives the info when you declare the code most of the time
 *          
 *          Unchecked exceptions
 *            run time errors
 *            
 *            the systeem will allows you to write the coide but when you execute the program the run time will chow you an error 
 *            
 *            
 *            to handle any exception 
 *            
 *            
 *            try and catch 
 *            
 *            try{
 *            
 *              business logic
 *               file operations 
 *               opened file 
 *               write data in file 
 *               unfortuna,ty we got an exception // it wont execute the next set of code comes out of the block 
 *               file save 
 *               file close 
 *              
 *            } catch(Exception e | FileNotFoundException | ArrarIndexOutOfBoundException ) {
 *                e.printStackTrace();
 *            }
 *            
 *            finally {
 *               if exceptions occurs or does not occurs the finally block will execute for 100%
 *              file.close();
 *            }
 *            
 *            throws  
 *            
 *             followed by method name
 *            
 *            throw
 *              will be called inside catch block 
 *              this is usded most of the time for custom exceptions logic 
 *              
 *              throw new Exception();
 *              
 *            
 *             
 *          
 * 
 */


public class User extends Test{
	

	private Long userId;   //default
	
	private String userName;
	
	private String password;
	
	private String email;
	 
	private Integer phoneNumber;
	
	private String role;
	
	private LocalDate myObj = LocalDate.now(); // Create a date object	
	
	private boolean status;   // local or global 
	
	Test test;   // aggregation
	
	
	
	public User(String userName, Long userId, boolean status) {
		this.userName = userName;
		this.userId = userId;
		this.status = status;
	}
	
	public User(Long userId, String userName, String password, String email, Integer phoneNumber, String role,
			boolean status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.status = status;
	}


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
	
	
	
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", role=" + role + ", myObj=" + myObj + ", status=" + status
				+ ", test=" + test + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, phoneNumber, role, status, userId, userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(role, other.role)
				&& status == other.status && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}


	public void addUser(String userName){
		// business logic 
		userName = "12121212";
		String lastName = "Sam";  // local varaible 
		
	    System.out.println("called a method with 1 params");

	
		
		status = true;   
		
		
	}
	
	public void addUser(String userName, String password){
		// business logic 
		userName = "12121212";
		String lastName = "Sam";  // local varaible 
		
	    System.out.println(" user class called a method with 2 params");
		
		status = true;   
	}
//	
	


//	void testUser() {
//		
//		userName = "Sam Adam";
//		//lastName = "Sam";   // defined this local variable 
//		
//		status = true;  
//	}

}
