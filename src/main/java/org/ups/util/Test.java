package org.ups.util;


import org.springframework.stereotype.Component;
import org.ups.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



/*
 * 
 * 
 *    Exceptions
 *    Collections 
 *    Control statements
 *    Decision making statements
 *    
 *    Files 
 *    Comparable and Comparator 
 *    Multi Threading -- Sync 
 *    
 *    
 *      Spring Boot application 
 *         Develop Rest API Applicaition 
 *         data might be JSON / XML formats
 *         Independent application  --- we will be having only backend service 
 *         Multiple Services can communicate each other via Sync or Async
 *         It has inbuild database H2 and Test component built in, appliciation server default Tomcat server
 *         All the communication betwwen classes will be happend via Annotations
 *         
 *         annotations will be detetced after adding libraries in your pom.xml
 *         Lombok 
 *         Spring Data JPA
 *         Spring boot parent 
 *         Spring Web  -- COntroller Service
 *         H2  -- library
 *         
 *           @Autowired -- to create object of classes to commincate all the data members 
 *         
 *         1.Model /  Entity / POJO 
 *            User.java  -- data memebrs associated to the class no business logic
 *            Getter and Setter, TOstring, Construcotrs
 *            
 *            @Entity -- it database object 
 *            @Table -- database table name 
 *                 
 *                 @ID  -- LONG 
 *                 @GeneratedValue
 *            
 *            Lombok library for getter
 *            
 *            @GEtter
 *            @Setter
 *            @Data 
 *            @Constructor
 *            @AllArgsConstr
 *            
 *            
 *         2.Controller 
 *           REST ENd points to process the URL mappings
 *           
 *             https:google.com/createUser
 *             
 *             https://www.geeksforgeeks.org/java/spring-mvc-create-registration-form-using-form-tag-library/ -- 
 *             
 *             
 *             HTTP Verbs   -- POST, GET, PUT, DELETE, PATCH
 *             The controllor recives the data from URL and parse it validate it and send it back to Service layer to validate the business logic  
 *             
 *             
 *             @RESTController
 *             @PUTMapping @POSTMapping @GetMapping @DeleteMapping 
 *             @RequestBody @ResponseBody
 *             @PathParam @PathVaraible
 *             
 *             
 *             
 *         3.Service
 *           Interface  -- User Service  --  abstract methods  -- CRUD 
 *           Class  --  UserServiceImpl -- Implements User Interface and write bussniess logic 
 *           once the data is processed sending the data to repository layer to save in database 
 *           
 *           @Service 
 *           
 *           
 *         4.Repository
 *          
 *             @Repository 
 *           
 *             JPA -- SQL queries 
 *             Save
 *             Get
 *             find
 *          
 *          Interface -- extends Class  JPA Reposiroty to perform CRUD functions via SQL queries 
 *          
 *          
 *         5.UTIL 
 *           
 *            Constants -- 
 *            
 *         
 *         6.Exceptions
 *         
 *            Custom exceptions for your classes
 *            
 *            
 *            Annotatins used in Spring boot 
 *         
 *         
 *      
 *      Spring MVC 
 *         Model  --  Components 
 *         View -- UI layers
 *         Controller  -- Backed logic 
 *         
 *         No built in applicaition server 
 *         
 *         Web.xml
 *         
 *         Dispatch Servlet 
 *         Inverstion of Control 
 *         
 *         
 *         
 *         
 *    
 *     
 *      Class extends Class    -- Inheritance 
 *      Class cannot extends Interface
 *      
 *      Class implements Interface   --
 *      
 *      Interface extends Class 
 *      
 *      
 *      
 *      
 *      
 *      
 *    
 *    
 *    
 * 
 * 
 * 
 */

//@Entity
//@Table
class TestThread extends Thread {
	
	private Thread t;
	private String threadName;
	
	@jakarta.persistence.Id
	public Long Id;
	
	
	TestThread(String name){
		threadName = name;
		System.out.println("Creating Thread :" + threadName);
	}
//	
//	
//	String name;
//	String password;
//	
//	public String streetName;
//	public String zipCode;
//	
//	public Test(){
//		System.out.println("default constructor of test is called");
//		
//	}// default constructir
//	
//	public Test(String name){
//		System.out.println("name constructor of test is called");
//		
//	} // parameterised constructor
//
//	public Test(String password, String name){
//		System.out.println("name and password constructor of test is called");
//		
//	}// 2 params
//
//
//	
//	
//	public static void main(String[] args) {
//		System.out.println("Print this output in console");
//		System.out.println(testUser());
//
//	}
//	
//	
//	
//	public static String testUser() {
//		System.out.println("Print this output in console");
//		
//		User user = new User();  // create object user
//		user.setPassword("Test user name");  // called variable and assigned data to it 
//		//user.password =    // private 
//		//user.email = "test@gmail.com";
//		
//		
//		return "Test";
//	}
//	
//	public void addUser(String userName, String password){
//		// business logic 
//		userName = "12121212";
//		String lastName = "Sam";  // local varaible 
//		
//	    System.out.println(" test class method with 2 params");
//		
//		//status = true;   
//	}\
	
	public void count() {
		System.out.println("Running : " +threadName);
		try {
			for(int i = 6; i>0; i--) {
				System.out.println("Thread : " +threadName + ", " +i);
				Thread.sleep(5000);

			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
			System.out.println("Thread : " +threadName + "Interrupted");

		}
	}

	@Override
	public void run() {
		
		synchronized (t) {
			count();
		
		
	}
	
		System.out.println("Thread " +threadName + "exiting.");
	}
	
	public void start() {
		System.out.println("Starting : " +threadName);
        if (t == null) {
        	t =  new Thread(this, threadName);
        	t.start();  // will callss thread run methods by default
        }
		
		
	}


}

public class Test{
	
	public static void main(String[] args) {
		TestThread T1 = new TestThread("Thread-1");   // Runnable
		T1.start();
		
		TestThread T2 = new TestThread("Thread-2");
		T2.start();
		
		TestThread T3 = new TestThread("Thread-3");
		T3.start();
	}
	
}
