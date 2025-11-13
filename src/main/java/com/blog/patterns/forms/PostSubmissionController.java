package com.blog.patterns.forms;

import com.blog.patterns.behavioral.*;
import com.blog.patterns.creational.*;
import com.blog.patterns.models.BlogPost;
import com.blog.patterns.structural.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for Post Submission Form
 * Demonstrates all 12 Design Patterns working together
 */
public class PostSubmissionController {
    
    // Singleton - Global configuration
    private BlogConfiguration config;
    
    // Factory Method - Create posts by type
    private PostFactory postFactory;
    
    // Abstract Factory - UI components
    private UIComponentFactory uiFactory;
    
    // Prototype - Template registry
    private PostPrototypeRegistry prototypeRegistry;
    
    // Observer - Publisher for notifications
    private BlogPublisher publisher;
    
    // Facade - Simplified publishing
    private BlogManagementFacade managementFacade;
    
    public PostSubmissionController() {
        // Initialize patterns
        this.config = BlogConfiguration.getInstance();  // Singleton
        this.prototypeRegistry = new PostPrototypeRegistry();  // Prototype
        this.publisher = new BlogPublisher();  // Observer
        this.managementFacade = new BlogManagementFacade();  // Facade
    }
    
    /**
     * Process form submission - Uses ALL 12 Design Patterns
     */
    public void processFormSubmission(PostSubmissionFormData formData) {
        System.out.println("\n========================================");
        System.out.println("PROCESSING POST SUBMISSION FORM");
        System.out.println("Demonstrating All 12 Design Patterns");
        System.out.println("========================================\n");
        
        // 1. SINGLETON PATTERN
        // Access global configuration
        System.out.println("1. [Singleton] Loading global configuration...");
        String blogName = config.getSetting("blogName");
        System.out.println("   Blog Name: " + blogName);
        
        // 2. FACTORY METHOD PATTERN
        // Create post based on type
        System.out.println("\n2. [Factory Method] Creating post by type: " + formData.getPostType());
        postFactory = createFactoryByType(formData.getPostType());
        
        // 3. BUILDER PATTERN
        // Build the blog post step by step
        System.out.println("\n3. [Builder] Building blog post...");
        BlogPost post = new BlogPostBuilder()
            .setTitle(formData.getTitle())
            .setAuthor(formData.getAuthor())
            .setContent(formData.getContent())
            .setCategory(formData.getPostType())
            .build();
        
        // Add tags from form
        for (String tag : formData.getTags()) {
            post.addTag(tag);
        }
        System.out.println("   Post built: " + post.getTitle());
        
        // 4. PROTOTYPE PATTERN (if loading from template)
        if (formData.isLoadFromTemplate()) {
            System.out.println("\n4. [Prototype] Cloning from template...");
            BlogPost templatePost = prototypeRegistry.createPost(
                formData.getPostType(),
                formData.getTitle(),
                formData.getContent(),
                formData.getAuthor()
            );
            post = templatePost;
        }
        
        // 5. ABSTRACT FACTORY PATTERN
        // Create UI components based on theme
        System.out.println("\n5. [Abstract Factory] Creating UI components for theme: " + formData.getTheme());
        uiFactory = createUIFactory(formData.getTheme());
        Button button = uiFactory.createButton();
        Header header = uiFactory.createHeader();
        Footer footer = uiFactory.createFooter();
        System.out.println("   Components created:");
        System.out.print("   ");
        button.render();
        System.out.print("   ");
        header.render();
        System.out.print("   ");
        footer.render();
        
        // 6. ADAPTER PATTERN
        // Convert content format if needed
        System.out.println("\n6. [Adapter] Converting content format: " + formData.getContentFormat());
        String convertedContent = adaptContent(formData.getContent(), formData.getContentFormat());
        post.setContent(convertedContent);
        
        // 7. DECORATOR PATTERN
        // Add features dynamically
        System.out.println("\n7. [Decorator] Adding features to post...");
        BlogPostComponent postComponent = new BasicBlogPost(post);
        
        if (formData.isEnableComments()) {
            postComponent = new CommentDecorator(postComponent, 0);
            System.out.println("   + Comments enabled");
        }
        
        if (formData.isEnableLikes()) {
            postComponent = new LikeDecorator(postComponent, 0);
            System.out.println("   + Likes enabled");
        }
        
        // 8. PROXY PATTERN
        // Setup lazy loading if enabled
        System.out.println("\n8. [Proxy] Setting up content loading strategy...");
        PostContent contentProxy;
        if (formData.isLazyLoad()) {
            contentProxy = new PostContentProxy(post.getId());
            System.out.println("   Lazy loading enabled - content will load on demand");
        } else {
            contentProxy = new RealPostContent(post.getId());
            System.out.println("   Eager loading - content loaded immediately");
        }
        
        // 9. OBSERVER PATTERN
        // Setup notifications
        System.out.println("\n9. [Observer] Setting up notification subscribers...");
        if (formData.isNotifyEmail()) {
            publisher.subscribe(new EmailSubscriber("subscribers@blog.com"));
            System.out.println("   + Email subscribers added");
        }
        
        if (formData.isNotifySMS()) {
            publisher.subscribe(new SMSSubscriber("+1234567890"));
            System.out.println("   + SMS subscribers added");
        }
        
        // 10. STRATEGY PATTERN
        // Setup rendering strategy
        System.out.println("\n10. [Strategy] Setting up rendering strategy...");
        com.blog.patterns.behavioral.ContentRenderer renderer = 
            new com.blog.patterns.behavioral.ContentRenderer();
        
        RenderingStrategy strategy = createRenderingStrategy(formData.getContentFormat());
        renderer.setStrategy(strategy);
        System.out.println("   Strategy set: " + formData.getContentFormat());
        
        // 11. TEMPLATE METHOD PATTERN
        // Use template method for publishing workflow
        System.out.println("\n11. [Template Method] Executing publishing workflow...");
        PostPublishingTemplate publishingTemplate = createPublishingTemplate(formData.getPostType());
        publishingTemplate.publishPost(post);
        
        // 12. FACADE PATTERN
        // Use facade to simplify the complex publishing process
        System.out.println("\n12. [Facade] Using facade for final publishing...");
        managementFacade.publishPost(post);
        
        // Notify all observers
        publisher.publishPost(post);
        
        System.out.println("\n========================================");
        System.out.println("✅ ALL 12 PATTERNS SUCCESSFULLY APPLIED!");
        System.out.println("Post '" + post.getTitle() + "' published successfully");
        System.out.println("========================================\n");
    }
    
    // Helper methods for pattern instantiation
    
    private PostFactory createFactoryByType(String type) {
        switch (type.toLowerCase()) {
            case "technical":
                return new TechnicalPostFactory();
            case "lifestyle":
                return new LifestylePostFactory();
            default:
                return new TechnicalPostFactory();
        }
    }
    
    private UIComponentFactory createUIFactory(String theme) {
        if ("modern".equalsIgnoreCase(theme)) {
            return new ModernUIFactory();
        } else {
            return new ClassicUIFactory();
        }
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
            case "html":
                return new HTMLRenderingStrategy();
            case "json":
                return new JSONRenderingStrategy();
            case "plain":
            default:
                return new PlainTextStrategy();
        }
    }
    
    private PostPublishingTemplate createPublishingTemplate(String postType) {
        if ("technical".equalsIgnoreCase(postType)) {
            return new TechnicalPostPublisher();
        } else {
            return new NewsPostPublisher();
        }
    }
}

/**
 * Form Data Transfer Object
 */
class PostSubmissionFormData {
    private String title;
    private String author;
    private String postType;
    private String contentFormat;
    private String content;
    private List<String> tags = new ArrayList<>();
    private String theme;
    private boolean enableComments;
    private boolean enableLikes;
    private boolean lazyLoad;
    private boolean notifyEmail;
    private boolean notifySMS;
    private boolean loadFromTemplate;
    
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
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public void addTag(String tag) { this.tags.add(tag); }
    
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
    
    public boolean isLoadFromTemplate() { return loadFromTemplate; }
    public void setLoadFromTemplate(boolean loadFromTemplate) { this.loadFromTemplate = loadFromTemplate; }
}
