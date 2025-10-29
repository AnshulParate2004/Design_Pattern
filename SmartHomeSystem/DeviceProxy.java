/**
 * Device Proxy Class - Proxy Pattern
 * Purpose: Acts as a protective wrapper around real device objects
 * Provides authentication and logging for security-sensitive operations
 * Allows direct pass-through for normal operations
 * Key Feature: Only intercepts security mode operations, not regular control
 */
public class DeviceProxy implements Device {
    private Device realDevice;
    private boolean securityAuthenticated;
    
    /**
     * Constructor
     * Purpose: Wraps the real device object
     */
    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
        this.securityAuthenticated = false;
    }
    
    /**
     * Authenticates access for security mode operations
     * Purpose: Validates admin credentials before allowing security actions
     * Returns true if authentication successful, false otherwise
     */
    public boolean authenticateForSecurity(String password) {
        if (password.equals("admin123")) {
            securityAuthenticated = true;
            System.out.println(" Security access granted for " + realDevice.getDeviceName());
            return true;
        }
        System.out.println(" Security authentication failed for " + realDevice.getDeviceName());
        return false;
    }
    
    /**
     * Regular turnOn operation
     * Purpose: Direct pass-through without proxy logic
     * Used for normal device control
     */
    @Override
    public void turnOn() {
        realDevice.turnOn();
    }
    
    /**
     * Regular turnOff operation
     * Purpose: Direct pass-through without proxy logic
     * Used for normal device control
     */
    @Override
    public void turnOff() {
        realDevice.turnOff();
    }
    
    /**
     * Update notification method
     * Purpose: Direct pass-through for receiving notifications
     */
    @Override
    public void update(String message) {
        realDevice.update(message);
    }
    
    /**
     * Security mode turnOn operation
     * Purpose: Authenticated operation with logging for security protocol
     * Only executes if authentication is successful
     */
    public void securityTurnOn() {
        if (!securityAuthenticated) {
            System.out.println(" [PROXY] Security mode not authenticated for " + realDevice.getDeviceName());
            return;
        }
        System.out.println(" [PROXY] Security command authorized for " + realDevice.getDeviceName());
        logSecurityAction("TURN ON");
        realDevice.turnOn();
    }
    
    /**
     * Security mode turnOff operation
     * Purpose: Authenticated operation with logging for security protocol
     * Only executes if authentication is successful
     */
    public void securityTurnOff() {
        if (!securityAuthenticated) {
            System.out.println(" [PROXY] Security mode not authenticated for " + realDevice.getDeviceName());
            return;
        }
        System.out.println(" [PROXY] Security command authorized for " + realDevice.getDeviceName());
        logSecurityAction("TURN OFF");
        realDevice.turnOff();
    }
    
    /**
     * Returns device name
     * Purpose: Delegates to real device for name retrieval
     */
    @Override
    public String getDeviceName() {
        return realDevice.getDeviceName();
    }
    
    /**
     * Returns device status
     * Purpose: Delegates to real device for status retrieval
     */
    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }
    
    /**
     * Logs security actions
     * Purpose: Records all security-related operations for audit trail
     */
    private void logSecurityAction(String action) {
        System.out.println("    [PROXY LOG] Security action: " + action + " on " + realDevice.getDeviceName());
    }
    
    /**
     * Returns the real device object
     * Purpose: Allows access to actual device for type checking
     */
    public Device getRealDevice() {
        return realDevice;
    }
    
    /**
     * Resets authentication status
     * Purpose: Clears authentication after security mode execution
     */
    public void resetAuthentication() {
        securityAuthenticated = false;
    }
}