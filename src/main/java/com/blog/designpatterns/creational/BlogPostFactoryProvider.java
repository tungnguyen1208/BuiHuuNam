package com.blog.designpatterns.creational;

import com.blog.model.BlogPost;

/**
 * Factory Method Pattern - Helper class to create factory instances
 */
public class BlogPostFactoryProvider {
    
    public static BlogPostFactory getTechnicalFactory() {
        return new TechnicalBlogPostFactory();
    }
    
    public static BlogPostFactory getTutorialFactory() {
        return new TutorialBlogPostFactory();
    }
    
    public static BlogPostFactory getNewsFactory() {
        return new NewsBlogPostFactory();
    }
}

/**
 * Factory for creating technical blog posts
 */
class TechnicalBlogPostFactory extends BlogPostFactory {
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(generateId(), title, content, author);
        post.addTag("Technical");
        post.addTag("Programming");
        return post;
    }
    
    private String generateId() {
        return "TECH-" + System.currentTimeMillis();
    }
}

/**
 * Factory for creating tutorial blog posts
 */
class TutorialBlogPostFactory extends BlogPostFactory {
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(generateId(), title, content, author);
        post.addTag("Tutorial");
        post.addTag("How-To");
        return post;
    }
    
    private String generateId() {
        return "TUT-" + System.currentTimeMillis();
    }
}

/**
 * Factory for creating news blog posts
 */
class NewsBlogPostFactory extends BlogPostFactory {
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(generateId(), title, content, author);
        post.addTag("News");
        post.addTag("Updates");
        return post;
    }
    
    private String generateId() {
        return "NEWS-" + System.currentTimeMillis();
    }
}
