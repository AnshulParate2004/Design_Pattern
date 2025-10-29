/**
 * Fan Device Class - Concrete Observer
 * Purpose: Represents a smart fan device in the home automation system
 * Implements Device interface for uniform control
 * Maintains its own state (ON/OFF)
 */
public class Fan implements Device {
    private String name;
    private boolean isOn;

    /**
     * Constructor
     * Purpose: Initializes fan with a name in OFF state
     */
    public Fan(String name) {
        this.name = name;
        this.isOn = false;
    }

    /**
     * Turns the fan on
     * Purpose: Changes fan state to ON and displays confirmation
     */
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    /**
     * Turns the fan off
     * Purpose: Changes fan state to OFF and displays confirmation
     */
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    /**
     * Receives notification message
     * Purpose: Allows fan to receive system notifications
     */
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    /**
     * Returns fan name
     * Purpose: Identifies this specific fan device
     */
    @Override
    public String getDeviceName() {
        return name;
    }

    /**
     * Returns current fan status
     * Purpose: Provides current state of the fan
     */
    @Override
    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }
}