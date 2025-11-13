package singleton;

/**
 * Singleton Pattern - Blog Configuration
 * Đảm bảo chỉ có 1 instance duy nhất của cấu hình blog
 */
public class BlogConfig {
    // Static instance duy nhất
    private static BlogConfig instance;
    
    // Các thuộc tính cấu hình
    private String blogName;
    private String blogUrl;
    private String adminEmail;
    private int maxPostsPerPage;
    private boolean commentEnabled;
    
    // Private constructor ngăn khởi tạo từ bên ngoài
    private BlogConfig() {
        this.blogName = "My Tech Blog";
        this.blogUrl = "https://myblog.com";
        this.adminEmail = "admin@myblog.com";
        this.maxPostsPerPage = 10;
        this.commentEnabled = true;
    }
    
    // Static method để lấy instance duy nhất
    public static BlogConfig getInstance() {
        if (instance == null) {
            synchronized (BlogConfig.class) {
                if (instance == null) {
                    instance = new BlogConfig();
                }
            }
        }
        return instance;
    }
    
    // Getters and Setters
    public String getBlogName() {
        return blogName;
    }
    
    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
    
    public String getBlogUrl() {
        return blogUrl;
    }
    
    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
    
    public String getAdminEmail() {
        return adminEmail;
    }
    
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    
    public int getMaxPostsPerPage() {
        return maxPostsPerPage;
    }
    
    public void setMaxPostsPerPage(int maxPostsPerPage) {
        this.maxPostsPerPage = maxPostsPerPage;
    }
    
    public boolean isCommentEnabled() {
        return commentEnabled;
    }
    
    public void setCommentEnabled(boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
    }
    
    public void displayConfig() {
        System.out.println("=== Blog Configuration ===");
        System.out.println("Blog Name: " + blogName);
        System.out.println("Blog URL: " + blogUrl);
        System.out.println("Admin Email: " + adminEmail);
        System.out.println("Max Posts Per Page: " + maxPostsPerPage);
        System.out.println("Comments Enabled: " + commentEnabled);
    }
}
