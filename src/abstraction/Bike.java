package abstraction;

/**
 * Bike - concrete class extending abstract Vehicle.
 *
 * @author OOP-Using-Java
 */
public class Bike extends Vehicle {

    private String bikeType; // Sports, Cruiser, Commuter
    private int cc;

    public Bike(String brand, String model, int year, String type, int cc) {
        super(brand, model, year);
        this.bikeType = type;
        this.cc = cc;
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + " bike: Vroom! (" + cc + "cc engine)");
    }

    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + " bike: Engine off.");
    }

    @Override
    public String getFuelType() { return "Petrol"; }

    @Override
    public int getMaxRangeKm() { return cc > 150 ? 400 : 250; }

    public String getBikeType() { return bikeType; }
    public int getCc() { return cc; }

    public static void main(String[] args) {
        Vehicle bike = new Bike("Royal Enfield", "Classic 350", 2023, "Cruiser", 350);
        bike.startEngine();
        bike.displayBasicInfo();
        bike.stopEngine();
    }
}
