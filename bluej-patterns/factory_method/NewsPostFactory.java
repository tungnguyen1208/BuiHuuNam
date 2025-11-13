package factory_method;

/**
 * Concrete Creator - Tạo News Post
 */
public class NewsPostFactory extends PostFactory {
    
    @Override
    public Post createPost(String title, String content, String author) {
        return new NewsPost(title, content, author);
    }
}
