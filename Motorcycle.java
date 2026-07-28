
class Motorcycle extends Vehicle {
    private int displacement;

    public Motorcycle(String plateNumber, String model, double baseRatePerDay, int displacement) {
        super(plateNumber, model, baseRatePerDay);
        this.displacement = displacement;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Motorcycle | Plate: %s | Model: %s | Rate: %.2f | CC: %d | Available: %s%n",
                getPlateNumber(), getModel(), getBaseRatePerDay(), displacement, isAvailable() ? "Yes" : "No");
    }
}