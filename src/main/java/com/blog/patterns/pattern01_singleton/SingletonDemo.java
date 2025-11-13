package com.blog.patterns.pattern01_singleton;

/**
 * Demo class for Singleton Pattern
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           PATTERN 01: SINGLETON PATTERN               ║");
        System.out.println("║    Ensures only ONE instance exists globally          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        // Get first instance
        BlogConfiguration config1 = BlogConfiguration.getInstance();
        System.out.println("Created first instance");
        config1.displaySettings();
        
        // Try to get another instance
        BlogConfiguration config2 = BlogConfiguration.getInstance();
        System.out.println("\nTried to create second instance");
        
        // Verify both references point to same object
        System.out.println("\nAre both instances the same object? " + (config1 == config2));
        
        // Modify through one reference
        config1.setSetting("blogName", "Updated Blog Name");
        
        // Check through other reference
        System.out.println("\nAfter updating via config1:");
        config2.displaySettings();
        
        System.out.println("\n✅ Singleton Pattern demonstrated successfully!");
        System.out.println("   Only ONE instance exists regardless of how many times getInstance() is called.");
    }
}
