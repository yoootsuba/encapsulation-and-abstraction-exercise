
import java.util.*;

public class Main {

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

            String input = sc.nextLine().trim();

            while (!input.matches("[1-5]")) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");

                System.out.println("\nMenu");
                System.out.println("1 - Add Vehicle");
                System.out.println("2 - View All Vehicles");
                System.out.println("3 - Rent a Vehicle");
                System.out.println("4 - Return a Vehicle");
                System.out.println("5 - Exit");
                System.out.print("Enter choice: ");

                input = sc.nextLine().trim();
            }

            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    String typeInput;
                    int type;
                    do {
                        System.out.println("Select type: 1-Car, 2-Motorcycle, 3-Van");
                        typeInput = sc.nextLine().trim();
                        if (!typeInput.matches("[1-3]")) {
                            System.out.println("Invalid input! Please enter 1, 2, or 3.");
                            typeInput = null;
                        }
                    } while (typeInput == null);
                    type = Integer.parseInt(typeInput);

                    String plate;
                    do {
                        System.out.print("Enter plate number (format: 123-ABC): ");
                        plate = sc.nextLine().trim().toUpperCase();

                        if (!plate.matches("\\d{3}-[A-Z]{3}")) {
                            System.out.println("Invalid plate number! Format must be 3 digits, a dash, and 3 letters (e.g., 123-ABC).");
                            plate = "";
                        }
                    } while (plate.isEmpty());

                    String model;
                    do {
                        System.out.print("Enter model: ");
                        model = sc.nextLine().trim();
                        if (model.isEmpty()) {
                            System.out.println("Model cannot be empty!");
                        }
                    } while (model.isEmpty());

                    double rate;
                    String rateInput;
                    do {
                        System.out.print("Enter base rate per day (>0): ");
                        rateInput = sc.nextLine().trim();
                        try {
                            rate = Double.parseDouble(rateInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a decimal number.");
                            rate = -1;
                        }
                        if (rate <= 0) {
                            System.out.println("Rate must be greater than 0!");
                        }
                    } while (rate <= 0);

                    if (type == 1) {
                        String seatsInput;
                        int seats;
                        do {
                            System.out.print("Enter number of seats (>0): ");
                            seatsInput = sc.nextLine().trim();
                            try {
                                seats = Integer.parseInt(seatsInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter an integer.");
                                seats = -1;
                            }
                            if (seats <= 0) {
                                System.out.println("Seats must be greater than 0!");
                            }
                        } while (seats <= 0);
                        system.addVehicle(new Car(plate, model, rate, seats));
                    } else if (type == 2) {
                        String ccInput;
                        int cc;
                        do {
                            System.out.print("Enter engine displacement (cc >0): ");
                            ccInput = sc.nextLine().trim();
                            try {
                                cc = Integer.parseInt(ccInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter an integer.");
                                cc = -1;
                            }
                            if (cc <= 0) {
                                System.out.println("Displacement must be greater than 0!");
                            }
                        } while (cc <= 0);
                        system.addVehicle(new Motorcycle(plate, model, rate, cc));
                    } else if (type == 3) {
                        String capInput;
                        int capacity;
                        do {
                            System.out.print("Enter cargo capacity (kg >0): ");
                            capInput = sc.nextLine().trim();
                            try {
                                capacity = Integer.parseInt(capInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input! Please enter an integer.");
                                capacity = -1;
                            }
                            if (capacity <= 0) {
                                System.out.println("Capacity must be greater than 0!");
                            }
                        } while (capacity <= 0);
                        system.addVehicle(new Van(plate, model, rate, capacity));
                    }
                    break;

                case 2:
                    system.viewAllVehicles();
                    break;

                case 3:
                    System.out.print("Enter plate number: ");
                    String rentPlate = sc.nextLine().trim();
                    String daysInput;
                    int days;
                    do {
                        System.out.print("Enter number of days (>0): ");
                        daysInput = sc.nextLine().trim();
                        try {
                            days = Integer.parseInt(daysInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter an integer.");
                            days = -1;
                        }
                        if (days <= 0) {
                            System.out.println("Days must be greater than 0!");
                        }
                    } while (days <= 0);
                    system.rentVehicle(rentPlate, days);
                    break;

                case 4:
                    System.out.print("Enter plate number: ");
                    String returnPlate = sc.nextLine().trim();
                    system.returnVehicle(returnPlate);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}


