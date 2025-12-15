package org.ups.model;

public class AdminInfo {
	
    public Long adminId;
    private String adminName;
    protected String adminEmail;
    protected String department;
    private Integer phoneNumber;
    public Boolean activeStatus;
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
