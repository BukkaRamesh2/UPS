package org.ups.service;

import java.util.List;

import org.ups.model.UpsCustomerSupport;
import org.ups.model.User;

public interface UserService {
    
    // Basic CRUD operations for User
    void addUser(User user);

    void updateUser(User user);

    User getUserByRole(String role);

    void deleteUser(int userId);

    List<User> getAllUsers();

    // Separate feature: reading UPS customer support data
    UpsCustomerSupport getUserById(int id);
}
