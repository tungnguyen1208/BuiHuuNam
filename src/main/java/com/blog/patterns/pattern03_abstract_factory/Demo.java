package com.blog.patterns.pattern03_abstract_factory;

import com.blog.patterns.shared.*;

/**
 * Demo class for Abstract Factory Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                        ABSTRACT FACTORY                  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Cung cấp interface để tạo families of related objects mà không cần chỉ định concrete classes");
        System.out.println("English: Provides an interface for creating families of related objects without specifying concrete classes\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        // Modern theme
        UIComponentFactory factory = new ModernUIFactory();
        Button btn = factory.createButton();
        Header header = factory.createHeader();
        btn.render();
        header.render();

        
        System.out.println("\n✅ Abstract Factory Pattern demonstrated successfully!");
    }
}
