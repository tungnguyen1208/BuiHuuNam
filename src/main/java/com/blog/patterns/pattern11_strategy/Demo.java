package com.blog.patterns.pattern11_strategy;

import com.blog.patterns.shared.*;

/**
 * Demo class for Strategy Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  STRATEGY PATTERN                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Định nghĩa family of algorithms và làm cho chúng interchangeable");
        System.out.println("English: Defines a family of algorithms and makes them interchangeable\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        BlogPost post = new BlogPost("Test Post", "Content here", "Author");
        ContentRenderer renderer = new ContentRenderer();
        
        // Use HTML strategy
        renderer.setStrategy(new HTMLRenderingStrategy());
        System.out.println("\nHTML Output:");
        System.out.println(renderer.renderContent(post));
        
        // Switch to JSON strategy
        renderer.setStrategy(new JSONRenderingStrategy());
        System.out.println("\nJSON Output:");
        System.out.println(renderer.renderContent(post));
        
        System.out.println("\n✅ Strategy Pattern demonstrated successfully!");
    }
}
