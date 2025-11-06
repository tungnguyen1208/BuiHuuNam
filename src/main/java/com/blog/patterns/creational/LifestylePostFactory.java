package com.blog.patterns.creational;

import com.blog.patterns.models.BlogPost;
import java.util.UUID;

/**
 * Concrete Factory for creating Lifestyle Blog Posts
 */
public class LifestylePostFactory extends PostFactory {
    
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(UUID.randomUUID().toString(), title, content, author);
        post.setCategory("Lifestyle");
        post.addTag("life");
        post.addTag("personal");
        return post;
    }
}
