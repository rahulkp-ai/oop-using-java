package abstraction;

/**
 * Car - concrete implementation of abstract Vehicle.
 *
 * @author OOP-Using-Java
 */
public class Car extends Vehicle {

    private String variant; // Base, Mid, Top
    private boolean isElectric;
    private int batteryKwhOrTankLiters;

    public Car(String brand, String model, int year, String variant, boolean isElectric, int capacityValue) {
        super(brand, model, year);
        this.variant = variant;
        this.isElectric = isElectric;
        this.batteryKwhOrTankLiters = capacityValue;
    }

    @Override
    public void startEngine() {
        if (isElectric) {
            System.out.println(brand + " " + model + ": Silent electric motor activated.");
        } else {
            System.out.println(brand + " " + model + ": Petrol engine started.");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + ": Powering off.");
    }

    @Override
    public String getFuelType() { return isElectric ? "Electric" : "Petrol"; }

    @Override
    public int getMaxRangeKm() {
        return isElectric ? batteryKwhOrTankLiters * 6 : batteryKwhOrTankLiters * 15;
    }

    public String getVariant() { return variant; }
    public boolean isElectric() { return isElectric; }

    // ==========================================
    // ADDED: Main method to allow execution
    // ==========================================
    public static void main(String[] args) {
        // Create an instance of Car (Example: Tesla Model 3)
        Car myCar = new Car("Tesla", "Model 3", 2026, "Top", true, 75);
        
        // Test the methods
        myCar.startEngine();
        System.out.println("Fuel Type: " + myCar.getFuelType());
        System.out.println("Max Range: " + myCar.getMaxRangeKm() + " km");
        myCar.stopEngine();
    }
}