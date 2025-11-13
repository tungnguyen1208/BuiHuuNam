package factory_method;

/**
 * Concrete Creator - Tạo Lifestyle Post
 */
public class LifestylePostFactory extends PostFactory {
    
    @Override
    public Post createPost(String title, String content, String author) {
        return new LifestylePost(title, content, author);
    }
}
