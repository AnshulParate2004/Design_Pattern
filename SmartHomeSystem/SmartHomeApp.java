import java.util.Scanner;

// Main Application - Proxy ONLY for Cases 4 & 5
public class SmartHomeApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create the Smart Home Hub (Mediator)
        SmartHomeHub hub = new SmartHomeHub("My Smart Home Hub");
        
        System.out.println("\n🎉 Welcome to Smart Home Control System! 🎉");
        System.out.println("🛡️  Proxy Pattern: Cases 4 & 5 Only! 🛡️");
        System.out.println("==========================================");
        System.out.println("Security Mode password: admin123");
        System.out.println("==========================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        addDevice(scanner, hub);
                        break;
                    case 2:
                        controlDevice(scanner, hub);  // NO PROXY
                        break;
                    case 3:
                        hub.displayAllStatuses();
                        break;
                    case 4:
                        notifyDevices(scanner, hub);  // PROXY ACTIVE 🛡️
                        break;
                    case 5:
                        activateSecurityMode(scanner, hub);  // PROXY ACTIVE 🛡️
                        break;
                    case 6:
                        System.out.println("\n👋 Thank you for using Smart Home System! Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("❌ Invalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     SMART HOME CONTROL MENU        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Add New Device                  ║");
        System.out.println("║ 2. Control Device (No Proxy)       ║");
        System.out.println("║ 3. Display All Device Status       ║");
        System.out.println("║ 4. Notify All (Proxy)              ║");
        System.out.println("║ 5. Security Mode (Proxy)           ║");
        System.out.println("║ 6. Exit                            ║");
        System.out.println("╚════════════════════════════════════╝");
    }
    
    // Case 1: Add device - Factory Pattern
    private static void addDevice(Scanner scanner, SmartHomeHub hub) {
        System.out.println("\n📱 Available Device Types:");
        System.out.println("   - Light");
        System.out.println("   - Fan");
        System.out.println("   - AC (Air Conditioner)");
        System.out.println("   - DoorLock");
        
        System.out.print("\nEnter device type: ");
        String type = scanner.nextLine();
        
        System.out.print("Enter device name: ");
        String name = scanner.nextLine();
        
        Device device = DeviceFactory.createDevice(type, name);
        
        if (device != null) {
            hub.registerDevice(device);  // Hub wraps it in proxy internally
        }
        System.out.println();
    }
    
    // Case 2: Control device - NO PROXY (direct control)
    private static void controlDevice(Scanner scanner, SmartHomeHub hub) {
        if (hub.getDevices().isEmpty()) {
            System.out.println("\n❌ No devices registered. Add devices first!\n");
            return;
        }
        
        System.out.println("\n📋 Registered Devices:");
        for (DeviceProxy proxy : hub.getDevices()) {
            System.out.println("   - " + proxy.getDeviceName());
        }
        
        System.out.print("\nEnter device name: ");
        String deviceName = scanner.nextLine();
        
        System.out.print("Enter command (ON/OFF): ");
        String command = scanner.nextLine();
        
        hub.sendCommand(deviceName, command);  // Direct control, no proxy logic
        System.out.println();
    }
    
    // Case 4: Notify all devices - PROXY PATTERN ACTIVE! 🛡️
    private static void notifyDevices(Scanner scanner, SmartHomeHub hub) {
        if (hub.getDevices().isEmpty()) {
            System.out.println("\n❌ No devices registered. Add devices first!\n");
            return;
        }
        
        System.out.print("\nEnter notification message: ");
        String message = scanner.nextLine();
        
        // Proxy intercepts, logs, and forwards all notifications
        hub.notifyAllDevices(message);
        System.out.println();
    }
    
    // Case 5: Security mode - PROXY PATTERN ACTIVE! 🛡️
    private static void activateSecurityMode(Scanner scanner, SmartHomeHub hub) {
        if (hub.getDevices().isEmpty()) {
            System.out.println("\n❌ No devices registered. Add devices first!\n");
            return;
        }
        
        System.out.print("\nEnter ADMIN password: ");
        String password = scanner.nextLine();
        
        // Proxy handles authentication and logging for security mode
        hub.activateSecurityMode(password);
        System.out.println();
    }
}