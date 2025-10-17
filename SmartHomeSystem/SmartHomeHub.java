import java.util.ArrayList;
import java.util.List;

// Mediator Pattern - Hub with Proxy for Notify & Security Only
public class SmartHomeHub {
    private List<DeviceProxy> devices;  // Now stores proxies
    private String hubName;
    private boolean securityModeActive;

    public SmartHomeHub(String hubName) {
        this.hubName = hubName;
        this.devices = new ArrayList<>();
        this.securityModeActive = false;
        System.out.println("🏠 " + hubName + " initialized!");
    }

    // Register a new device (wrapped in proxy internally)
    public void registerDevice(Device device) {
        DeviceProxy proxy = new DeviceProxy(device);
        devices.add(proxy);
        System.out.println("✅ " + device.getDeviceName() + " registered to " + hubName);
    }

    // Case 4: Notify all devices - PROXY PATTERN ACTIVE! 🛡️
    public void notifyAllDevices(String message) {
        System.out.println("\n📢 Broadcasting to all devices: " + message);
        System.out.println("🛡️ [PROXY PATTERN ACTIVE] Intercepting and logging all notifications...\n");
        
        for (DeviceProxy proxy : devices) {
            proxy.update(message);  // Proxy intercepts, logs, then forwards
        }
        
        System.out.println("\n✅ All notifications sent via Proxy");
    }

    // Case 2: Send command to specific device - NO PROXY (direct)
    public void sendCommand(String deviceName, String command) {
        for (DeviceProxy proxy : devices) {
            if (proxy.getDeviceName().equalsIgnoreCase(deviceName)) {
                System.out.println("\n📤 Sending command to " + deviceName + ": " + command);
                System.out.println("ℹ️  [NO PROXY] Direct device control");
                
                if (command.equalsIgnoreCase("ON")) {
                    proxy.turnOn();  // Direct pass-through, no proxy logic
                } else if (command.equalsIgnoreCase("OFF")) {
                    proxy.turnOff();  // Direct pass-through, no proxy logic
                }
                return;
            }
        }
        System.out.println("❌ Device not found: " + deviceName);
    }

    // Case 5: Security Mode - PROXY PATTERN ACTIVE! 🛡️
    public void activateSecurityMode(String adminPassword) {
        System.out.println("\n🚨 ATTEMPTING TO ACTIVATE SECURITY MODE 🚨");
        System.out.println("🛡️ [PROXY PATTERN ACTIVE] Authenticating all devices...\n");
        
        boolean allAuthenticated = true;
        
        // Authenticate all devices through proxy
        for (DeviceProxy proxy : devices) {
            if (!proxy.authenticateForSecurity(adminPassword)) {
                allAuthenticated = false;
            }
        }
        
        if (!allAuthenticated) {
            System.out.println("\n❌ Security Mode activation FAILED - Authentication error");
            return;
        }
        
        System.out.println("\n✅ All devices authenticated via Proxy. Executing Security Protocol...\n");
        securityModeActive = true;
        
        // Execute security protocol through proxy
        for (DeviceProxy proxy : devices) {
            Device realDevice = proxy.getRealDevice();
            
            if (realDevice instanceof Light) {
                proxy.securityTurnOff();  // Through proxy with logging
            } else if (realDevice instanceof DoorLock) {
                proxy.securityTurnOn();  // Through proxy with logging
            }
        }
        
        System.out.println("\n🔒 SECURITY MODE ACTIVE 🔒");
        
        // Reset authentication after use
        for (DeviceProxy proxy : devices) {
            proxy.resetAuthentication();
        }
    }
    
    // Deactivate security mode
    public void deactivateSecurityMode() {
        securityModeActive = false;
        System.out.println("\n🔓 Security Mode Deactivated");
    }

    // Display all device statuses
    public void displayAllStatuses() {
        System.out.println("\n📊 === Device Status Report ===");
        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
        } else {
            for (DeviceProxy proxy : devices) {
                System.out.println("   " + proxy.getDeviceName() + ": " + proxy.getStatus());
            }
        }
        System.out.println("Security Mode: " + (securityModeActive ? "ACTIVE 🔒" : "INACTIVE"));
        System.out.println("================================\n");
    }

    // Get all device proxies
    public List<DeviceProxy> getDevices() {
        return devices;
    }
}