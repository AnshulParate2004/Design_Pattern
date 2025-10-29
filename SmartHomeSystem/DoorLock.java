/**
 * Door Lock Device Class - Concrete Observer
 * Purpose: Represents a smart door lock in the home automation system
 * Implements Device interface for uniform control
 * Maintains its own state (LOCKED/UNLOCKED)
 * Special behavior: turnOn locks the door, turnOff unlocks the door
 */
public class DoorLock implements Device {
    private String name;
    private boolean isLocked;

    /**
     * Constructor
     * Purpose: Initializes door lock with a name in UNLOCKED state
     */
    public DoorLock(String name) {
        this.name = name;
        this.isLocked = false;
    }

    /**
     * Turns device on (locks the door)
     * Purpose: Provides interface compliance, delegates to lock()
     */
    @Override
    public void turnOn() {
        lock();
    }

    /**
     * Turns device off (unlocks the door)
     * Purpose: Provides interface compliance, delegates to unlock()
     */
    @Override
    public void turnOff() {
        unlock();
    }

    /**
     * Locks the door
     * Purpose: Changes door state to LOCKED and displays confirmation
     */
    public void lock() {
        isLocked = true;
        System.out.println(name + " is now LOCKED");
    }

    /**
     * Unlocks the door
     * Purpose: Changes door state to UNLOCKED and displays confirmation
     */
    public void unlock() {
        isLocked = false;
        System.out.println(name + " is now UNLOCKED");
    }

    /**
     * Receives notification message
     * Purpose: Allows door lock to receive system notifications
     */
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    /**
     * Returns door lock name
     * Purpose: Identifies this specific door lock device
     */
    @Override
    public String getDeviceName() {
        return name;
    }

    /**
     * Returns current door lock status
     * Purpose: Provides current state of the door lock
     */
    @Override
    public String getStatus() {
        return isLocked ? "LOCKED" : "UNLOCKED";
    }
}