package com.blog.patterns.pattern08_facade;

import com.blog.patterns.shared.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Facade Pattern - BlogManagementFacade
 * Provides a simplified interface to the complex blog management subsystem
 */
public class BlogManagementFacade {
    private PostValidator validator;
    private PostStorage storage;
    private NotificationService notificationService;
    private SearchIndexer searchIndexer;
    
    public BlogManagementFacade() {
        this.validator = new PostValidator();
        this.storage = new PostStorage();
        this.notificationService = new NotificationService();
        this.searchIndexer = new SearchIndexer();
    }
    
    public void publishPost(BlogPost post) {
        System.out.println("\n=== Publishing Post via Facade ===");
        
        // Validate
        if (validator.validate(post)) {
            // Store
            storage.save(post);
            
            // Index for search
            searchIndexer.index(post);
            
            // Notify subscribers
            notificationService.notifySubscribers(post);
            
            System.out.println("Post published successfully: " + post.getTitle());
        } else {
            System.out.println("Post validation failed!");
        }
    }
    
    // Subsystem classes
    private class PostValidator {
        public boolean validate(BlogPost post) {
            System.out.println("[Validator] Validating post...");
            return post.getTitle() != null && post.getContent() != null;
        }
    }
    
    private class PostStorage {
        private List<BlogPost> posts = new ArrayList<>();
        
        public void save(BlogPost post) {
            posts.add(post);
            System.out.println("[Storage] Post saved to database");
        }
    }
    
    private class NotificationService {
        public void notifySubscribers(BlogPost post) {
            System.out.println("[Notification] Notifying subscribers about new post");
        }
    }
    
    private class SearchIndexer {
        public void index(BlogPost post) {
            System.out.println("[Search Indexer] Post indexed for search");
        }
    }
}
