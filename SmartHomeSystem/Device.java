// Observer Interface
public interface Device {
    void update(String message);
    void turnOn();
    void turnOff();
    String getDeviceName();
    String getStatus();
}