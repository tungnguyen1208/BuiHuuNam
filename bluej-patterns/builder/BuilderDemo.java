package builder;

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== BUILDER PATTERN DEMO ===\n");
        
        // Build article bước by step
        Article article1 = new Article.Builder()
            .setTitle("Java Builder Pattern")
            .setAuthor("John Doe")
            .setContent("Learn how to use Builder pattern...")
            .setCategory("Tutorial")
            .addTag("java")
            .addTag("design-patterns")
            .addTag("builder")
            .addImage("diagram1.png")
            .addImage("code-example.png")
            .setPublished(true)
            .setCommentsEnabled(true)
            .build();
        
        article1.display();
        
        // Build article đơn giản hơn
        Article article2 = new Article.Builder()
            .setTitle("Quick Post")
            .setAuthor("Jane Smith")
            .setContent("Short content here")
            .build();
        
        article2.display();
    }
}
