
class Car extends Vehicle {

    private int seats;

    public Car(String plateNumber, String model, double baseRatePerDay, int seats) {
        super(plateNumber, model, baseRatePerDay);
        if (seats <= 0) {
            throw new IllegalArgumentException("Seats must be greater than 0");
        }
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-10s | %-8s | %-10s | %-8s | %-15s | %-10s%n",
                "Car", getPlateNumber(), getModel(), getBaseRatePerDay(),
                "Seats: " + seats, isAvailable() ? "Available" : "Rented");
    }
}
