package org.ups.controller;

import org.ups.model.Admin;
import org.ups.service.AdminService;
import org.ups.service.AdminServiceImpl;

public class AdminController {

    public static void main(String[] args) {

        AdminService adminService = new AdminServiceImpl();

        Admin a1 = new Admin(1L, "Anil", "anil@gmail.com", 
                             "Finance", 987654321, true, "pass123");

        Admin a2 = new Admin(2L, "Kiran", "kiran@gmail.com", 
                             "IT", 987650000, true, "secure@99");

        Admin a3 = new Admin(3L, "Arjun", "arjun@gmail.com", 
                             "HR", 998877665, false, "hello123");

        adminService.addAdmin(a1);
        adminService.addAdmin(a2);
        adminService.addAdmin(a3);

        adminService.getAllAdmins();

        Admin admin = adminService.getAdmin(1L);
        if (admin != null) {
            admin.printAdminDetails();
        }

        Admin updated = new Admin(2L, "Kiran Kumar", "kiran@gmail.com",
                                  "IT", 987650000, true, "secure@99");
        adminService.updateAdmin(updated);

        adminService.deleteAdmin(3L);

        adminService.getAllAdmins();
    }
}
