package com.blog.patterns.forms;

import com.blog.patterns.behavioral.*;
import com.blog.patterns.creational.*;
import com.blog.patterns.models.BlogPost;
import com.blog.patterns.structural.*;

/**
 * Controller for Single Record Entry Form
 * Demonstrates all 12 Design Patterns for saving ONE blog post
 */
public class SingleRecordController {
    
    // Singleton - Global configuration
    private BlogConfiguration config;
    
    // Prototype - Template registry
    private PostPrototypeRegistry prototypeRegistry;
    
    // Observer - Publisher for notifications
    private BlogPublisher publisher;
    
    // Facade - Simplified publishing
    private BlogManagementFacade facade;
    
    public SingleRecordController() {
        this.config = BlogConfiguration.getInstance();  // Singleton
        this.prototypeRegistry = new PostPrototypeRegistry();  // Prototype
        this.publisher = new BlogPublisher();  // Observer
        this.facade = new BlogManagementFacade();  // Facade
    }
    
    /**
     * Save single blog post record using ALL 12 Design Patterns
     */
    public String saveSingleRecord(SingleRecordData data) {
        System.out.println("\n========================================");
        System.out.println("SAVING SINGLE BLOG POST RECORD");
        System.out.println("Using All 12 Design Patterns");
        System.out.println("========================================\n");
        
        // 1. SINGLETON PATTERN - Access global config
        System.out.println("1. [Singleton] Accessing global configuration...");
        String blogName = config.getSetting("blogName");
        System.out.println("   Blog: " + blogName);
        
        // 2. FACTORY METHOD PATTERN - Create post by type
        System.out.println("\n2. [Factory Method] Creating " + data.getPostType() + " post...");
        PostFactory factory = createFactory(data.getPostType());
        
        // 3. BUILDER PATTERN - Build the post
        System.out.println("\n3. [Builder] Building blog post...");
        BlogPost post = new BlogPostBuilder()
            .setTitle(data.getTitle())
            .setAuthor(data.getAuthor())
            .setContent(data.getContent())
            .setCategory(data.getPostType())
            .build();
        
        // Add tags
        for (String tag : data.getTags()) {
            post.addTag(tag);
        }
        System.out.println("   Built: " + post.getTitle() + " with " + data.getTags().size() + " tags");
        
        // 4. PROTOTYPE PATTERN - Available for cloning
        System.out.println("\n4. [Prototype] Template registry available for future cloning");
        
        // 5. ABSTRACT FACTORY PATTERN - UI components
        System.out.println("\n5. [Abstract Factory] Creating UI components for " + data.getTheme() + " theme");
        UIComponentFactory uiFactory = createUIFactory(data.getTheme());
        Button btn = uiFactory.createButton();
        btn.render();
        
        // 6. ADAPTER PATTERN - Content format conversion
        System.out.println("\n6. [Adapter] Converting content format: " + data.getContentFormat());
        String convertedContent = adaptContent(data.getContent(), data.getContentFormat());
        post.setContent(convertedContent);
        
        // 7. DECORATOR PATTERN - Add features
        System.out.println("\n7. [Decorator] Adding features...");
        BlogPostComponent postComponent = new BasicBlogPost(post);
        if (data.isEnableComments()) {
            postComponent = new CommentDecorator(postComponent, 0);
            System.out.println("   + Comments enabled");
        }
        if (data.isEnableLikes()) {
            postComponent = new LikeDecorator(postComponent, 0);
            System.out.println("   + Likes enabled");
        }
        
        // 8. PROXY PATTERN - Lazy loading
        System.out.println("\n8. [Proxy] Setting up content loading...");
        if (data.isLazyLoad()) {
            System.out.println("   Lazy loading enabled (Proxy)");
        } else {
            System.out.println("   Eager loading (Direct)");
        }
        
        // 9. OBSERVER PATTERN - Notifications
        System.out.println("\n9. [Observer] Setting up notifications...");
        if (data.isNotifyEmail()) {
            publisher.subscribe(new EmailSubscriber("subscribers@blog.com"));
            System.out.println("   + Email subscribers");
        }
        if (data.isNotifySMS()) {
            publisher.subscribe(new SMSSubscriber("+1234567890"));
            System.out.println("   + SMS subscribers");
        }
        
        // 10. STRATEGY PATTERN - Rendering strategy
        System.out.println("\n10. [Strategy] Rendering strategy: " + data.getContentFormat());
        com.blog.patterns.behavioral.ContentRenderer renderer = 
            new com.blog.patterns.behavioral.ContentRenderer();
        renderer.setStrategy(createRenderingStrategy(data.getContentFormat()));
        
        // 11. TEMPLATE METHOD PATTERN - Publishing workflow
        System.out.println("\n11. [Template Method] Executing publishing workflow...");
        PostPublishingTemplate template = createPublishingTemplate(data.getPostType());
        template.publishPost(post);
        
        // 12. FACADE PATTERN - Simplified publishing
        System.out.println("\n12. [Facade] Final publishing via facade...");
        facade.publishPost(post);
        
        // Notify observers
        publisher.publishPost(post);
        
        System.out.println("\n========================================");
        System.out.println("✅ SINGLE RECORD SAVED SUCCESSFULLY!");
        System.out.println("Record ID: " + post.getId());
        System.out.println("All 12 patterns applied!");
        System.out.println("========================================\n");
        
        return post.getId();
    }
    
    // Helper methods
    
    private PostFactory createFactory(String type) {
        switch (type.toLowerCase()) {
            case "technical": return new TechnicalPostFactory();
            case "lifestyle": return new LifestylePostFactory();
            default: return new TechnicalPostFactory();
        }
    }
    
    private UIComponentFactory createUIFactory(String theme) {
        return "modern".equalsIgnoreCase(theme) ? 
            new ModernUIFactory() : new ClassicUIFactory();
    }
    
    private String adaptContent(String content, String format) {
        if ("markdown".equalsIgnoreCase(format)) {
            com.blog.patterns.structural.ContentRenderer adapter = new MarkdownAdapter();
            return adapter.render(content);
        }
        return content;
    }
    
    private RenderingStrategy createRenderingStrategy(String format) {
        switch (format.toLowerCase()) {
            case "html": return new HTMLRenderingStrategy();
            case "json": return new JSONRenderingStrategy();
            default: return new PlainTextStrategy();
        }
    }
    
    private PostPublishingTemplate createPublishingTemplate(String postType) {
        return "technical".equalsIgnoreCase(postType) ? 
            new TechnicalPostPublisher() : new NewsPostPublisher();
    }
}

/**
 * Data Transfer Object for Single Record
 */
class SingleRecordData {
    private String title;
    private String author;
    private String postType;
    private String contentFormat;
    private String content;
    private java.util.List<String> tags = new java.util.ArrayList<>();
    private String theme;
    private boolean enableComments;
    private boolean enableLikes;
    private boolean lazyLoad;
    private boolean notifyEmail;
    private boolean notifySMS;
    
    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getPostType() { return postType; }
    public void setPostType(String postType) { this.postType = postType; }
    
    public String getContentFormat() { return contentFormat; }
    public void setContentFormat(String contentFormat) { this.contentFormat = contentFormat; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public java.util.List<String> getTags() { return tags; }
    public void setTags(java.util.List<String> tags) { this.tags = tags; }
    
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
    
    public boolean isEnableComments() { return enableComments; }
    public void setEnableComments(boolean enableComments) { this.enableComments = enableComments; }
    
    public boolean isEnableLikes() { return enableLikes; }
    public void setEnableLikes(boolean enableLikes) { this.enableLikes = enableLikes; }
    
    public boolean isLazyLoad() { return lazyLoad; }
    public void setLazyLoad(boolean lazyLoad) { this.lazyLoad = lazyLoad; }
    
    public boolean isNotifyEmail() { return notifyEmail; }
    public void setNotifyEmail(boolean notifyEmail) { this.notifyEmail = notifyEmail; }
    
    public boolean isNotifySMS() { return notifySMS; }
    public void setNotifySMS(boolean notifySMS) { this.notifySMS = notifySMS; }
}
