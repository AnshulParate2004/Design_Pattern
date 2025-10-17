// Concrete Observer - Light Device
public class Light implements Device {
    private String name;
    private boolean isOn;

    public Light(String name) {
        this.name = name;
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println( name + " is now ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    @Override
    public String getDeviceName() {
        return name;
    }

    @Override
    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }
}