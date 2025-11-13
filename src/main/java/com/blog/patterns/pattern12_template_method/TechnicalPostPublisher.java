package com.blog.patterns.pattern12_template_method;

import com.blog.patterns.shared.*;

/**
 * Concrete implementation for technical posts
 */
public class TechnicalPostPublisher extends PostPublishingTemplate {
    
    @Override
    protected void formatContent(BlogPost post) {
        System.out.println("[Technical] Formatting with code syntax highlighting");
    }
    
    @Override
    protected void notifyUsers(BlogPost post) {
        System.out.println("[Technical] Notifying developer subscribers");
    }
    
    @Override
    protected boolean shouldAddToFeatured(BlogPost post) {
        // Technical posts with "tutorial" tag should be featured
        return post.getTags().contains("tutorial");
    }
}
