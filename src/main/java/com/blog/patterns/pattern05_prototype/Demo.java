package com.blog.patterns.pattern05_prototype;

import com.blog.patterns.shared.*;

/**
 * Demo class for Prototype Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                           PROTOTYPE                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Tạo objects mới bằng cách clone từ một prototype instance");
        System.out.println("English: Creates new objects by cloning a prototypical instance\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        PostPrototypeRegistry registry = new PostPrototypeRegistry();
        
        // Clone from technical template
        BlogPost post = registry.createPost("technical", "New Title", "Content", "Author");
        System.out.println("Cloned: " + post);

        
        System.out.println("\n✅ Prototype Pattern demonstrated successfully!");
    }
}
