package org.ups.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class NotificationImpl extends Notifications {

	static class NotificationList {
		public void notifList() {
		try { 
	        ArrayList<String> arrayList = new ArrayList<>();  // Creating ArrayList object
	        arrayList.add("Alert1");
	        arrayList.add("Alert2");
	        
	        LinkedList<String> linkedList = new LinkedList<>(); // Creating LinkedList object
	        linkedList.add("MessageA");
	        linkedList.add("MessageB");

	        for (int i = 0; i < arrayList.size(); i++) { 
	        	System.out.println("ArrayList item: " + arrayList.get(i));
	        }
	        
	        int index = 0;
	        while (index < linkedList.size()) {             // while loop
	            System.out.println("LinkedList item: " + linkedList.get(index));
	            index++;
	        }
	        System.out.println(arrayList.get(10)); // Out of bounds
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: Tried to access an invalid index in listExample()");	
		}
	}
}
	
	static class NotificationSet {
		public void notifSet() {
			try {
			HashSet<String> hashSet = new HashSet<>();   // Creating HashSet object
	        hashSet.add("N1");
	        hashSet.add("N2");
	        
	        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); // Creating LinkedHashSet object
	        linkedHashSet.add("X1");
	        linkedHashSet.add("X2");
	        
	        TreeSet<String> treeSet = new TreeSet<>();  // Creating TreeSet object
	        treeSet.add("B");
	        treeSet.add("A");
	        
	        if (hashSet.contains("N1")) {     // if 
	            System.out.println("HashSet contains N1");
	        } else if (hashSet.contains("N3")) {   // if-else
	            System.out.println("HashSet contains N3");
	        } else {
	            System.out.println("HashSet contains neither");
	        }
	        treeSet.add(null);
		} catch (NullPointerException e) {
            System.out.println("Exception in notifSet(): TreeSet does not allow null values.");
		} catch (Exception e) {
            System.out.println("General error in notifSet(): " + e.getMessage());
		}
			
	}
}
	
	static class NotificationMap {
		public void notifMap() {
			try {
		    HashMap<Integer, String> hashMap = new HashMap<>(); // Creating HashMap object
	        hashMap.put(1, "One");
	        hashMap.put(2, "Two");
	        
	        TreeMap<Integer, String> treeMap = new TreeMap<>(); // Creating TreeMap object
	        treeMap.put(3, "Three");
	        treeMap.put(4, "Four");
	        
	        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(); // Creating LinkedHashMap
	        linkedHashMap.put(10, "Ten");
	        linkedHashMap.put(20, "Twenty");

         
            treeMap.put(null, "Test");
			
		} catch (NullPointerException e) {
            System.out.println("Exception in notifMap(): TreeMap cannot have null keys.");
		} catch (Exception e) {
			System.out.println("General error in notifMap(): " + e.getMessage());
		}
	}
}

static class NotificationCollection {

	    public static void main(String[] args) {
	    	
	    	try {

	        NotificationList listObj = new NotificationList();   // Creating object of NotificationList class
	        NotificationSet setObj = new NotificationSet();      // Creating object of NotificationSet class
	        NotificationMap mapObj = new NotificationMap();      // Creating object of NotificationMap class

	        // Calling methods
	        listObj.notifList();
	        setObj.notifSet();
	        mapObj.notifMap();
	    } catch (Exception e) {
            System.out.println("Unexpected error in main: " + e.getMessage());
	    }
	  }
	}
}

