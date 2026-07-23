package abstraction;

/**
 * Vehicle - abstract class demonstrating abstraction.
 * Defines the template (what to do) without full implementation (how to do).
 * Concrete subclasses must implement abstract methods.
 *
 * @author OOP-Using-Java
 */
public abstract class Vehicle {

    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Abstract methods - hide implementation details
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract String getFuelType();
    public abstract int getMaxRangeKm();

    // Concrete shared method
    public void displayBasicInfo() {
        System.out.printf("Vehicle: %d %s %s | Fuel: %s | Max Range: %d km%n",
                year, brand, model, getFuelType(), getMaxRangeKm());
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
