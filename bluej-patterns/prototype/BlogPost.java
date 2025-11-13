package prototype;

public class BlogPost implements Cloneable {
    private String title;
    private String content;
    private String author;
    private String template;
    
    public BlogPost(String template) {
        this.template = template;
        initializeByTemplate();
    }
    
    private void initializeByTemplate() {
        switch(template) {
            case "technical":
                this.title = "[Technical] ";
                this.content = "# Code Example\n\n```java\n\n```";
                this.author = "Tech Writer";
                break;
            case "news":
                this.title = "[News] ";
                this.content = "**Breaking:** ";
                this.author = "News Reporter";
                break;
            default:
                this.title = "";
                this.content = "";
                this.author = "Anonymous";
        }
    }
    
    @Override
    public BlogPost clone() {
        try {
            return (BlogPost) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void display() {
        System.out.println("\n--- Blog Post ---");
        System.out.println("Template: " + template);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
    }
    
    // Getters and Setters
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setAuthor(String author) { this.author = author; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
}
