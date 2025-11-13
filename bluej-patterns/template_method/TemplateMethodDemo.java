package template_method;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== TEMPLATE METHOD PATTERN DEMO ===\n");
        
        PostProcessor techProcessor = new TechnicalPostProcessor();
        techProcessor.processPost(
            "Java Design Patterns",
            "This tutorial covers all major design patterns in Java programming..."
        );
        
        PostProcessor newsProcessor = new NewsPostProcessor();
        newsProcessor.processPost(
            "Breaking: Java 21 Released",
            "Oracle announces the release of Java 21 with exciting new features..."
        );
    }
}
