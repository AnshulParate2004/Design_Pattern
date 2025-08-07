// Singleton Design Pattern Example in Java (Thread-Safe using Double-Checked Locking)

public class SyncSingleton {
    // Volatile keyword ensures visibility and ordering guarantees across threads
    private static volatile SyncSingleton instance;

    private String data;
    private int num;

    // Private constructor to prevent direct instantiation
    private SyncSingleton() { }

    // Overloaded private constructor for initialization
    private SyncSingleton(String data, int num) {
        this.data = data;
        this.num = num;
    }

    /**
     * Returns the singleton instance of SyncSingleton.
     * Uses double-checked locking to ensure thread safety with better performance.
     *
     * Only the first thread that accesses this method when instance is null
     * will enter the synchronized block and create the instance.
     */
    public static SyncSingleton getInstance(String data, int num) {
        if (instance == null) {
            synchronized (SyncSingleton.class) { // Synchronize only once during initialization
                if (instance == null) {
                    instance = new SyncSingleton(data, num);
                }
            }
        }
        return instance;
    }
}
