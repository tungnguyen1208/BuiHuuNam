package com.blog.patterns.pattern12_template_method;

import com.blog.patterns.shared.*;

/**
 * Template Method Pattern - Post Publishing Workflow
 * Defines the skeleton of a publishing algorithm
 */
public abstract class PostPublishingTemplate {
    
    // Template method
    public final void publishPost(BlogPost post) {
        System.out.println("\n=== Starting Post Publishing Workflow ===");
        
        validatePost(post);
        formatContent(post);
        saveToDatabase(post);
        notifyUsers(post);
        
        // Hook method - optional step
        if (shouldAddToFeatured(post)) {
            addToFeaturedSection(post);
        }
        
        System.out.println("=== Post Publishing Complete ===\n");
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void formatContent(BlogPost post);
    protected abstract void notifyUsers(BlogPost post);
    
    // Concrete methods - same for all subclasses
    private void validatePost(BlogPost post) {
        System.out.println("[Template] Validating post: " + post.getTitle());
    }
    
    private void saveToDatabase(BlogPost post) {
        System.out.println("[Template] Saving post to database");
    }
    
    // Hook method - can be overridden
    protected boolean shouldAddToFeatured(BlogPost post) {
        return false;
    }
    
    protected void addToFeaturedSection(BlogPost post) {
        System.out.println("[Template] Adding to featured section");
    }
}
