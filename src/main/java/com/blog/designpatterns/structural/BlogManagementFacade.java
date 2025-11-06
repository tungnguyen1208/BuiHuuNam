package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;
import com.blog.model.Comment;
import com.blog.model.User;
import java.util.List;
import java.util.ArrayList;

/**
 * Facade Pattern - BlogManagementFacade
 * Provides a simplified interface to complex blog subsystems
 */
public class BlogManagementFacade {
    private PostManager postManager;
    private CommentManager commentManager;
    private UserManager userManager;
    private NotificationService notificationService;
    private SearchService searchService;
    
    public BlogManagementFacade() {
        this.postManager = new PostManager();
        this.commentManager = new CommentManager();
        this.userManager = new UserManager();
        this.notificationService = new NotificationService();
        this.searchService = new SearchService();
    }
    
    /**
     * Simplified method to publish a blog post with all necessary steps
     */
    public void publishBlogPost(BlogPost post, User author) {
        System.out.println("Publishing blog post...");
        
        // Validate author
        if (!userManager.validateUser(author)) {
            System.out.println("Invalid user. Cannot publish post.");
            return;
        }
        
        // Save the post
        postManager.savePost(post);
        
        // Index for search
        searchService.indexPost(post);
        
        // Notify subscribers
        notificationService.notifySubscribers(post);
        
        System.out.println("Blog post published successfully!");
    }
    
    /**
     * Simplified method to add a comment with validation
     */
    public void addComment(String postId, Comment comment, User user) {
        System.out.println("Adding comment...");
        
        // Validate user
        if (!userManager.validateUser(user)) {
            System.out.println("Invalid user. Cannot add comment.");
            return;
        }
        
        // Get the post
        BlogPost post = postManager.getPost(postId);
        if (post == null) {
            System.out.println("Post not found.");
            return;
        }
        
        // Add comment
        commentManager.addComment(postId, comment);
        
        // Notify post author
        notificationService.notifyAuthor(post, comment);
        
        System.out.println("Comment added successfully!");
    }
    
    /**
     * Simplified method to search and display posts
     */
    public List<BlogPost> searchPosts(String query) {
        System.out.println("Searching for: " + query);
        List<BlogPost> results = searchService.search(query);
        System.out.println("Found " + results.size() + " results.");
        return results;
    }
}

/**
 * Post management subsystem
 */
class PostManager {
    private List<BlogPost> posts = new ArrayList<>();
    
    public void savePost(BlogPost post) {
        posts.add(post);
        System.out.println("Post saved to database.");
    }
    
    public BlogPost getPost(String id) {
        for (BlogPost post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }
    
    public List<BlogPost> getAllPosts() {
        return new ArrayList<>(posts);
    }
}

/**
 * Comment management subsystem
 */
class CommentManager {
    public void addComment(String postId, Comment comment) {
        System.out.println("Comment added to post: " + postId);
    }
    
    public List<Comment> getComments(String postId) {
        return new ArrayList<>();
    }
}

/**
 * User management subsystem
 */
class UserManager {
    public boolean validateUser(User user) {
        return user != null && user.getUsername() != null;
    }
    
    public User getUser(String userId) {
        return new User();
    }
}

/**
 * Notification subsystem
 */
class NotificationService {
    public void notifySubscribers(BlogPost post) {
        System.out.println("Notifying subscribers about new post: " + post.getTitle());
    }
    
    public void notifyAuthor(BlogPost post, Comment comment) {
        System.out.println("Notifying author about new comment on: " + post.getTitle());
    }
}

/**
 * Search subsystem
 */
class SearchService {
    private List<BlogPost> indexedPosts = new ArrayList<>();
    
    public void indexPost(BlogPost post) {
        indexedPosts.add(post);
        System.out.println("Post indexed for search: " + post.getTitle());
    }
    
    public List<BlogPost> search(String query) {
        List<BlogPost> results = new ArrayList<>();
        for (BlogPost post : indexedPosts) {
            if (post.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                post.getContent().toLowerCase().contains(query.toLowerCase())) {
                results.add(post);
            }
        }
        return results;
    }
}
