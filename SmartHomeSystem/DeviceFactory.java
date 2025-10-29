/**
 * Device Factory Class - Factory Pattern
 * Purpose: Centralizes device object creation
 * Encapsulates device instantiation logic
 * Provides flexible way to create different device types
 * Allows easy addition of new device types without modifying client code
 */
public class DeviceFactory {
    
    /**
     * Creates a device based on type and name
     * Purpose: Factory method to instantiate appropriate device objects
     * Returns Device object or null if type is invalid
     * 
     * Supported types:
     * - light: Creates Light device
     * - fan: Creates Fan device
     * - ac/airconditioner: Creates AirConditioner device
     * - doorlock/door: Creates DoorLock device
     */
    public static Device createDevice(String type, String name) {
        if (type == null || name == null) {
            return null;
        }
        
        switch (type.toLowerCase()) {
            case "light":
                return new Light(name);
            case "fan":
                return new Fan(name);
            case "ac":
            case "airconditioner":
                return new AirConditioner(name);
            case "doorlock":
            case "door":
                return new DoorLock(name);
            default:
                System.out.println(" Unknown device type: " + type);
                return null;
        }
    }
}