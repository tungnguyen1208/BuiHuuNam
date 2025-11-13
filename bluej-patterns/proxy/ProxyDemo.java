package proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== PROXY PATTERN DEMO ===\n");
        
        System.out.println("Creating proxies (fast)...");
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");
        System.out.println("Proxies created!\n");
        
        System.out.println("First display (loads from disk):");
        image1.display();
        
        System.out.println("\nSecond display (already loaded):");
        image1.display();
        
        System.out.println("\nDisplay image2:");
        image2.display();
    }
}
