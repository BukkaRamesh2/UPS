package org.ups.model;

// MAIN CLASS
 class Main {

    // ---------- MODEL / POJO CLASS ----------
    static class PackageInfo {
        private String sender;
        private String receiver;
        private double weight;
        private String trackingId;

        // Default constructor
        public PackageInfo() {
            sender = "Default Sender";
            receiver = "Default Receiver";
            weight = 5;
            trackingId = "UPS0001";
        }

        // Parameter constructor
        public PackageInfo(String sender, String receiver, double weight, String trackingId) {
            this.sender = sender;
            this.receiver = receiver;
            this.weight = weight;
            this.trackingId = trackingId;
        }

        // Getter and Setter methods
        public String getSender() { return sender; }
        public void setSender(String sender) { this.sender = sender; }

        public String getReceiver() { return receiver; }
        public void setReceiver(String receiver) { this.receiver = receiver; }

        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }

        public String getTrackingId() { return trackingId; }
        public void setTrackingId(String trackingId) { this.trackingId = trackingId; }

        public double calculateCost() {
            return weight * 5;  // Simple logic
        }
    }

    // ---------- INHERITANCE: EXPRESS PACKAGE ----------
    static class ExpressPackage extends PackageInfo {

        // Aggregation example (extra service)
        Label label;  // ExpressPackage HAS-A Label

        public ExpressPackage() {
            super("Default Sender", "Default Receiver", 12, "EXP1001");
            label = new Label("Express Label"); // aggregation
        }

        public double expressCharge() {
            if (getWeight() > 10) {
                return (getWeight() * 8) + 50;
            } else {
                return (getWeight() * 8) + 20;
            }
        }
    }

    // ---------- AGGREGATION CLASS ----------
    static class Label {
        String labelName;

        public Label(String labelName) {
            this.labelName = labelName;
        }
    }


    // ---------- CONTROLLER-LIKE LOGIC ----------
    public static void main(String[] args) {

        PackageInfo p1 = new PackageInfo();     // standard
        ExpressPackage p2 = new ExpressPackage(); // express

        PackageInfo[] packages = { p1, p2 };

        System.out.println("----- UPS PACKAGE REPORT -----");

        for (int i = 0; i < packages.length; i++) {

            PackageInfo pkg = packages[i];

            System.out.println("Package " + (i + 1));
            System.out.println("Sender: " + pkg.getSender());
            System.out.println("Receiver: " + pkg.getReceiver());
            System.out.println("Weight: " + pkg.getWeight());
            System.out.println("TrackingId: " + pkg.getTrackingId());

            // DECISION MAKING
            if (pkg instanceof ExpressPackage) {
                ExpressPackage ep = (ExpressPackage) pkg;
                System.out.println("Type: Express Package");
                System.out.println("Cost: ₹" + ep.expressCharge());
                System.out.println("Label Attached: " + ep.label.labelName);
            } else {
                System.out.println("Type: Standard Package");
                System.out.println("Cost: ₹" + pkg.calculateCost());
            }

            // More DECISION MAKING
            if (pkg.getWeight() > 20) {
                System.out.println("Category: Heavy Shipment");
            } else if (pkg.getWeight() > 10) {
                System.out.println("Category: Medium Shipment");
            } else {
                System.out.println("Category: Small Shipment");
            }

            System.out.println("------------------------------------------");
        }

        // CONTROL STATEMENT
        int index = 0;
        int mediumCount = 0;

        while (index < packages.length) {
            if (packages[index].getWeight() > 10) {
                mediumCount++;
            }
            index++;
        }

        System.out.println("Total Medium/Heavy Shipments: " + mediumCount);
    }
}


