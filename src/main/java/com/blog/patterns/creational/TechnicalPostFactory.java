package com.blog.patterns.creational;

import com.blog.patterns.models.BlogPost;
import java.util.UUID;

/**
 * Concrete Factory for creating Technical Blog Posts
 */
public class TechnicalPostFactory extends PostFactory {
    
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(UUID.randomUUID().toString(), title, content, author);
        post.setCategory("Technical");
        post.addTag("programming");
        post.addTag("technology");
        return post;
    }
}
