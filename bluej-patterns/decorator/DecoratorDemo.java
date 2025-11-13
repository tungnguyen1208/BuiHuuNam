package decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== DECORATOR PATTERN DEMO ===\n");
        
        // Basic post
        Post basic = new BasicPost("Hello World", "This is content");
        basic.display();
        
        System.out.println("\n--- Adding images ---");
        Post withImages = new ImageDecorator(basic);
        withImages.display();
        
        System.out.println("\n--- Adding video ---");
        Post withVideo = new VideoDecorator(withImages);
        withVideo.display();
        
        System.out.println("\nTotal cost: $" + withVideo.getCost());
    }
}
