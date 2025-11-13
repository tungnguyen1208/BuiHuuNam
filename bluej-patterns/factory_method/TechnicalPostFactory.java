package factory_method;

/**
 * Concrete Creator - Tạo Technical Post
 */
public class TechnicalPostFactory extends PostFactory {
    
    @Override
    public Post createPost(String title, String content, String author) {
        return new TechnicalPost(title, content, author);
    }
}
