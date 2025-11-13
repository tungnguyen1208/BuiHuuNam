package com.blog.patterns.pattern04_builder;

import com.blog.patterns.shared.*;

/**
 * Demo class for Builder Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                            BUILDER                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Tách rời việc xây dựng một object phức tạp khỏi representation của nó");
        System.out.println("English: Separates the construction of a complex object from its representation\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        BlogPost post = new BlogPostBuilder()
            .setTitle("Design Patterns")
            .setAuthor("John Doe")
            .setContent("Content here...")
            .setCategory("Technical")
            .addTag("java")
            .addTag("patterns")
            .build();

        
        System.out.println("\n✅ Builder Pattern demonstrated successfully!");
    }
}
