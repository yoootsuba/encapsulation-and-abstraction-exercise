
class Van extends Vehicle {

    private int cargoCapacity;

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public Van(String plateNumber, String model, double baseRatePerDay, int cargoCapacity) {
        super(plateNumber, model, baseRatePerDay);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than 0");
        }
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + 500;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-10s | %-8s | %-10s | %-8s | %-15s | %-10s%n",
                "Van", getPlateNumber(), getModel(), getBaseRatePerDay(),
                "Capacity: " + cargoCapacity + "kg", isAvailable() ? "Available" : "Rented");
    }
}
