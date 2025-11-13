package builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Product class - Article (Blog Post)
 */
public class Article {
    private String title;
    private String content;
    private String author;
    private String category;
    private List<String> tags;
    private List<String> images;
    private boolean published;
    private boolean commentsEnabled;
    
    // Private constructor - chỉ Builder mới tạo được
    private Article() {
        this.tags = new ArrayList<>();
        this.images = new ArrayList<>();
    }
    
    public void display() {
        System.out.println("\n=== Article ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Published: " + published);
        System.out.println("Comments Enabled: " + commentsEnabled);
        System.out.println("Tags: " + String.join(", ", tags));
        System.out.println("Images: " + images.size());
        System.out.println("Content: " + content);
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public List<String> getTags() { return tags; }
    public List<String> getImages() { return images; }
    public boolean isPublished() { return published; }
    public boolean isCommentsEnabled() { return commentsEnabled; }
    
    /**
     * Builder class - Tạo Article theo từng bước
     */
    public static class Builder {
        private Article article;
        
        public Builder() {
            article = new Article();
        }
        
        public Builder setTitle(String title) {
            article.title = title;
            return this;
        }
        
        public Builder setContent(String content) {
            article.content = content;
            return this;
        }
        
        public Builder setAuthor(String author) {
            article.author = author;
            return this;
        }
        
        public Builder setCategory(String category) {
            article.category = category;
            return this;
        }
        
        public Builder addTag(String tag) {
            article.tags.add(tag);
            return this;
        }
        
        public Builder addImage(String image) {
            article.images.add(image);
            return this;
        }
        
        public Builder setPublished(boolean published) {
            article.published = published;
            return this;
        }
        
        public Builder setCommentsEnabled(boolean enabled) {
            article.commentsEnabled = enabled;
            return this;
        }
        
        public Article build() {
            return article;
        }
    }
}
