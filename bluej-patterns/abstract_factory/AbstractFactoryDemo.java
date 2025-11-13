package abstract_factory;

/**
 * Demo class cho Abstract Factory Pattern
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== ABSTRACT FACTORY PATTERN DEMO ===\n");
        
        // Tạo blog với Modern theme
        System.out.println("--- Creating blog with MODERN theme ---");
        ThemeFactory modernFactory = new ModernThemeFactory();
        BlogPage modernBlog = new BlogPage(modernFactory);
        modernBlog.setupPage();
        modernBlog.render();
        modernBlog.showStyles();
        
        System.out.println("\n\n");
        
        // Tạo blog với Classic theme
        System.out.println("--- Creating blog with CLASSIC theme ---");
        ThemeFactory classicFactory = new ClassicThemeFactory();
        BlogPage classicBlog = new BlogPage(classicFactory);
        classicBlog.setupPage();
        classicBlog.render();
        classicBlog.showStyles();
        
        System.out.println("\n=== Abstract Factory Demo Complete ===");
    }
}
