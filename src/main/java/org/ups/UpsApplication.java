package org.ups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ups.model.User;
import org.ups.util.Test;



/*
 * 
 * 
 * 
 *    User managment  -- Ramesh
 *    
 *    
 *    
 *    
 *    Shipping management --  Ahmed
 *    
 *    shipping Id 
 *    senderAddress
 *    reciverAddress
 *    shipmentType
 *    shipmentStatus
 *    createdDate
 *    estimatedDate
 *    
 *    
 *    
 *    Billing component   -- Venkat 
 *    Good
 *    
 *    
 *    
 *    Package   -- shashank goud
 *    
 *    
 *    
 *    Inventory / Warehouse  -- Srujan 
 *    
 *    
 *    
 *    Notification --  vaishnavi
 *    Good 
 *    
 *    
 *    
 *    Customer support    --- veronica
 *    
 *    
 *    
 *    
 *    

 *    Admin console    -- Tejaswi
 *    Good
 *    

 *    Admin console -- tejaswi
 *  

 *    
 *    Fraud detection -- shashank P
       Good
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



@SpringBootApplication
public class UpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpsApplication.class, args);
		String name = "sadasd";
		Test user = new Test(name);  // create new object default consructopr 
		
	}

}
