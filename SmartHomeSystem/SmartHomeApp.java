import java.util.Scanner;

/**
 * Main Application Class
 * Purpose: Entry point for the Smart Home Control System
 * Handles user interaction and menu-driven operations
 * Demonstrates Proxy Pattern for Security Mode authentication
 */
public class SmartHomeApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeHub hub = new SmartHomeHub("My Smart Home Hub");
        
        System.out.println("\n Welcome to Smart Home Control System! ");
        System.out.println("  Proxy Pattern: Security Mode Only! ");
        System.out.println("==========================================");
        System.out.println("Security Mode password: admin123");
        System.out.println("==========================================\n");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        addDevice(scanner, hub);
                        break;
                    case 2:
                        controlDevice(scanner, hub);
                        break;
                    case 3:
                        hub.displayAllStatuses();
                        break;
                    case 4:
                        activateSecurityMode(scanner, hub);
                        break;
                    case 5:
                        System.out.println("\n Thank you for using Smart Home System! Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println(" Invalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println(" Invalid input. Please enter a number.\n");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu options to the user
     */
    private static void displayMenu() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     SMART HOME CONTROL MENU        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Add New Device                  ║");
        System.out.println("║ 2. Control Device                  ║");
        System.out.println("║ 3. Display All Device Status       ║");
        System.out.println("║ 4. Security Mode                   ║");
        System.out.println("║ 5. Exit                            ║");
        System.out.println("╚════════════════════════════════════╝");
    }
    
    /**
     * Adds a new device to the smart home system
     * Uses Factory Pattern to create devices based on type
     * Purpose: Demonstrates Factory Pattern for device creation
     */
    private static void addDevice(Scanner scanner, SmartHomeHub hub) {
        System.out.println("\n Available Device Types:");
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
            hub.registerDevice(device);
        }
        System.out.println();
    }
    
    /**
     * Controls a specific device with ON/OFF commands
     * Purpose: Direct device control without proxy intervention
     * Demonstrates normal operation mode
     */
    private static void controlDevice(Scanner scanner, SmartHomeHub hub) {
        if (hub.getDevices().isEmpty()) {
            System.out.println("\n No devices registered. Add devices first!\n");
            return;
        }
        
        System.out.println("\n Registered Devices:");
        for (DeviceProxy proxy : hub.getDevices()) {
            System.out.println("   - " + proxy.getDeviceName());
        }
        
        System.out.print("\nEnter device name: ");
        String deviceName = scanner.nextLine();
        
        System.out.print("Enter command (ON/OFF): ");
        String command = scanner.nextLine();
        
        hub.sendCommand(deviceName, command);
        System.out.println();
    }
    
    /**
     * Activates security mode for all devices
     * Purpose: Demonstrates Proxy Pattern with authentication and logging
     * Requires admin password to execute security protocol
     */
    private static void activateSecurityMode(Scanner scanner, SmartHomeHub hub) {
        if (hub.getDevices().isEmpty()) {
            System.out.println("\n No devices registered. Add devices first!\n");
            return;
        }
        
        System.out.print("\nEnter ADMIN password: ");
        String password = scanner.nextLine();
        
        hub.activateSecurityMode(password);
        System.out.println();
    }
}