package com.blog.designpatterns.creational;

import com.blog.model.BlogPost;
import java.util.Date;

/**
 * Factory Method Pattern - BlogPostFactory
 * Creates different types of blog posts
 */
public abstract class BlogPostFactory {
    
    public abstract BlogPost createPost(String title, String content, String author);
    
    public BlogPost createAndPublish(String title, String content, String author) {
        BlogPost post = createPost(title, content, author);
        post.setPublishDate(new Date());
        System.out.println("Publishing post: " + post.getTitle());
        return post;
    }
}

