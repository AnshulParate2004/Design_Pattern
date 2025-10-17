// Concrete Observer - Door Lock Device
public class DoorLock implements Device {
    private String name;
    private boolean isLocked;

    public DoorLock(String name) {
        this.name = name;
        this.isLocked = false;
    }

    @Override
    public void turnOn() {
        lock();
    }

    @Override
    public void turnOff() {
        unlock();
    }

    public void lock() {
        isLocked = true;
        System.out.println( name + " is now LOCKED");
    }

    public void unlock() {
        isLocked = false;
        System.out.println( name + " is now UNLOCKED");
    }

    @Override
    public void update(String message) {
        System.out.println( name + " received notification: " + message);
    }

    @Override
    public String getDeviceName() {
        return name;
    }

    @Override
    public String getStatus() {
        return isLocked ? "LOCKED" : "UNLOCKED";
    }
}