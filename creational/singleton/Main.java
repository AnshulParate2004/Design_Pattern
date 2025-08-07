public class Main {
    public static void main(String[] args) {
        // Demonstrating non-thread-safe Singleton
        Singleton s1 = Singleton.getInstance("InitialData", 1);
        Singleton s2 = Singleton.getInstance("AnotherData", 2);

        System.out.println("== Non-thread-safe Singleton ==");
        System.out.println("Instance 1 hash: " + s1.hashCode());
        System.out.println("Instance 2 hash: " + s2.hashCode());
        System.out.println("Same instance: " + (s1 == s2));
        
        System.out.println("Singleton Instance Data: " + s1);
        System.out.println("Singleton Instance Data (Another): " + s2);
        //Once the singleton instance is created, any further calls to getInstance() do not change the internal data.

        System.out.println();

        // Demonstrating thread-safe SyncSingleton
        SyncSingleton sync1 = SyncSingleton.getInstance("SafeData", 10);
        SyncSingleton sync2 = SyncSingleton.getInstance("IgnoredData", 20);

        System.out.println("== Thread-safe SyncSingleton ==");
        System.out.println("Instance 1 hash: " + sync1.hashCode());
        System.out.println("Instance 2 hash: " + sync2.hashCode());
        System.out.println("Same instance: " + (sync1 == sync2));
    }
}
