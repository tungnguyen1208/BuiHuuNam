package com.blog.patterns.pattern02_factory_method;

import com.blog.patterns.shared.*;

/**
 * Demo class for Factory Method Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         FACTORY METHOD                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Định nghĩa interface để tạo object nhưng để subclass quyết định class nào sẽ được khởi tạo");
        System.out.println("English: Defines an interface for creating objects but lets subclasses decide which class to instantiate\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        // Create Technical post
        PostFactory factory = new TechnicalPostFactory();
        BlogPost post = factory.createPost("Java Patterns", "Content...", "Author");
        System.out.println("Created: " + post);
        
        // Create Lifestyle post
        factory = new LifestylePostFactory();
        post = factory.createPost("Healthy Living", "Tips...", "Author");
        System.out.println("Created: " + post);

        
        System.out.println("\n✅ Factory Method Pattern demonstrated successfully!");
    }
}
