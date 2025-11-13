package prototype;

public class PrototypeDemo {
    public static void main(String[] args) {
        System.out.println("=== PROTOTYPE PATTERN DEMO ===\n");
        
        PostRegistry registry = new PostRegistry();
        
        // Clone từ technical template
        BlogPost post1 = registry.getTemplate("technical");
        post1.setTitle(post1.getTitle() + "Java Streams API");
        post1.display();
        
        // Clone thêm từ technical template
        BlogPost post2 = registry.getTemplate("technical");
        post2.setTitle(post2.getTitle() + "Lambda Expressions");
        post2.display();
        
        // Clone từ news template
        BlogPost post3 = registry.getTemplate("news");
        post3.setTitle(post3.getTitle() + "Java 21 Released");
        post3.display();
        
        System.out.println("\n=== Prototype Demo Complete ===");
    }
}
