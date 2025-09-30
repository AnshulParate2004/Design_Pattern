package ProxyDesignPattern;

// Image.java - Subject Interface
interface Image {
    void display();
}

// RealImage.java - Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// ProxyImage.java - Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy loading
        }
        realImage.display();
    }
}

// Main.java - Client
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.png");

        // First time: loads from disk
        image.display();

        // Second time: uses cached object
        image.display();
    }
}
