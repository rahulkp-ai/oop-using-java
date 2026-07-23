package abstraction;

/**
 * Machine - demonstrates the Template Method Pattern using abstraction.
 * Defines an algorithm skeleton; subclasses fill in specific steps.
 *
 * @author OOP-Using-Java
 */
public abstract class Machine {

    private String machineName;
    private boolean poweredOn;

    public Machine(String machineName) {
        this.machineName = machineName;
        this.poweredOn = false;
    }

    /**
     * Template method - defines the startup sequence.
     * Subclasses implement individual steps.
     */
    public final void startupSequence() {
        System.out.println("=== Starting " + machineName + " ===");
        performSelfCheck();
        loadOperatingSystem();
        initializeComponents();
        this.poweredOn = true;
        System.out.println(machineName + " is ready to use.\n");
    }

    public final void shutdownSequence() {
        System.out.println("=== Shutting down " + machineName + " ===");
        saveState();
        closeConnections();
        powerOff();
        this.poweredOn = false;
        System.out.println(machineName + " has shut down.\n");
    }

    // Abstract steps - different for each machine type
    protected abstract void performSelfCheck();
    protected abstract void loadOperatingSystem();
    protected abstract void initializeComponents();
    protected abstract void saveState();
    protected abstract void closeConnections();
    protected abstract void powerOff();

    public String getMachineName() { return machineName; }
    public boolean isPoweredOn() { return poweredOn; }
}

class DesktopComputer extends Machine {

    private String processor;
    private int ramGB;

    public DesktopComputer(String processor, int ramGB) {
        super("Desktop Computer");
        this.processor = processor;
        this.ramGB = ramGB;
    }

    @Override protected void performSelfCheck() { System.out.println("POST check: " + processor + " | " + ramGB + "GB RAM - OK"); }
    @Override protected void loadOperatingSystem() { System.out.println("Loading Windows 11..."); }
    @Override protected void initializeComponents() { System.out.println("Initializing GPU, network, audio drivers..."); }
    @Override protected void saveState() { System.out.println("Saving user session..."); }
    @Override protected void closeConnections() { System.out.println("Closing network connections..."); }
    @Override protected void powerOff() { System.out.println("Power off signal sent to PSU."); }

    public static void main(String[] args) {
        Machine pc = new DesktopComputer("Intel Core i7-13700K", 32);
        pc.startupSequence();
        System.out.println("Running... (Machine on: " + pc.isPoweredOn() + ")");
        pc.shutdownSequence();
    }
}
