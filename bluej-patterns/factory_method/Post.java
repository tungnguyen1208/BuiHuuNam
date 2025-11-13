package factory_method;

/**
 * Abstract Product - Bài viết blog
 */
public abstract class Post {
    protected String title;
    protected String content;
    protected String author;
    protected String category;
    
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    // Template method
    public abstract String getPostType();
    public abstract void formatContent();
    public abstract String getCategoryIcon();
    
    public void publish() {
        System.out.println("\n=== Publishing " + getPostType() + " ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category + " " + getCategoryIcon());
        formatContent();
        System.out.println("Content: " + content);
    }
    
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
