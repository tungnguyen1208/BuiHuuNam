package com.blog.patterns.pattern12_template_method;

import com.blog.patterns.shared.*;

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
