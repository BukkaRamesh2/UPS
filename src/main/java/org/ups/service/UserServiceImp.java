package org.ups.service;

import java.util.HashMap;
import java.util.Map;

import org.ups.model.UpsCustomerSupport;

public class UserServiceImp implements UserService {

    // Temporary database (HashMap)
    private static Map<Integer, UpsCustomerSupport> db = new HashMap<>();

    @Override
    public UpsCustomerSupport createUser(UpsCustomerSupport user) {
        db.put(user.customerId, user);
        return user;
    }

    @Override
    public UpsCustomerSupport getUserById(int id) {
        return db.get(id);
    }

    @Override
    public UpsCustomerSupport updateUser(UpsCustomerSupport user) {
        db.put(user.customerId, user);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        return db.remove(id) != null;
    }
}
