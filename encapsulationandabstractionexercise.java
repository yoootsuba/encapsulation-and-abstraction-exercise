import java.util.*;




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

public class encapsulationandabstractionexercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalSystem system = new RentalSystem();
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1 - Add Vehicle");
            System.out.println("2 - View All Vehicles");
            System.out.println("3 - Rent a Vehicle");
            System.out.println("4 - Return a Vehicle");
            System.out.println("5 - Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select type: 1-Car, 2-Motorcycle, 3-Van");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter plate number: ");
                    String plate = sc.nextLine().trim();
                    System.out.print("Enter model: ");
                    String model = sc.nextLine().trim();
                    System.out.print("Enter base rate per day: ");
                    double rate = sc.nextDouble();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Enter number of seats: ");
                        int seats = sc.nextInt();
                        system.addVehicle(new Car(plate, model, rate, seats));
                    } else if (type == 2) {
                        System.out.print("Enter engine displacement (cc): ");
                        int cc = sc.nextInt();
                        system.addVehicle(new Motorcycle(plate, model, rate, cc));
                    } else if (type == 3) {
                        System.out.print("Enter cargo capacity (kg): ");
                        int capacity = sc.nextInt();
                        system.addVehicle(new Van(plate, model, rate, capacity));
                    }
                    break;

                case 2:
                    system.viewAllVehicles();
                    break;

                case 3:
                    System.out.print("Enter plate number: ");
                    String rentPlate = sc.nextLine();
                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();
                    system.rentVehicle(rentPlate, days);
                    break;

                case 4:
                    System.out.print("Enter plate number: ");
                    String returnPlate = sc.nextLine();
                    system.returnVehicle(returnPlate);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
