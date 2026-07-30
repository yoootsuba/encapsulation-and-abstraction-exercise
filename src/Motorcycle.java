
class Motorcycle extends Vehicle {

    private int displacement;

    public Motorcycle(String plateNumber, String model, double baseRatePerDay, int displacement) {
        super(plateNumber, model, baseRatePerDay);
        if (displacement <= 0) {
            throw new IllegalArgumentException("Engine displacement must be greater than 0");
        }
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return displacement;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-10s | %-8s | %-10s | %-8.2f | %-15s | %-10s%n",
                "Motorcycle", getPlateNumber(), getModel(), getBaseRatePerDay(),
                "CC: " + displacement, isAvailable() ? "Available" : "Rented");
    }
}

