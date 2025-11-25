package org.ups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ups.model.Test;
import org.ups.model.User;



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
 *    
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
 *    
 *    
 *    
 *    
 *    Customer support    --- veronica
 *    
 *    
 *    
 *    
 *    
 *    
 *    Admin console    
 *    Fraud detection -- shashank
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
