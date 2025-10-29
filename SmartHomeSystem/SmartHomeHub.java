import java.util.ArrayList;
import java.util.List;

/**
 * Smart Home Hub Class - Mediator Pattern
 * Purpose: Central controller for all smart home devices
 * Manages device registration, commands, and security mode
 * Acts as mediator between user and devices
 */
public class SmartHomeHub {
    private List<DeviceProxy> devices;
    private String hubName;
    private boolean securityModeActive;

    /**
     * Constructor
     * Initializes the hub with a name and empty device list
     */
    public SmartHomeHub(String hubName) {
        this.hubName = hubName;
        this.devices = new ArrayList<>();
        this.securityModeActive = false;
        System.out.println(hubName + " initialized!");
    }

    /**
     * Registers a new device to the hub
     * Purpose: Wraps device in proxy for future security operations
     * Uses Proxy Pattern to add extra layer of control
     */
    public void registerDevice(Device device) {
        DeviceProxy proxy = new DeviceProxy(device);
        devices.add(proxy);
        System.out.println(device.getDeviceName() + " registered to " + hubName);
    }

    /**
     * Sends direct command to a specific device
     * Purpose: Normal device control without proxy intervention
     * Demonstrates direct communication for regular operations
     */
    public void sendCommand(String deviceName, String command) {
        for (DeviceProxy proxy : devices) {
            if (proxy.getDeviceName().equalsIgnoreCase(deviceName)) {
                System.out.println("\n Sending command to " + deviceName + ": " + command);
                System.out.println(" [NO PROXY] Direct device control");
                
                if (command.equalsIgnoreCase("ON")) {
                    proxy.turnOn();
                } else if (command.equalsIgnoreCase("OFF")) {
                    proxy.turnOff();
                }
                return;
            }
        }
        System.out.println(" Device not found: " + deviceName);
    }

    /**
     * Activates security mode for all devices
     * Purpose: Demonstrates Proxy Pattern with authentication
     * Authenticates access, logs actions, and executes security protocol
     * Turns off all lights and locks all doors
     */
    public void activateSecurityMode(String adminPassword) {
        System.out.println("\n ATTEMPTING TO ACTIVATE SECURITY MODE ");
        System.out.println(" [PROXY PATTERN ACTIVE] Authenticating all devices...\n");
        
        boolean allAuthenticated = true;
        
        for (DeviceProxy proxy : devices) {
            if (!proxy.authenticateForSecurity(adminPassword)) {
                allAuthenticated = false;
            }
        }
        
        if (!allAuthenticated) {
            System.out.println("\n Security Mode activation FAILED - Authentication error");
            return;
        }
        
        System.out.println("\n All devices authenticated via Proxy. Executing Security Protocol...\n");
        securityModeActive = true;
        
        for (DeviceProxy proxy : devices) {
            Device realDevice = proxy.getRealDevice();
            
            if (realDevice instanceof Light) {
                proxy.securityTurnOff();
            } else if (realDevice instanceof DoorLock) {
                proxy.securityTurnOn();
            }
        }
        
        System.out.println("\n SECURITY MODE ACTIVE ");
        
        for (DeviceProxy proxy : devices) {
            proxy.resetAuthentication();
        }
    }
    
    /**
     * Deactivates security mode
     * Purpose: Resets security state of the system
     */
    public void deactivateSecurityMode() {
        securityModeActive = false;
        System.out.println("\n Security Mode Deactivated");
    }

    /**
     * Displays status of all registered devices
     * Purpose: Provides overview of all devices and security state
     */
    public void displayAllStatuses() {
        System.out.println("\n === Device Status Report ===");
        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
        } else {
            for (DeviceProxy proxy : devices) {
                System.out.println("   " + proxy.getDeviceName() + ": " + proxy.getStatus());
            }
        }
        System.out.println("Security Mode: " + (securityModeActive ? "ACTIVE" : "INACTIVE"));
        System.out.println("================================\n");
    }

    /**
     * Returns list of all device proxies
     * Purpose: Allows external access to device list
     */
    public List<DeviceProxy> getDevices() {
        return devices;
    }
}