class Van extends Vehicle {
    private int cargoCapacity;

    public Van(String plateNumber, String model, double baseRatePerDay, int cargoCapacity) {
        super(plateNumber, model, baseRatePerDay);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + 500; // driver fee
    }

    @Override
    public void displayDetails() {
        System.out.printf("Van | Plate: %s | Model: %s | Rate: %.2f | Capacity: %dkg | Available: %s%n",
                getPlateNumber(), getModel(), getBaseRatePerDay(), cargoCapacity, isAvailable() ? "Yes" : "No");
    }
}