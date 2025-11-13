package com.blog.patterns.pattern08_facade;

import com.blog.patterns.shared.*;

/**
 * Demo class for Facade Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                             FACADE                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Cung cấp unified interface đơn giản cho một subsystem phức tạp");
        System.out.println("English: Provides a unified interface to a set of interfaces in a subsystem\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        BlogManagementFacade facade = new BlogManagementFacade();
        BlogPost post = new BlogPost("Title", "Content", "Author");
        
        facade.publishPost(post);  // Handles all complex operations

        
        System.out.println("\n✅ Facade Pattern demonstrated successfully!");
    }
}
