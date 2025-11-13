package com.blog.patterns.pattern02_factory_method;

import com.blog.patterns.shared.*;

/**
 * Factory Method Pattern - PostFactory
 * Defines an interface for creating blog posts, letting subclasses decide which class to instantiate
 */
public abstract class PostFactory {
    
    public abstract BlogPost createPost(String title, String content, String author);
    
    public BlogPost publishPost(String title, String content, String author) {
        BlogPost post = createPost(title, content, author);
        System.out.println("Publishing post: " + post.getTitle() + " [" + post.getCategory() + "]");
        return post;
    }
}
