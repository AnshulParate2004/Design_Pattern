// Proxy Pattern - Only for Notify All and Security Mode
public class DeviceProxy implements Device {
    private Device realDevice;
    private boolean securityAuthenticated;
    
    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
        this.securityAuthenticated = false;
    }
    
    // Authentication for Security Mode ONLY
    public boolean authenticateForSecurity(String password) {
        if (password.equals("admin123")) {
            securityAuthenticated = true;
            System.out.println("🔓 Security access granted for " + realDevice.getDeviceName());
            return true;
        }
        System.out.println("🔒 Security authentication failed for " + realDevice.getDeviceName());
        return false;
    }
    
    // Regular control - NO PROXY (passes through directly)
    @Override
    public void turnOn() {
        realDevice.turnOn();  // Direct pass-through, no proxy logic
    }
    
    @Override
    public void turnOff() {
        realDevice.turnOff();  // Direct pass-through, no proxy logic
    }
    
    // UPDATE method - PROXY ACTIVE for Notify All (Case 4)
    @Override
    public void update(String message) {
        System.out.println("🛡️ [PROXY] Intercepting notification for " + realDevice.getDeviceName());
        logNotification(message);
        realDevice.update(message);
    }
    
    // Security Mode control - PROXY ACTIVE (Case 5)
    public void securityTurnOn() {
        if (!securityAuthenticated) {
            System.out.println("❌ [PROXY] Security mode not authenticated for " + realDevice.getDeviceName());
            return;
        }
        System.out.println("🛡️ [PROXY] Security command authorized for " + realDevice.getDeviceName());
        logSecurityAction("TURN ON");
        realDevice.turnOn();
    }
    
    public void securityTurnOff() {
        if (!securityAuthenticated) {
            System.out.println("❌ [PROXY] Security mode not authenticated for " + realDevice.getDeviceName());
            return;
        }
        System.out.println("🛡️ [PROXY] Security command authorized for " + realDevice.getDeviceName());
        logSecurityAction("TURN OFF");
        realDevice.turnOff();
    }
    
    @Override
    public String getDeviceName() {
        return realDevice.getDeviceName();
    }
    
    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }
    
    // Logging for Notify All (Case 4)
    private void logNotification(String message) {
        System.out.println("   📝 [PROXY LOG] Notification logged: \"" + message + "\" → " + realDevice.getDeviceName());
    }
    
    // Logging for Security Mode (Case 5)
    private void logSecurityAction(String action) {
        System.out.println("   📝 [PROXY LOG] Security action: " + action + " on " + realDevice.getDeviceName());
    }
    
    // Get the real device (for instanceof checks)
    public Device getRealDevice() {
        return realDevice;
    }
    
    // Reset authentication
    public void resetAuthentication() {
        securityAuthenticated = false;
    }
}