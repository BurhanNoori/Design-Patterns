/*
* The Proxy pattern acts as a substitute or placeholder for another object.
It controls access to the real object, adding extra behavior without modifying the real one.

Think of it like:

A credit card (proxy) for your bank account (real subject).

You don’t always directly interact with the account — the card manages the access.

Why is it used?

To control access (e.g., security check before calling the real object).

To add lazy initialization (e.g., load a big image only when needed).

To add remote access (proxy connects to an object on a different server).

To add caching (save results so the real object isn’t called repeatedly).

What if it didn’t exist?

You’d directly use heavy or sensitive objects all the time, leading to:

Performance cost (loading heavy objects when not needed).

Security risks (no control on access).

Tight coupling (no abstraction layer).

* */

// Subject interface
interface Image {
    void display();
}

// Real Subject: the actual heavy object
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // heavy operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy: controls access to RealImage
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Lazy loading: only load when needed
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        // Images will be loaded only when first displayed
        image1.display();  // loads + displays
        image1.display();  // only displays, no reload
        image2.display();  // loads + displays
    }
}


