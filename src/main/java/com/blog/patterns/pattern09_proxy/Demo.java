package com.blog.patterns.pattern09_proxy;

import com.blog.patterns.shared.*;

/**
 * Demo class for Proxy Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                             PROXY                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Cung cấp placeholder cho object khác để control access");
        System.out.println("English: Provides a placeholder for another object to control access to it\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        PostContent content = new PostContentProxy("post-123");
        
        // Content not loaded yet
        System.out.println("Proxy created");
        
        // Now load content
        String text = content.getContent();  // Loads on demand

        
        System.out.println("\n✅ Proxy Pattern demonstrated successfully!");
    }
}
