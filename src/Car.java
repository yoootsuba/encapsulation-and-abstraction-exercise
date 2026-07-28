class Car extends Vehicle {
    private int seats;

    public Car(String plateNumber, String model, double baseRatePerDay, int seats) {
        super(plateNumber, model, baseRatePerDay);
        this.seats = seats;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Car | Plate: %s | Model: %s | Rate: %.2f | Seats: %d | Available: %s%n",
                getPlateNumber(), getModel(), getBaseRatePerDay(), seats, isAvailable() ? "Yes" : "No");
    }
}