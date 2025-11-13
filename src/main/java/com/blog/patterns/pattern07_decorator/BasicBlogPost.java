package com.blog.patterns.pattern07_decorator;

import com.blog.patterns.shared.*;

/**
 * Concrete Component - Basic Blog Post
 */
public class BasicBlogPost implements BlogPostComponent {
    private BlogPost post;
    
    public BasicBlogPost(BlogPost post) {
        this.post = post;
    }
    
    @Override
    public void display() {
        System.out.println("Title: " + post.getTitle());
        System.out.println("Author: " + post.getAuthor());
        System.out.println("Content: " + post.getContent());
    }
    
    @Override
    public String getDescription() {
        return "Basic Blog Post";
    }
}
