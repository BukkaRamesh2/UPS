package org.ups.model;

public class Admin extends AdminInfo {

   
    private String adminPassword;

    public Admin(Long adminId, String adminName, String adminEmail, 
                 String department, Integer phoneNumber, 
                 Boolean activeStatus, String adminPassword) {

        this.adminId = adminId;             // public → accessible
        setAdminName(adminName);            // private in parent → use setter
        this.adminEmail = adminEmail;       // protected → accessible
        this.department = department;       // default → same package → accessible
        setPhoneNumber(phoneNumber);        // private → use setter
        this.activeStatus = activeStatus;   // public → accessible

        this.adminPassword = adminPassword; // private in child
    }

    public void printAdminDetails() {
        System.out.println("----- ADMIN DETAILS (Access Specifiers Demo) -----");
        System.out.println("Admin ID       : " + adminId);             
        System.out.println("Admin Name     : " + getAdminName());      
        System.out.println("Admin Email    : " + adminEmail);          
        System.out.println("Department     : " + department);          
        System.out.println("Phone Number   : " + getPhoneNumber());    
        System.out.println("Active Status  : " + activeStatus);        
        System.out.println("Password       : " + adminPassword);       
    }
}
