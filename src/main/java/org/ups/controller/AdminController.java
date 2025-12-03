package org.ups.controller;

import org.ups.model.Admin;

public class AdminController {

    public static void main(String[] args) {

        Admin admin = new Admin(1001L,"Tejaswi","teja@ups.com","Operations",987654321,true,"root123");
        admin.printAdminDetails();
    }
}
