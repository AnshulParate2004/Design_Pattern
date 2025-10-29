/**
 * Device Interface - Observer Pattern
 * Purpose: Defines contract for all smart home devices
 * Ensures all devices can receive updates and be controlled uniformly
 * Allows polymorphic treatment of different device types
 */
public interface Device {
    /**
     * Receives notification messages
     * Purpose: Allows devices to be notified of system events
     */
    void update(String message);
    
    /**
     * Turns device on
     * Purpose: Activates the device
     */
    void turnOn();
    
    /**
     * Turns device off
     * Purpose: Deactivates the device
     */
    void turnOff();
    
    /**
     * Returns device name
     * Purpose: Identifies the device
     */
    String getDeviceName();
    
    /**
     * Returns current device status
     * Purpose: Provides current state of the device
     */
    String getStatus();
}