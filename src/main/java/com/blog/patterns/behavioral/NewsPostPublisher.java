package com.blog.patterns.behavioral;

import com.blog.patterns.models.BlogPost;

/**
 * Concrete implementation for news posts
 */
public class NewsPostPublisher extends PostPublishingTemplate {
    
    @Override
    protected void formatContent(BlogPost post) {
        System.out.println("[News] Formatting with breaking news style");
    }
    
    @Override
    protected void notifyUsers(BlogPost post) {
        System.out.println("[News] Sending push notifications to all users");
    }
}
