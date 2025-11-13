package com.blog.patterns.pattern12_template_method;

import com.blog.patterns.shared.*;

/**
 * Demo class for Template Method Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                        TEMPLATE METHOD                   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Định nghĩa skeleton of algorithm, để subclass override các bước cụ thể");
        System.out.println("English: Defines the skeleton of an algorithm, letting subclasses override specific steps\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        PostPublishingTemplate publisher = new TechnicalPostPublisher();
        BlogPost post = new BlogPost("Java Guide", "Content", "Author");
        
        publisher.publishPost(post);  // Executes template workflow

        
        System.out.println("\n✅ Template Method Pattern demonstrated successfully!");
    }
}
