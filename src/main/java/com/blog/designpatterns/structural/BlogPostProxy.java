package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;
import com.blog.model.User;

/**
 * Proxy Pattern - BlogPostProxy
 * Controls access to blog posts with caching and access control
 */
interface BlogPostService {
    BlogPost getPost(String id);
    void updatePost(BlogPost post);
}

/**
 * Real subject - Actual blog post service
 */
class RealBlogPostService implements BlogPostService {
    @Override
    public BlogPost getPost(String id) {
        System.out.println("Fetching post from database: " + id);
        // Simulate database access
        try {
            Thread.sleep(100); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BlogPost post = new BlogPost();
        post.setId(id);
        post.setTitle("Real Post " + id);
        post.setContent("This is the actual content from database.");
        return post;
    }
    
    @Override
    public void updatePost(BlogPost post) {
        System.out.println("Updating post in database: " + post.getId());
    }
}

/**
 * Proxy with caching
 */
class CachingBlogPostProxy implements BlogPostService {
    private RealBlogPostService realService;
    private BlogPost cachedPost;
    private String cachedId;
    
    public CachingBlogPostProxy() {
        this.realService = new RealBlogPostService();
    }
    
    @Override
    public BlogPost getPost(String id) {
        if (cachedPost != null && id.equals(cachedId)) {
            System.out.println("Returning cached post: " + id);
            return cachedPost;
        }
        
        cachedPost = realService.getPost(id);
        cachedId = id;
        return cachedPost;
    }
    
    @Override
    public void updatePost(BlogPost post) {
        realService.updatePost(post);
        // Invalidate cache
        cachedPost = null;
        cachedId = null;
    }
}

/**
 * Proxy with access control
 */
class ProtectedBlogPostProxy implements BlogPostService {
    private RealBlogPostService realService;
    private User currentUser;
    
    public ProtectedBlogPostProxy(User currentUser) {
        this.realService = new RealBlogPostService();
        this.currentUser = currentUser;
    }
    
    @Override
    public BlogPost getPost(String id) {
        // Anyone can read
        return realService.getPost(id);
    }
    
    @Override
    public void updatePost(BlogPost post) {
        if (hasWriteAccess()) {
            realService.updatePost(post);
        } else {
            System.out.println("Access denied: User does not have write permission.");
        }
    }
    
    private boolean hasWriteAccess() {
        return currentUser != null && 
               ("admin".equals(currentUser.getRole()) || "editor".equals(currentUser.getRole()));
    }
}

/**
 * Proxy with logging
 */
class LoggingBlogPostProxy implements BlogPostService {
    private RealBlogPostService realService;
    
    public LoggingBlogPostProxy() {
        this.realService = new RealBlogPostService();
    }
    
    @Override
    public BlogPost getPost(String id) {
        System.out.println("LOG: Accessing post " + id + " at " + System.currentTimeMillis());
        BlogPost post = realService.getPost(id);
        System.out.println("LOG: Successfully retrieved post " + id);
        return post;
    }
    
    @Override
    public void updatePost(BlogPost post) {
        System.out.println("LOG: Updating post " + post.getId() + " at " + System.currentTimeMillis());
        realService.updatePost(post);
        System.out.println("LOG: Successfully updated post " + post.getId());
    }
}
