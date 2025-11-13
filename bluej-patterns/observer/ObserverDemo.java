package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== OBSERVER PATTERN DEMO ===\n");
        
        Publisher blog = new Publisher("Tech Blog");
        
        Subscriber john = new EmailSubscriber("John", "john@email.com");
        Subscriber jane = new SMSSubscriber("Jane", "+1234567890");
        Subscriber bob = new EmailSubscriber("Bob", "bob@email.com");
        
        blog.subscribe(john);
        blog.subscribe(jane);
        blog.subscribe(bob);
        
        blog.publishPost(
            "Design Patterns Explained",
            "In this article, we explore the most common design patterns used in software engineering..."
        );
        
        System.out.println("\n");
        blog.unsubscribe(jane);
        
        blog.publishPost(
            "Java 21 Features",
            "Java 21 brings exciting new features including virtual threads, pattern matching..."
        );
    }
}
