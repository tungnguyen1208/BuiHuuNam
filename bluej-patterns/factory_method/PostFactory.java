package factory_method;

/**
 * Abstract Creator - Factory Method Pattern
 */
public abstract class PostFactory {
    
    // Factory Method - subclass quyết định tạo loại Post nào
    public abstract Post createPost(String title, String content, String author);
    
    // Template method sử dụng Factory Method
    public Post createAndPublish(String title, String content, String author) {
        Post post = createPost(title, content, author);
        post.publish();
        return post;
    }
}
