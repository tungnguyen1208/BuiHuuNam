package factory_method;

/**
 * Concrete Product - Bài viết kỹ thuật
 */
public class TechnicalPost extends Post {
    private String programmingLanguage;
    private String[] tags;
    
    public TechnicalPost(String title, String content, String author) {
        super(title, content, author);
        this.category = "Technical";
        this.programmingLanguage = "Java";
        this.tags = new String[]{"tutorial", "code", "programming"};
    }
    
    @Override
    public String getPostType() {
        return "Technical Post";
    }
    
    @Override
    public void formatContent() {
        System.out.println("Language: " + programmingLanguage);
        System.out.print("Tags: ");
        for (String tag : tags) {
            System.out.print("#" + tag + " ");
        }
        System.out.println();
        System.out.println("Format: Code blocks with syntax highlighting");
    }
    
    @Override
    public String getCategoryIcon() {
        return "💻";
    }
    
    public void setProgrammingLanguage(String language) {
        this.programmingLanguage = language;
    }
    
    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
