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
 *    
 *    
 *    
 *    
 *    Package   -- shashank goud
 *    
 *    tracking id
 *    order id
 *    weight
 *    dimensions
 *    count
 *    package location
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

 *    Admin console    -- Tejaswi
 *    
 *    
 *    
 *    Fraud detection -- shashank

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


@SpringBootApplication
public class UpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpsApplication.class, args);
		
	}

}
