package factory_method;

/**
 * Concrete Product - Bài viết lối sống
 */
public class LifestylePost extends Post {
    private String[] images;
    private String mood;
    
    public LifestylePost(String title, String content, String author) {
        super(title, content, author);
        this.category = "Lifestyle";
        this.images = new String[]{"image1.jpg", "image2.jpg"};
        this.mood = "Inspirational";
    }
    
    @Override
    public String getPostType() {
        return "Lifestyle Post";
    }
    
    @Override
    public void formatContent() {
        System.out.println("Mood: " + mood);
        System.out.print("Images: ");
        for (String image : images) {
            System.out.print(image + " ");
        }
        System.out.println();
        System.out.println("Format: Visual-rich with personal stories");
    }
    
    @Override
    public String getCategoryIcon() {
        return "🌟";
    }
    
    public void setImages(String[] images) {
        this.images = images;
    }
    
    public void setMood(String mood) {
        this.mood = mood;
    }
}
