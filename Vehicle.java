
abstract class Vehicle {
    private String plateNumber;
    private String model;
    private double baseRatePerDay;
    private boolean available;

    public Vehicle(String plateNumber, String model, double baseRatePerDay) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.available = true;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getModel() { return model; }
    public double getBaseRatePerDay() { return baseRatePerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract double calculateRentalCost(int days);

    public abstract void displayDetails();
}
