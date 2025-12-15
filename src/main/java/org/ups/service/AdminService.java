package org.ups.service;
import java.util.List;
import org.ups.model.Admin;

public interface AdminService {
	void addAdmin(Admin admin);
	void updateAdmin(Admin admin);
	Admin getAdmin(Long adminId);
	void deleteAdmin(Long adminId);
	List<Admin> getAllAdmins();

}
