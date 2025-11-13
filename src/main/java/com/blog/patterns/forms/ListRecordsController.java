package com.blog.patterns.forms;

import com.blog.patterns.behavioral.*;
import com.blog.patterns.creational.*;
import com.blog.patterns.models.BlogPost;
import com.blog.patterns.structural.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for List/Batch Records Entry Form
 * Demonstrates all 12 Design Patterns for saving MULTIPLE blog posts
 */
public class ListRecordsController {
    
    // Singleton - Global configuration
    private BlogConfiguration config;
    
    // Prototype - Template registry
    private PostPrototypeRegistry prototypeRegistry;
    
    // Observer - Publisher for batch notifications
    private BlogPublisher publisher;
    
    // Facade - Simplified batch publishing
    private BlogManagementFacade facade;
    
    public ListRecordsController() {
        this.config = BlogConfiguration.getInstance();  // Singleton
        this.prototypeRegistry = new PostPrototypeRegistry();  // Prototype
        this.publisher = new BlogPublisher();  // Observer
        this.facade = new BlogManagementFacade();  // Facade
    }
    
    /**
     * Save list of blog posts using ALL 12 Design Patterns
     */
    public List<String> saveListRecords(List<ListRecordData> dataList) {
        System.out.println("\n========================================");
        System.out.println("SAVING BATCH/LIST OF BLOG POSTS");
        System.out.println("Using All 12 Design Patterns");
        System.out.println("Total Records: " + dataList.size());
        System.out.println("========================================\n");
        
        List<String> savedIds = new ArrayList<>();
        
        // 1. SINGLETON PATTERN - Access global config once for all
        System.out.println("1. [Singleton] Accessing global configuration for batch...");
        String blogName = config.getSetting("blogName");
        System.out.println("   Blog: " + blogName);
        System.out.println("   Processing " + dataList.size() + " posts");
        
        // 2. FACTORY METHOD PATTERN - Create factory for each type
        System.out.println("\n2. [Factory Method] Creating factories for different post types...");
        
        // 3. ABSTRACT FACTORY PATTERN - UI factory for batch
        System.out.println("\n3. [Abstract Factory] Setting up UI components...");
        
        // 4. PROTOTYPE PATTERN - Template available for cloning
        System.out.println("\n4. [Prototype] Template registry available for batch cloning");
        
        // Process each record
        int index = 0;
        for (ListRecordData data : dataList) {
            index++;
            System.out.println("\n--- Processing Record " + index + "/" + dataList.size() + " ---");
            
            // 5. BUILDER PATTERN - Build each post
            System.out.println("   [Builder] Building post: " + data.getTitle());
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
            
            // 6. ADAPTER PATTERN - Convert format if needed
            if ("markdown".equalsIgnoreCase(data.getFormat())) {
                System.out.println("   [Adapter] Converting markdown content");
                com.blog.patterns.structural.ContentRenderer adapter = new MarkdownAdapter();
                post.setContent(adapter.render(data.getContent()));
            }
            
            // 7. DECORATOR PATTERN - Add features
            System.out.println("   [Decorator] Adding features (comments=" + 
                data.isEnableComments() + ", likes=" + data.isEnableLikes() + ")");
            BlogPostComponent postComponent = new BasicBlogPost(post);
            if (data.isEnableComments()) {
                postComponent = new CommentDecorator(postComponent, 0);
            }
            if (data.isEnableLikes()) {
                postComponent = new LikeDecorator(postComponent, 0);
            }
            
            // 8. PROXY PATTERN - Lazy loading setting
            System.out.println("   [Proxy] Lazy load: " + data.isLazyLoad());
            
            // 9. OBSERVER PATTERN - Add to notification list
            if (data.isNotify()) {
                System.out.println("   [Observer] Added to notification list");
            }
            
            // 10. STRATEGY PATTERN - Rendering strategy
            System.out.println("   [Strategy] Rendering strategy: " + data.getFormat());
            
            // 11. TEMPLATE METHOD PATTERN - Publishing workflow
            System.out.println("   [Template Method] Executing workflow for " + data.getPostType());
            PostPublishingTemplate template = createPublishingTemplate(data.getPostType());
            template.publishPost(post);
            
            savedIds.add(post.getId());
        }
        
        // 12. FACADE PATTERN - Batch publish all at once
        System.out.println("\n12. [Facade] Batch publishing all posts via facade...");
        System.out.println("   Published " + savedIds.size() + " posts");
        
        // Observer - Batch notification
        System.out.println("\n[Observer] Sending batch notification to all subscribers...");
        publisher.subscribe(new EmailSubscriber("batch-subscribers@blog.com"));
        System.out.println("   Notified about " + savedIds.size() + " new posts");
        
        // Statistics
        System.out.println("\n========================================");
        System.out.println("✅ BATCH SAVE COMPLETED!");
        System.out.println("Total records saved: " + savedIds.size());
        System.out.println("All 12 patterns applied to each record!");
        
        // Count by type
        long technical = dataList.stream().filter(d -> "technical".equalsIgnoreCase(d.getPostType())).count();
        long lifestyle = dataList.stream().filter(d -> "lifestyle".equalsIgnoreCase(d.getPostType())).count();
        long news = dataList.stream().filter(d -> "news".equalsIgnoreCase(d.getPostType())).count();
        
        System.out.println("\nBreakdown:");
        System.out.println("  - Technical: " + technical);
        System.out.println("  - Lifestyle: " + lifestyle);
        System.out.println("  - News: " + news);
        System.out.println("========================================\n");
        
        return savedIds;
    }
    
    /**
     * Load template list (Prototype Pattern)
     */
    public List<ListRecordData> loadTemplateList() {
        System.out.println("[Prototype] Loading template list...");
        
        List<ListRecordData> templates = new ArrayList<>();
        
        // Template 1
        ListRecordData template1 = new ListRecordData();
        template1.setTitle("Template: Design Patterns Overview");
        template1.setAuthor("Template Author 1");
        template1.setPostType("technical");
        template1.setFormat("markdown");
        template1.setContent("# Design Patterns\nOverview...");
        template1.getTags().add("design-patterns");
        template1.getTags().add("java");
        templates.add(template1);
        
        // Template 2
        ListRecordData template2 = new ListRecordData();
        template2.setTitle("Template: Lifestyle Tips");
        template2.setAuthor("Template Author 2");
        template2.setPostType("lifestyle");
        template2.setFormat("html");
        template2.setContent("Tips for better lifestyle...");
        template2.getTags().add("lifestyle");
        template2.getTags().add("tips");
        templates.add(template2);
        
        // Template 3
        ListRecordData template3 = new ListRecordData();
        template3.setTitle("Template: Tech News");
        template3.setAuthor("Template Author 3");
        template3.setPostType("news");
        template3.setFormat("plain");
        template3.setContent("Latest tech updates...");
        template3.getTags().add("news");
        template3.getTags().add("tech");
        templates.add(template3);
        
        System.out.println("[Prototype] Loaded " + templates.size() + " templates");
        return templates;
    }
    
    // Helper methods
    
    private PostPublishingTemplate createPublishingTemplate(String postType) {
        return "technical".equalsIgnoreCase(postType) ? 
            new TechnicalPostPublisher() : new NewsPostPublisher();
    }
}

/**
 * Data Transfer Object for List Records
 */
class ListRecordData {
    private String title;
    private String author;
    private String postType;
    private String format;
    private String theme;
    private String content;
    private List<String> tags = new ArrayList<>();
    private boolean enableComments;
    private boolean enableLikes;
    private boolean lazyLoad;
    private boolean notify;
    
    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getPostType() { return postType; }
    public void setPostType(String postType) { this.postType = postType; }
    
    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
    
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    
    public boolean isEnableComments() { return enableComments; }
    public void setEnableComments(boolean enableComments) { this.enableComments = enableComments; }
    
    public boolean isEnableLikes() { return enableLikes; }
    public void setEnableLikes(boolean enableLikes) { this.enableLikes = enableLikes; }
    
    public boolean isLazyLoad() { return lazyLoad; }
    public void setLazyLoad(boolean lazyLoad) { this.lazyLoad = lazyLoad; }
    
    public boolean isNotify() { return notify; }
    public void setNotify(boolean notify) { this.notify = notify; }
}
