public class Singleton {
    // Private constructor prevents external instantiation
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Inner static class responsible for holding the Singleton instance
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to provide access to the Singleton instance
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
// describe the templete for desigin pattern 
// what are the elemets of the pattern 4 points
// describe teh classification of desigin pattern deppending on purose and scope 