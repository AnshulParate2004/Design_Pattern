/**
 * Light Device Class - Concrete Observer
 * Purpose: Represents a smart light device in the home automation system
 * Implements Device interface for uniform control
 * Maintains its own state (ON/OFF)
 */
public class Light implements Device {
    private String name;
    private boolean isOn;

    /**
     * Constructor
     * Purpose: Initializes light with a name in OFF state
     */
    public Light(String name) {
        this.name = name;
        this.isOn = false;
    }

    /**
     * Turns the light on
     * Purpose: Changes light state to ON and displays confirmation
     */
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    /**
     * Turns the light off
     * Purpose: Changes light state to OFF and displays confirmation
     */
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    /**
     * Receives notification message
     * Purpose: Allows light to receive system notifications
     */
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    /**
     * Returns light name
     * Purpose: Identifies this specific light device
     */
    @Override
    public String getDeviceName() {
        return name;
    }

    /**
     * Returns current light status
     * Purpose: Provides current state of the light
     */
    @Override
    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }
}