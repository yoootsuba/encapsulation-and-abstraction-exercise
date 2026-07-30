
import java.util.ArrayList;

class RentalSystem {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        for (Vehicle existing : vehicles) {
            if (existing.getPlateNumber().equalsIgnoreCase(v.getPlateNumber())) {
                System.out.println("Duplicate plate number! Vehicle not added.");
                return;
            }
        }
        vehicles.add(v);
        System.out.println("Vehicle added successfully!");
    }

    public void viewAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.printf("%-5s | %-8s | %-10s | %-8s | %-15s | %-10s%n",
                "Type", "Plate", "Model", "Rate", "Extra Info", "Status");
        System.out.println("-------------------------------------------------------------");

        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    public void rentVehicle(String plate, int days) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate)) {
                if (v.isAvailable()) {
                    double cost = v.calculateRentalCost(days);
                    System.out.println("Total rental cost: Php " + cost);
                    v.setAvailable(false);
                } else {
                    System.out.println("Vehicle not available!");
                }
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    public void returnVehicle(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate)) {
                if (!v.isAvailable()) {
                    v.setAvailable(true);
                    System.out.println("Vehicle returned successfully!");
                } else {
                    System.out.println("Vehicle was not rented.");
                }
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }
}
