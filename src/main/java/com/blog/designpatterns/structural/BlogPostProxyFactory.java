package com.blog.designpatterns.structural;

import com.blog.model.User;
import com.blog.model.BlogPost;

/**
 * Proxy Pattern - Factory for creating proxy instances
 */
public class BlogPostProxyFactory {
    
    public static void demonstrateCachingProxy(String postId) {
        BlogPostService proxy = new CachingBlogPostProxy();
        proxy.getPost(postId);
        proxy.getPost(postId); // Should be cached
    }
    
    public static void demonstrateProtectedProxy(User user, BlogPost post) {
        BlogPostService proxy = new ProtectedBlogPostProxy(user);
        proxy.updatePost(post);
    }
    
    public static void demonstrateLoggingProxy(String postId) {
        BlogPostService proxy = new LoggingBlogPostProxy();
        proxy.getPost(postId);
    }
}
