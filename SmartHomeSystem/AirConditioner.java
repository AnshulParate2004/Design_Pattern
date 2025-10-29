/**
 * Air Conditioner Device Class - Concrete Observer
 * Purpose: Represents a smart air conditioner in the home automation system
 * Implements Device interface for uniform control
 * Maintains its own state (ON/OFF)
 */
public class AirConditioner implements Device {
    private String name;
    private boolean isOn;

    /**
     * Constructor
     * Purpose: Initializes air conditioner with a name in OFF state
     */
    public AirConditioner(String name) {
        this.name = name;
        this.isOn = false;
    }

    /**
     * Turns the air conditioner on
     * Purpose: Changes AC state to ON and displays confirmation
     */
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    /**
     * Turns the air conditioner off
     * Purpose: Changes AC state to OFF and displays confirmation
     */
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    /**
     * Receives notification message
     * Purpose: Allows AC to receive system notifications
     */
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    /**
     * Returns air conditioner name
     * Purpose: Identifies this specific AC device
     */
    @Override
    public String getDeviceName() {
        return name;
    }

    /**
     * Returns current air conditioner status
     * Purpose: Provides current state of the AC
     */
    @Override
    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }
}