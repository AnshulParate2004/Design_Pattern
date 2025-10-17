# 🏠 Smart Home Control System

## Design Patterns Implementation in Java

---

## 📋 Table of Contents
- [Overview](#overview)
- [Design Patterns Used](#design-patterns-used)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [Features & Functionalities](#features--functionalities)
- [Detailed Code Explanation](#detailed-code-explanation)
- [Usage Examples](#usage-examples)
- [Design Pattern Benefits](#design-pattern-benefits)

---

## 🎯 Overview

This project demonstrates a **Smart Home Control System** built using **four major design patterns**:
1. **Observer Pattern** - For device notifications
2. **Factory Method Pattern** - For dynamic device creation
3. **Mediator Pattern** - For centralized device management
4. **Proxy Pattern** - For security and logging (Cases 4 & 5 only)

The system allows users to add smart devices (Lights, Fans, Air Conditioners, Door Locks), control them, monitor their status, broadcast notifications, and activate security mode with authentication and logging.

---

## 🏗️ Design Patterns Used

### 1️⃣ **Observer Pattern**
**Purpose:** Enables one-to-many communication where multiple devices (observers) get notified when an event occurs.

**Implementation:** All devices implement the `Device` interface with an `update()` method that receives notifications.

**Use Cases:**
- Notify All Devices (Case 4)
- Security Mode broadcasts (Case 5)

**Benefits:**
- Loose coupling between devices
- Easy to add new observers
- Automatic synchronization

---

### 2️⃣ **Factory Method Pattern**
**Purpose:** Creates device objects without specifying their exact class names.

**Implementation:** `DeviceFactory` class with a static `createDevice()` method that returns appropriate device instances based on type string.

**Use Cases:**
- Add New Device (Case 1)

**Benefits:**
- Centralized object creation
- Easy to extend with new device types
- Reduces code duplication

---

### 3️⃣ **Mediator Pattern**
**Purpose:** Centralizes complex communications and control logic between devices through a mediator (hub).

**Implementation:** `SmartHomeHub` acts as the mediator, managing all devices and coordinating their interactions.

**Use Cases:**
- Control Device (Case 2)
- Display All Statuses (Case 3)
- Coordinate Security Mode (Case 5)

**Benefits:**
- Devices don't need to know about each other
- Simplifies maintenance
- Centralized control logic

---

### 4️⃣ **Proxy Pattern** *(Applied ONLY to Cases 4 & 5)*
**Purpose:** Adds a security and logging layer for critical operations (notifications and security mode).

**Implementation:** `DeviceProxy` wraps real devices and intercepts calls to `update()` and security methods, adding authentication and logging.

**Use Cases:**
- Notify All Devices (Case 4) - Logs all notifications
- Security Mode (Case 5) - Authenticates and logs security actions

**Benefits:**
- Transparent security layer
- Centralized logging
- No changes to real device classes
- Selective application (not used for regular control)

---

## 📁 Project Structure

```
SmartHomeSystem/
│
├── Device.java                 # Observer Interface
├── Light.java                  # Concrete Device (Observer)
├── Fan.java                    # Concrete Device (Observer)
├── AirConditioner.java         # Concrete Device (Observer)
├── DoorLock.java               # Concrete Device (Observer)
├── DeviceFactory.java          # Factory Method Pattern
├── SmartHomeHub.java           # Mediator Pattern
├── DeviceProxy.java            # Proxy Pattern (Cases 4 & 5 only)
└── SmartHomeApp.java           # Main Application
```

---

## 💻 Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **Text Editor** or **IDE** (IntelliJ IDEA, Eclipse, VS Code)
- **Terminal/Command Prompt**

### Steps

1. **Create Project Directory**
```bash
mkdir SmartHomeSystem
cd SmartHomeSystem
```

2. **Create Java Files**
Create all 8 Java files in the directory:
- Device.java
- Light.java
- Fan.java
- AirConditioner.java
- DoorLock.java
- DeviceFactory.java
- DeviceProxy.java
- SmartHomeHub.java
- SmartHomeApp.java

3. **Copy Code**
Copy the respective code into each file.

---

## 🚀 How to Run

### Compile All Files
```bash
javac *.java
```

### Run the Application
```bash
java SmartHomeApp
```

### Expected Output
```
🏠 My Smart Home Hub initialized!

🎉 Welcome to Smart Home Control System! 🎉
🛡️  Proxy Pattern: Cases 4 & 5 Only! 🛡️
==========================================
Security Mode password: admin123
==========================================

╔════════════════════════════════════╗
║     SMART HOME CONTROL MENU        ║
╠════════════════════════════════════╣
║ 1. Add New Device                  ║
║ 2. Control Device (No Proxy)      ║
║ 3. Display All Device Status       ║
║ 4. Notify All (Proxy) 🛡️          ║
║ 5. Security Mode (Proxy) 🛡️       ║
║ 6. Exit                            ║
╚════════════════════════════════════╝
Enter your choice:
```

---

## ✨ Features & Functionalities

### **Case 1: Add New Device** 🏭
**Design Pattern:** Factory Method

**Functionality:**
- Creates devices dynamically based on user input
- Supports: Light, Fan, AC, DoorLock
- Device is wrapped in a Proxy internally for future security operations

**Example:**
```
Enter device type: Light
Enter device name: Living Room Light
✅ Living Room Light registered to My Smart Home Hub
```

**Code Flow:**
```java
Device device = DeviceFactory.createDevice("light", "Living Room Light");
hub.registerDevice(device); // Wraps in proxy internally
```

---

### **Case 2: Control Device** 🔀
**Design Pattern:** Mediator

**Functionality:**
- Direct control of individual devices
- No proxy overhead (for performance)
- Commands: ON/OFF

**Example:**
```
Enter device name: Living Room Light
Enter command (ON/OFF): ON

📤 Sending command to Living Room Light: ON
ℹ️  [NO PROXY] Direct device control
💡 Living Room Light is now ON
```

**Code Flow:**
```java
hub.sendCommand("Living Room Light", "ON");
  ↓
proxy.turnOn(); // Pass-through, no proxy logic
  ↓
realDevice.turnOn();
```

---

### **Case 3: Display All Device Status** 📊
**Design Pattern:** Mediator

**Functionality:**
- Shows status of all registered devices
- Displays security mode state

**Example:**
```
📊 === Device Status Report ===
   Living Room Light: ON
   Bedroom Fan: OFF
   Front Door: UNLOCKED
Security Mode: INACTIVE
================================
```

**Code Flow:**
```java
hub.displayAllStatuses();
  ↓
Loops through all devices and prints status
```

---

### **Case 4: Notify All Devices** 🛡️ 👁️
**Design Patterns:** Observer + Proxy

**Functionality:**
- Broadcasts message to ALL devices
- **PROXY INTERCEPTS:** Logs every notification
- All devices receive update simultaneously

**Example:**
```
Enter notification message: System update tonight

📢 Broadcasting to all devices: System update tonight
🛡️ [PROXY PATTERN ACTIVE] Intercepting and logging all notifications...

🛡️ [PROXY] Intercepting notification for Living Room Light
   📝 [PROXY LOG] Notification logged: "System update tonight" → Living Room Light
💡 Living Room Light received notification: System update tonight

🛡️ [PROXY] Intercepting notification for Front Door
   📝 [PROXY LOG] Notification logged: "System update tonight" → Front Door
🔒 Front Door received notification: System update tonight

✅ All notifications sent via Proxy
```

**Code Flow:**
```java
hub.notifyAllDevices("System update tonight");
  ↓
For each device:
  proxy.update(message);
    ↓
  Proxy intercepts and logs
    ↓
  realDevice.update(message);
```

---

### **Case 5: Activate Security Mode** 🛡️ 🔀 👁️
**Design Patterns:** Mediator + Observer + Proxy

**Functionality:**
- Requires ADMIN authentication (`admin123`)
- **PROXY AUTHENTICATES:** Each device through proxy
- **PROXY LOGS:** Every security action
- Automatically:
  - Turns OFF all lights
  - LOCKS all doors

**Example:**
```
Enter ADMIN password: admin123

🚨 ATTEMPTING TO ACTIVATE SECURITY MODE 🚨
🛡️ [PROXY PATTERN ACTIVE] Authenticating all devices...

🔓 Security access granted for Living Room Light
🔓 Security access granted for Bedroom Fan
🔓 Security access granted for Front Door

✅ All devices authenticated via Proxy. Executing Security Protocol...

🛡️ [PROXY] Security command authorized for Living Room Light
   📝 [PROXY LOG] Security action: TURN OFF on Living Room Light
💡 Living Room Light is now OFF

🛡️ [PROXY] Security command authorized for Front Door
   📝 [PROXY LOG] Security action: TURN ON on Front Door
🔒 Front Door is now LOCKED

🔒 SECURITY MODE ACTIVE 🔒
```

**Code Flow:**
```java
hub.activateSecurityMode("admin123");
  ↓
Step 1: Authenticate all devices via proxy
  for each proxy:
    proxy.authenticateForSecurity("admin123");
  ↓
Step 2: Execute security protocol
  for each proxy:
    if (Light): proxy.securityTurnOff();
    if (DoorLock): proxy.securityTurnOn();
      ↓
    Proxy logs action
      ↓
    realDevice.turnOff()/turnOn();
  ↓
Step 3: Reset authentication
```

---

## 🔍 Detailed Code Explanation

### **Device Interface (Observer)**
```java
public interface Device {
    void update(String message);    // Receive notifications
    void turnOn();                  // Turn device ON
    void turnOff();                 // Turn device OFF
    String getDeviceName();         // Get device name
    String getStatus();             // Get current status
}
```

**Purpose:** Defines contract for all smart devices. Implements Observer pattern.

---

### **Concrete Devices (Light, Fan, AC, DoorLock)**

#### Example: Light.java
```java
public class Light implements Device {
    private String name;
    private boolean isOn;
    
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("💡 " + name + " is now ON");
    }
    
    @Override
    public void update(String message) {
        System.out.println("💡 " + name + " received: " + message);
    }
}
```

**Key Points:**
- Each device maintains its own state
- Implements all Device interface methods
- Unique behavior per device type

---

### **DeviceFactory (Factory Method Pattern)**
```java
public class DeviceFactory {
    public static Device createDevice(String type, String name) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(name);
            case "fan":
                return new Fan(name);
            case "ac":
                return new AirConditioner(name);
            case "doorlock":
                return new DoorLock(name);
            default:
                return null;
        }
    }
}
```

**Key Methods:**
- `createDevice(String type, String name)`: Static factory method that creates appropriate device based on type string

**Benefits:**
- Encapsulates object creation logic
- Easy to add new device types
- Client code doesn't need to know concrete classes

---

### **DeviceProxy (Proxy Pattern - Cases 4 & 5 Only)**
```java
public class DeviceProxy implements Device {
    private Device realDevice;
    private boolean securityAuthenticated;
    
    // Regular methods pass through (NO PROXY)
    public void turnOn() {
        realDevice.turnOn();  // Direct pass-through
    }
    
    // Notification method (PROXY ACTIVE - Case 4)
    public void update(String message) {
        System.out.println("🛡️ [PROXY] Intercepting...");
        logNotification(message);  // Proxy logs
        realDevice.update(message); // Forward to real device
    }
    
    // Security methods (PROXY ACTIVE - Case 5)
    public void securityTurnOff() {
        if (!securityAuthenticated) {
            System.out.println("❌ Not authenticated");
            return;
        }
        logSecurityAction("TURN OFF");
        realDevice.turnOff();
    }
}
```

**Key Methods:**

1. **`turnOn()` / `turnOff()`** - Direct pass-through (NO proxy logic)
2. **`update(String message)`** - Intercepts, logs, forwards (Case 4)
3. **`authenticateForSecurity(String password)`** - Authenticates for security mode
4. **`securityTurnOn()` / `securityTurnOff()`** - Authenticated control with logging (Case 5)
5. **`logNotification(String message)`** - Private logging for notifications
6. **`logSecurityAction(String action)`** - Private logging for security actions

**Why Proxy Only for Cases 4 & 5:**
- Regular control (Case 2) needs to be fast - no overhead
- Notifications and security are critical - need logging and authentication
- Selective proxy application = better performance

---

### **SmartHomeHub (Mediator Pattern)**
```java
public class SmartHomeHub {
    private List<DeviceProxy> devices;
    
    // Register device (wraps in proxy internally)
    public void registerDevice(Device device) {
        DeviceProxy proxy = new DeviceProxy(device);
        devices.add(proxy);
    }
    
    // Case 2: Direct control (NO PROXY)
    public void sendCommand(String deviceName, String command) {
        // Find device and call turnOn()/turnOff()
        // Proxy passes through directly
    }
    
    // Case 4: Notify all (PROXY ACTIVE)
    public void notifyAllDevices(String message) {
        for (DeviceProxy proxy : devices) {
            proxy.update(message);  // Proxy intercepts
        }
    }
    
    // Case 5: Security mode (PROXY ACTIVE)
    public void activateSecurityMode(String password) {
        // Step 1: Authenticate all devices via proxy
        // Step 2: Execute security protocol via proxy
        // Step 3: Reset authentication
    }
}
```

**Key Methods:**

1. **`registerDevice(Device device)`**
   - Wraps device in proxy
   - Adds to device list
   - One-time setup for proxy support

2. **`sendCommand(String deviceName, String command)`**
   - Finds device by name
   - Calls turnOn()/turnOff() directly (no proxy logic)
   - Used by Case 2

3. **`notifyAllDevices(String message)`**
   - Loops through all devices
   - Calls proxy.update() which intercepts and logs
   - Used by Case 4

4. **`activateSecurityMode(String password)`**
   - Authenticates all devices via `proxy.authenticateForSecurity()`
   - If all authenticated, executes security protocol
   - Calls `proxy.securityTurnOff()` / `proxy.securityTurnOn()`
   - Resets authentication after completion
   - Used by Case 5

5. **`displayAllStatuses()`**
   - Iterates through devices
   - Displays name and status
   - Shows security mode state

---

### **SmartHomeApp (Main Application)**
```java
public class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub("My Smart Home Hub");
        
        while (running) {
            displayMenu();
            // Handle user input with switch-case
        }
    }
}
```

**Key Methods:**

1. **`addDevice(Scanner scanner, SmartHomeHub hub)`**
   - Gets device type and name from user
   - Uses DeviceFactory to create device
   - Registers with hub (hub wraps in proxy)

2. **`controlDevice(Scanner scanner, SmartHomeHub hub)`**
   - Lists all devices
   - Gets device name and command
   - Calls `hub.sendCommand()` (no proxy logic)

3. **`notifyDevices(Scanner scanner, SmartHomeHub hub)`**
   - Gets message from user
   - Calls `hub.notifyAllDevices()` (proxy intercepts)

4. **`activateSecurityMode(Scanner scanner, SmartHomeHub hub)`**
   - Gets admin password from user
   - Calls `hub.activateSecurityMode()` (proxy authenticates and logs)

---

## 📖 Usage Examples

### Complete Workflow Example

```bash
# Start the application
java SmartHomeApp

# Step 1: Add devices
Choice: 1
Device type: Light
Device name: Living Room Light

Choice: 1
Device type: DoorLock
Device name: Front Door

Choice: 1
Device type: Fan
Device name: Bedroom Fan

# Step 2: Control a device (NO PROXY)
Choice: 2
Device name: Living Room Light
Command: ON
# Output: ℹ️ [NO PROXY] Direct device control

# Step 3: Check statuses
Choice: 3
# Shows all device statuses

# Step 4: Notify all devices (PROXY ACTIVE)
Choice: 4
Message: System maintenance at midnight
# Output: 🛡️ [PROXY] Intercepting notification...
# Output: 📝 [PROXY LOG] Notification logged...

# Step 5: Activate Security Mode (PROXY ACTIVE)
Choice: 5
Password: admin123
# Output: 🛡️ [PROXY] Security command authorized...
# Output: 📝 [PROXY LOG] Security action: TURN OFF...
# All lights OFF, all doors LOCKED

# Step 6: Exit
Choice: 6
```

---

## 🎯 Design Pattern Benefits

### **Why Observer Pattern?**
✅ Decouples devices from notification system  
✅ Easy to add new observers without modifying existing code  
✅ Supports broadcast communication (one-to-many)  
✅ Devices automatically stay synchronized

### **Why Factory Method Pattern?**
✅ Centralizes object creation logic  
✅ Easy to add new device types (just add a case)  
✅ Client code doesn't need to know concrete classes  
✅ Promotes Open/Closed Principle

### **Why Mediator Pattern?**
✅ Reduces coupling between devices  
✅ Centralizes complex control logic  
✅ Easier to maintain and modify system behavior  
✅ Devices don't need to know about each other

### **Why Proxy Pattern (Only for Cases 4 & 5)?**
✅ Adds security layer without modifying device classes  
✅ Centralized logging for critical operations  
✅ Transparent to client code  
✅ Selective application = better performance  
✅ Easy to add/remove security features

---

## 🔐 Security Features

### Authentication
- **Password:** `admin123` (for Security Mode only)
- **Authentication Level:** ADMIN required for Case 5
- **Timeout:** Authentication resets after Security Mode execution

### Logging
- All notifications logged (Case 4)
- All security actions logged (Case 5)
- Timestamp and action details captured

---

## 🧪 Testing Scenarios

### Scenario 1: Basic Device Control
```
Add Light → Control Light ON → Check Status → Control Light OFF
Expected: Direct control without proxy overhead
```

### Scenario 2: Notification Broadcasting
```
Add 3 devices → Notify All with message
Expected: All devices receive notification with proxy logging
```

### Scenario 3: Security Mode
```
Add Light + DoorLock → Security Mode with correct password
Expected: Light turns OFF, Door locks, all actions logged
```

### Scenario 4: Failed Authentication
```
Security Mode with wrong password
Expected: Authentication fails, no devices controlled
```

---

## 🚀 Future Enhancements

1. **More Device Types:** TV, Thermostat, Camera, Alarm
2. **Persistent Storage:** Save device states to file/database
3. **Scheduling:** Automate devices based on time
4. **Remote Access:** Web/mobile interface
5. **Multiple Users:** Role-based access control
6. **Advanced Logging:** Log to file with timestamps
7. **Device Groups:** Control multiple devices as a group
8. **Conditional Automation:** If-then rules (e.g., "If motion detected, turn on lights")

---

## 📚 Learning Outcomes

By studying this project, you will understand:

1. ✅ How to implement Observer Pattern for event-driven systems
2. ✅ How to use Factory Method Pattern for object creation
3. ✅ How to apply Mediator Pattern for centralized control
4. ✅ How to implement Proxy Pattern selectively for security
5. ✅ How multiple design patterns work together in a real system
6. ✅ Best practices for Java software architecture
7. ✅ Separation of concerns and SOLID principles

---

## 👨‍💻 Author

Smart Home Control System - Design Patterns Demonstration Project

**Technologies:** Java, Design Patterns (Observer, Factory, Mediator, Proxy)

---

## 📄 License

This project is created for educational purposes to demonstrate design pattern implementation.

---

## 🙏 Acknowledgments

- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)
- Head First Design Patterns
- Effective Java by Joshua Bloch

---

## 📞 Support

For questions or issues:
1. Review the code comments
2. Check the detailed explanations above
3. Test with the provided usage examples
4. Experiment with different scenarios

---

**Happy Coding! 🎉**