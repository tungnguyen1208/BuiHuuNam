package singleton;

/**
 * Demo class cho Singleton Pattern
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== SINGLETON PATTERN DEMO ===\n");
        
        // Lấy instance 1
        BlogConfig config1 = BlogConfig.getInstance();
        config1.displayConfig();
        
        System.out.println("\n--- Thay đổi cấu hình qua config1 ---");
        config1.setBlogName("Advanced Java Blog");
        config1.setMaxPostsPerPage(20);
        
        // Lấy instance 2 - phải là cùng 1 object
        BlogConfig config2 = BlogConfig.getInstance();
        config2.displayConfig();
        
        // Kiểm tra xem có phải cùng 1 instance không
        System.out.println("\n--- Kiểm tra Singleton ---");
        System.out.println("config1 == config2: " + (config1 == config2));
        System.out.println("config1.hashCode(): " + config1.hashCode());
        System.out.println("config2.hashCode(): " + config2.hashCode());
    }
}
