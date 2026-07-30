
abstract class Vehicle {

    private String plateNumber;
    private String model;
    private double baseRatePerDay;
    private boolean available;

    public Vehicle(String plateNumber, String model, double baseRatePerDay) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate number cannot be empty");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        if (baseRatePerDay <= 0) {
            throw new IllegalArgumentException("Base rate must be greater than 0");
        }
        this.plateNumber = plateNumber;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.available = true;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRatePerDay() {
        return baseRatePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCost(int days);

    public abstract void displayDetails();
}
