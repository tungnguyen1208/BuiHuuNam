package com.blog.patterns.pattern10_observer;

import com.blog.patterns.shared.*;

/**
 * Demo class for Observer Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                            OBSERVER                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Định nghĩa one-to-many dependency để khi object thay đổi, tất cả dependents được notify");
        System.out.println("English: Defines a one-to-many dependency so when one object changes state, all dependents are notified\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        BlogPublisher publisher = new BlogPublisher();
        
        publisher.subscribe(new EmailSubscriber("user@example.com"));
        publisher.subscribe(new SMSSubscriber("+123456789"));
        
        BlogPost post = new BlogPost("Title", "Content", "Author");
        publisher.publishPost(post);  // All subscribers notified

        
        System.out.println("\n✅ Observer Pattern demonstrated successfully!");
    }
}
