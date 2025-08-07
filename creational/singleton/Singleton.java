// Singleton Design Pattern Example in Java

public class Singleton {
    // Static variable to hold the single instance
    private static Singleton instance;

    // Example fields (just to show how data can be held in the singleton)
    private String data;
    private int num;

    // Private default constructor to prevent direct instantiation
    private Singleton() { }

    // Overloaded private constructor to initialize fields
    private Singleton(String data, int num) {
        this.data = data;
        this.num = num;
    }

    /**
     * Public static method to provide global access to the instance.
     * If no instance exists, it creates one using the given parameters.
     * 
     * Note: Only the first call's arguments will be used for initialization.
     * Subsequent calls with different parameters will be ignored.
     */
    public static Singleton getInstance(String data, int num) {
        if (instance == null) {
            instance = new Singleton(data, num);
        }
        return instance;
    }
    @Override
    public String toString() {
        return "Data: " + data + ", Num: " + num;
    }

}
