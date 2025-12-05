package org.ups.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Updated executable Java service with full CRUD and use of all collections
//NOTE: This is a demo-style implementation

import java.util.*;

import org.ups.model.User;

public class UserServiceImpl implements UserService {

 // Basic fields
 public String streetName;
 public String zipCode;

 // Collections
 List<User> userList = new ArrayList<>();                // ArrayList
 List<String> loginHistory = new LinkedList<>();         // LinkedList
 Set<String> roleSet = new HashSet<>();                  // HashSet
 Set<String> orderedRoleSet = new LinkedHashSet<>();     // LinkedHashSet
 Set<String> sortedNames = new TreeSet<>();              // TreeSet

 Map<Integer, User> userMap = new HashMap<>();           // HashMap
 Map<Integer, User> sortedMap = new TreeMap<>();         // TreeMap
 Map<Integer, User> orderedUserMap = new LinkedHashMap<>(); // LinkedHashMap

 @Override
 public void addUser(User user) {
     System.out.println("--- ADD USER ---");

     if (user.getUserId() <= 0) {
         System.out.println("Invalid user id");
         return;
     }

     System.out.println("Valid userId: " + user.getUserId());

     // Add to collections
     userList.add(user);
     loginHistory.add("User Added: " + user.getUserName());
     roleSet.add(user.getRole());
     orderedRoleSet.add(user.getRole());
     sortedNames.add(user.getUserName());

     userMap.put(user.getUserId().intValue(), user);
     sortedMap.put(user.getUserId().intValue(), user);
     orderedUserMap.put(user.getUserId().intValue(), user);

     System.out.println("User added: " + user);
     System.out.println("Current Users in ArrayList: " + userList);
     System.out.println("Current Roles (HashSet): " + roleSet);
     System.out.println("Current Names (TreeSet): " + sortedNames);
 }

 @Override
 public void updateUser(User user) {
	 
	 
	 File file = new File("E://test//test.txt");
	 
	 
		FileReader fr;
		try {
			fr = new FileReader(file);	
			fr.read();
			System.out.println("File is not closed");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();   
			//throw new 
		}  // here we got an exception
	
	 finally {
		System.out.println("From finally block File is not closed");
	}
	 
	 
	 int numbers[] = {1,2,3,4,5};
	 System.out.println(numbers[6]);
	 
	 
	 
     System.out.println("--- UPDATE USER ---");

     User existing = userMap.get(user.getUserId());

     if (existing == null) {
         System.out.println("User not found by ID");
         return;
     }

     // Decision making
     if (existing.getUserName().contains("a") || existing.getUserName().contains("A")) {
         System.out.println("Name contains 'a', updating user...");
     } else {
         System.out.println("Name does not contain 'a', updating anyway");
     }

     // Updating fields
     existing.setUserName(user.getUserName());
     existing.setRole(user.getRole());

     System.out.println("User updated: " + existing);
 }

 @Override
 public User getUser(String role) {
     System.out.println("--- GET USER BY ROLE ---");

     switch (role) {
         case "Admin":
             System.out.println("Role is Admin");
             break;
         case "User":
             System.out.println("Role is User");
             break;
         case "Staff":
             System.out.println("Role is Staff");
             break;
         default:
             System.out.println("Role not found in system");
     }

 
     
     // Loop through user map to return the one matching role
     for (User u : userMap.values()) {
         if (u.getRole().equalsIgnoreCase(role)) {
             System.out.println("User found: " + u);
             return u;
         }
     }

     System.out.println("No user with given role");
     return null;
 }

 @Override
 public void deleteUser() {
     System.out.println("--- DELETE USER ---");

     if (userList.isEmpty()) {
         System.out.println("No users to delete");
         return;
     }

     // Delete last user (example)
     User removed = userList.remove(userList.size() - 1);  // 4 -1
     userMap.remove(removed.getUserId());
     sortedMap.remove(removed.getUserId());
     orderedUserMap.remove(removed.getUserId());

     System.out.println("Deleted user: " + removed);
 }

 @Override
 public List<User> getAllUsers() {
     System.out.println("--- GET ALL USERS ---");

     for (User u : userList) {
         System.out.println("User: " + u);
     }

     return userList;
 }
 
 
 
//MAIN METHOD FOR TESTING


public static void main(String[] args) {
  
UserServiceImpl service = new UserServiceImpl();   // object for 

  // Create sample users
User u1 = new User(101L,"john_doe","password@123","john.doe@example.com",987654321,"ADMIN", true);  
User u2 = new User(102L,"Ramesh","password@123","john.doe@example.com",23123,"User", true);
User u3 = new User(103L,"Kiran","password@123","john.doe@example.com",2423423,"Staff", true);
User u4 = new User(104L,"Lokesh","password@123","john.doe@example.com",45345345,"User", true);
User u5 = new User(105L,"Anita","password@123","john.doe@example.com",435345345,"ADMIN", true);


User v6 = new User("Ram", 1123123L, true);  // 

  // ADD USERS
  service.addUser(u1);
  service.addUser(u2);
  service.addUser(u3);
  service.addUser(u4);
  service.addUser(u5);

  // UPDATE USER
  User updated = new User(101L,"Sam","password@123","john.doe@example.com",987654321,"ADMIN", true);
  service.updateUser(updated);

  // GET USER BY ROLE
  service.getUser("Admin");

  // DELETE LAST USER
  service.deleteUser();

  // GET ALL USERS
  service.getAllUsers();
} 



 
}




//==========================================================
//COLLECTIONS EXPLANATION & PERFORMANCE JUSTIFICATION
//==========================================================
/*
 WHY WE USE MULTIPLE COLLECTION TYPES

 ------------------------------------------------------------
 1. ArrayList
 ------------------------------------------------------------
 ✔ Fast for reading (index-based O(1))
 ✔ Best for random access
 ✘ Slow for manipulation (add/remove in middle → O(n))

 WHY? Internally uses dynamic array → shifts elements.

 ------------------------------------------------------------
 2. LinkedList
 ------------------------------------------------------------
 ✔ Fast for insertion/deletion at beginning or middle (O(1))
 ✘ Slow for reading (no index, must traverse → O(n))

 WHY? Doubly linked list → each node stores next/prev pointer.

 ------------------------------------------------------------
 3. HashSet
 ------------------------------------------------------------
 ✔ Stores ONLY UNIQUE values
 ✔ Fast performance (O(1) average insert/search)
 ✘ Does NOT maintain order

 WHY? Uses hash table internally.

 ------------------------------------------------------------
 4. LinkedHashSet
 ------------------------------------------------------------
 ✔ Unique values
 ✔ Maintains insertion order
 ✘ Slightly slower than HashSet

 WHY? Hybrid → Hash table + Linked list.

 ------------------------------------------------------------
 5. TreeSet
 ------------------------------------------------------------
 ✔ Unique + Sorted order
 ✘ Slowest among sets (O(log n))

 WHY? Uses Red-Black Tree (balanced binary tree).

 ------------------------------------------------------------
 6. HashMap
 ------------------------------------------------------------
 ✔ Key-value storage
 ✔ Fastest map (O(1) average)
 ✘ No order guarantee

 WHY? Uses hashing.

 ------------------------------------------------------------
 7. LinkedHashMap
 ------------------------------------------------------------
 ✔ Maintains insertion order
 ✔ Slightly slower than HashMap

 WHY? Hash table + doubly linked list.

 ------------------------------------------------------------
 8. TreeMap
 ------------------------------------------------------------
 ✔ Sorted map (ascending key order)
 ✘ Slower (O(log n))

 WHY? Uses Red-Black tree.

 ------------------------------------------------------------
 SUMMARY TABLE
 ------------------------------------------------------------

 COLLECTION TYPE   | ORDER     | UNIQUE | SPEED
 -------------------------------------------------------------
 ArrayList         | Indexed   | No     | Fast read, slow insert
 LinkedList        | Linked    | No     | Fast insert, slow read
 HashSet           | None      | Yes    | Fastest set
 LinkedHashSet     | Insertion | Yes    | Ordered set
 TreeSet           | Sorted    | Yes    | Slowest set
 HashMap           | None      | N/A    | Fastest map
 LinkedHashMap     | Insertion | N/A    | Ordered map
 TreeMap           | Sorted    | N/A    | Slowest map

*/

