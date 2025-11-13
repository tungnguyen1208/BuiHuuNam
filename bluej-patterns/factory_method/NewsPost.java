package factory_method;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Concrete Product - Bài viết tin tức
 */
public class NewsPost extends Post {
    private String location;
    private LocalDateTime publishTime;
    private boolean breaking;
    
    public NewsPost(String title, String content, String author) {
        super(title, content, author);
        this.category = "News";
        this.publishTime = LocalDateTime.now();
        this.location = "Vietnam";
        this.breaking = false;
    }
    
    @Override
    public String getPostType() {
        return "News Post";
    }
    
    @Override
    public void formatContent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Location: " + location);
        System.out.println("Published: " + publishTime.format(formatter));
        if (breaking) {
            System.out.println("⚠️ BREAKING NEWS ⚠️");
        }
        System.out.println("Format: News article with headline and dateline");
    }
    
    @Override
    public String getCategoryIcon() {
        return "📰";
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setBreaking(boolean breaking) {
        this.breaking = breaking;
    }
}
