package org.ups.service;
import java.util.*;
import org.ups.model.Admin;

public class AdminServiceImpl implements AdminService{
	List<Admin> adminList = new ArrayList<>();
	Set<String> departmentSet = new HashSet<>();
	Map<Long, Admin> adminDetails = new HashMap<>();
	Set <String> sortedNames = new TreeSet<>();
	
	  @Override
	    public void addAdmin(Admin admin) {
	        System.out.println("## ADDING ADMIN ##");
	        if (admin.adminId <= 0) {
	            System.out.println("Invalid Admin ID!");
	            return;
	        } else {
	            System.out.println("Admin ID is valid.");
	        }

	        adminList.add(admin);
	        departmentSet.add(admin.getDepartment());
	        sortedNames.add(admin.getAdminName());
	        adminDetails.put(admin.adminId, admin);

	        System.out.println("Admin added: " + admin.getAdminName());
	    }

	  @Override
	  public void updateAdmin(Admin admin) {
		System.out.println("## UPDATING THE ADMIN ##");
		Admin existing = adminDetails.get(admin.adminId);
		if(existing == null) {
			System.out.println("Admin not found");
			return;
		}
		
		if(existing.getAdminName().startsWith("A")) {
			System.out.println("Name starts with A");
		}
		else {
			System.out.println("Name does not start with A");
		}
		existing.setAdminName(admin.getAdminName());
		existing.setPhoneNumber(admin.getPhoneNumber());
		
		System.out.println("Admin Details Updated");
	  }

	  @Override
	  public Admin getAdmin(Long adminId) { 
		  System.out.println("Fetching Admin Details");
		  switch (adminId.intValue()) {
          case 1:
              System.out.println("Special admin account");
              break;
          default:
              System.out.println("Regular admin");
      }

      return adminDetails.get(adminId);
	  }

	  @Override
	  public void deleteAdmin(Long adminId) {
	      System.out.println("Trying to delete Admin Details");

	      Admin removed = adminDetails.remove(adminId);

	      if (removed == null) {
	          System.out.println("Admin not found.");
	          return;
	      }

	      
	      adminList.remove(removed);

	      
	      sortedNames.remove(removed.getAdminName());
	      departmentSet.remove(removed.getDepartment());

	      System.out.println("Deleted Admin Details: " + removed.getAdminName());
	  }

		
	  

	  @Override
	  public List<Admin> getAllAdmins() {
		  System.out.println("ALL ADMINS:");

	        for (Admin a : adminList) {
	            System.out.println(a.getAdminName());
	        }

	        return adminList;
	    }
}
	
	
	


