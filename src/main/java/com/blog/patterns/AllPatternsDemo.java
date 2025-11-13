package com.blog.patterns;

/**
 * Master Demo for All 12 Design Patterns
 * Each pattern is in its own folder
 */
public class AllPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║          12 DESIGN PATTERNS - BLOG WEBSITE               ║");
        System.out.println("║                                                          ║");
        System.out.println("║      Each pattern in its own folder (package)            ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        System.out.println("📁 PROJECT STRUCTURE:\n");
        System.out.println("com.blog.patterns/");
        System.out.println("├── pattern01_singleton/          [Singleton Pattern]");
        System.out.println("├── pattern02_factory_method/     [Factory Method Pattern]");
        System.out.println("├── pattern03_abstract_factory/   [Abstract Factory Pattern]");
        System.out.println("├── pattern04_builder/            [Builder Pattern]");
        System.out.println("├── pattern05_prototype/          [Prototype Pattern]");
        System.out.println("├── pattern06_adapter/            [Adapter Pattern]");
        System.out.println("├── pattern07_decorator/          [Decorator Pattern]");
        System.out.println("├── pattern08_facade/             [Facade Pattern]");
        System.out.println("├── pattern09_proxy/              [Proxy Pattern]");
        System.out.println("├── pattern10_observer/           [Observer Pattern]");
        System.out.println("├── pattern11_strategy/           [Strategy Pattern]");
        System.out.println("├── pattern12_template_method/    [Template Method Pattern]");
        System.out.println("└── shared/                       [Shared models - BlogPost, etc]");
        
        System.out.println("\n\n🎯 HOW TO RUN INDIVIDUAL PATTERN DEMOS:\n");
        
        String[][] patterns = {
            {"01", "Singleton", "pattern01_singleton.SingletonDemo"},
            {"02", "Factory Method", "pattern02_factory_method.Demo"},
            {"03", "Abstract Factory", "pattern03_abstract_factory.Demo"},
            {"04", "Builder", "pattern04_builder.Demo"},
            {"05", "Prototype", "pattern05_prototype.Demo"},
            {"06", "Adapter", "pattern06_adapter.Demo"},
            {"07", "Decorator", "pattern07_decorator.Demo"},
            {"08", "Facade", "pattern08_facade.Demo"},
            {"09", "Proxy", "pattern09_proxy.Demo"},
            {"10", "Observer", "pattern10_observer.Demo"},
            {"11", "Strategy", "pattern11_strategy.Demo"},
            {"12", "Template Method", "pattern12_template_method.Demo"}
        };
        
        for (String[] pattern : patterns) {
            System.out.printf("  %s. %-20s mvn exec:java -Dexec.mainClass=\"com.blog.patterns.%s\"%n", 
                pattern[0], pattern[1], pattern[2]);
        }
        
        System.out.println("\n\n📚 DOCUMENTATION:\n");
        System.out.println("  Each pattern folder contains:");
        System.out.println("    • Implementation files (*.java)");
        System.out.println("    • Demo.java - Runnable demonstration");
        System.out.println("    • README.md - Pattern explanation in Vietnamese & English");
        
        System.out.println("\n\n🏗️  PATTERN CATEGORIES:\n");
        System.out.println("  CREATIONAL PATTERNS (5):");
        System.out.println("    01. Singleton      - One instance globally");
        System.out.println("    02. Factory Method - Create objects by type");
        System.out.println("    03. Abstract Factory - Families of related objects");
        System.out.println("    04. Builder        - Construct complex objects step by step");
        System.out.println("    05. Prototype      - Clone from templates");
        
        System.out.println("\n  STRUCTURAL PATTERNS (4):");
        System.out.println("    06. Adapter        - Convert interfaces");
        System.out.println("    07. Decorator      - Add responsibilities dynamically");
        System.out.println("    08. Facade         - Simplified interface");
        System.out.println("    09. Proxy          - Control access/lazy loading");
        
        System.out.println("\n  BEHAVIORAL PATTERNS (3):");
        System.out.println("    10. Observer       - Notify dependents of changes");
        System.out.println("    11. Strategy       - Interchangeable algorithms");
        System.out.println("    12. Template Method - Algorithm skeleton");
        
        System.out.println("\n\n✨ FORMS (Using All 12 Patterns):\n");
        System.out.println("  The forms/ package contains 4 complete forms that");
        System.out.println("  demonstrate all 12 patterns working together:");
        System.out.println("    • post-submission-form.html");
        System.out.println("    • blog-settings-form.html");
        System.out.println("    • single-post-form.html");
        System.out.println("    • list-posts-form.html");
        
        System.out.println("\n\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          ✅ PROJECT STRUCTURE COMPLETE                   ║");
        System.out.println("║   Each of 12 patterns is now in its own folder!          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}
