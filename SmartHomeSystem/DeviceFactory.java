// Factory Method Pattern - Device Factory
public class DeviceFactory {
    
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
                System.out.println("❌ Unknown device type: " + type);
                return null;
        }
    }
}