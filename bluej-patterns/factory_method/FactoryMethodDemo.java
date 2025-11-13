package factory_method;

/**
 * Demo class cho Factory Method Pattern
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== FACTORY METHOD PATTERN DEMO ===\n");
        
        // Tạo Technical Post
        PostFactory techFactory = new TechnicalPostFactory();
        Post techPost = techFactory.createAndPublish(
            "Java Design Patterns Tutorial",
            "Learn about Gang of Four design patterns...",
            "John Doe"
        );
        
        // Tạo News Post
        PostFactory newsFactory = new NewsPostFactory();
        Post newsPost = newsFactory.createAndPublish(
            "Tech Industry Update",
            "Latest news from the technology sector...",
            "Jane Smith"
        );
        
        // Tạo Lifestyle Post
        PostFactory lifestyleFactory = new LifestylePostFactory();
        Post lifestylePost = lifestyleFactory.createAndPublish(
            "Work-Life Balance Tips",
            "How to maintain healthy work-life balance...",
            "Mike Johnson"
        );
        
        System.out.println("\n=== Factory Method Demo Complete ===");
    }
}
