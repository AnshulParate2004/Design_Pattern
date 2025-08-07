import java.io.*;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instance;
    private Properties config = new Properties(); // stored in RAM
    private static final String FILE_PATH = "config.properties"; // stored on disk

    // Private constructor
    private AppConfig() {
        loadFromDisk();
    }

    // Singleton instance method
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // RAM usage: set config in memory
    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    // RAM usage: get config from memory
    public String get(String key) {
        return config.getProperty(key);
    }

    // Storage: save to disk
    public void saveToDisk() {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            config.store(fos, "App Configuration");
            System.out.println("Saved to disk.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Storage: load from disk
    public void loadFromDisk() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            config.load(fis);
            System.out.println("Loaded from disk.");
        } catch (IOException e) {
            System.out.println("No config file found. Starting fresh.");
        }
    }
}
