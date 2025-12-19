package org.ups.model;

public class Main {

    public static void main(String[] args) {

        PackageInfo p1 = new PackageInfo();
        System.out.println("Package 1 Sender: " + p1.senderName);
        System.out.println("Package 1 Receiver: " + p1.getReceiverName());
        System.out.println("Package 1 Cost: " + p1.calculateCost());
    }
}
