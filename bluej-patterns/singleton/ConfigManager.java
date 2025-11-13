package singleton;

/**
 * Class quản lý cấu hình sử dụng Singleton
 */
public class ConfigManager {
    private BlogConfig config;
    
    public ConfigManager() {
        // Luôn lấy instance duy nhất
        this.config = BlogConfig.getInstance();
    }
    
    public void updateBlogName(String newName) {
        config.setBlogName(newName);
        System.out.println("Blog name updated to: " + newName);
    }
    
    public void showCurrentConfig() {
        config.displayConfig();
    }
    
    public boolean validateConfig() {
        if (config.getBlogName() == null || config.getBlogName().isEmpty()) {
            return false;
        }
        if (config.getMaxPostsPerPage() < 1) {
            return false;
        }
        return true;
    }
}
