package com.blog.patterns;

import com.blog.patterns.behavioral.*;
import com.blog.patterns.creational.*;
import com.blog.patterns.models.BlogPost;
import com.blog.patterns.structural.*;

/**
 * Main Demo Class - Demonstrates all 12 Design Patterns
 * For Blog Website Application
 */
public class DesignPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   BLOG WEBSITE - 12 DESIGN PATTERNS DEMO   ");
        System.out.println("==============================================\n");
        
        // 1. Singleton Pattern
        demonstrateSingleton();
        
        // 2. Factory Method Pattern
        demonstrateFactoryMethod();
        
        // 3. Abstract Factory Pattern
        demonstrateAbstractFactory();
        
        // 4. Builder Pattern
        demonstrateBuilder();
        
        // 5. Prototype Pattern
        demonstratePrototype();
        
        // 6. Adapter Pattern
        demonstrateAdapter();
        
        // 7. Decorator Pattern
        demonstrateDecorator();
        
        // 8. Facade Pattern
        demonstrateFacade();
        
        // 9. Proxy Pattern
        demonstrateProxy();
        
        // 10. Observer Pattern
        demonstrateObserver();
        
        // 11. Strategy Pattern
        demonstrateStrategy();
        
        // 12. Template Method Pattern
        demonstrateTemplateMethod();
        
        System.out.println("\n==============================================");
        System.out.println("       ALL PATTERNS DEMONSTRATED!            ");
        System.out.println("==============================================");
    }
    
    private static void demonstrateSingleton() {
        System.out.println("\n### 1. SINGLETON PATTERN ###");
        System.out.println("Purpose: Ensure only one instance of BlogConfiguration exists\n");
        
        BlogConfiguration config1 = BlogConfiguration.getInstance();
        config1.setSetting("blogName", "My Awesome Blog");
        
        BlogConfiguration config2 = BlogConfiguration.getInstance();
        config2.displaySettings();
        
        System.out.println("Are both instances same? " + (config1 == config2));
    }
    
    private static void demonstrateFactoryMethod() {
        System.out.println("\n\n### 2. FACTORY METHOD PATTERN ###");
        System.out.println("Purpose: Create different types of blog posts\n");
        
        PostFactory technicalFactory = new TechnicalPostFactory();
        BlogPost techPost = technicalFactory.publishPost(
            "Introduction to Java Design Patterns",
            "Design patterns are reusable solutions...",
            "John Doe"
        );
        
        PostFactory lifestyleFactory = new LifestylePostFactory();
        BlogPost lifePost = lifestyleFactory.publishPost(
            "Work-Life Balance Tips",
            "Maintaining balance is important...",
            "Jane Smith"
        );
    }
    
    private static void demonstrateAbstractFactory() {
        System.out.println("\n\n### 3. ABSTRACT FACTORY PATTERN ###");
        System.out.println("Purpose: Create families of UI components for different themes\n");
        
        // Modern theme
        UIComponentFactory modernFactory = new ModernUIFactory();
        System.out.println("Modern Theme Components:");
        modernFactory.createButton().render();
        modernFactory.createHeader().render();
        modernFactory.createFooter().render();
        
        System.out.println();
        
        // Classic theme
        UIComponentFactory classicFactory = new ClassicUIFactory();
        System.out.println("Classic Theme Components:");
        classicFactory.createButton().render();
        classicFactory.createHeader().render();
        classicFactory.createFooter().render();
    }
    
    private static void demonstrateBuilder() {
        System.out.println("\n\n### 4. BUILDER PATTERN ###");
        System.out.println("Purpose: Build complex blog posts step by step\n");
        
        BlogPost post = new BlogPostBuilder()
            .setTitle("Complete Guide to Spring Boot")
            .setAuthor("Mike Johnson")
            .setContent("This comprehensive guide covers...")
            .setCategory("Tutorial")
            .addTag("java")
            .addTag("spring")
            .addTag("backend")
            .build();
        
        System.out.println("Built post: " + post);
    }
    
    private static void demonstratePrototype() {
        System.out.println("\n\n### 5. PROTOTYPE PATTERN ###");
        System.out.println("Purpose: Clone blog posts from templates\n");
        
        PostPrototypeRegistry registry = new PostPrototypeRegistry();
        
        BlogPost post1 = registry.createPost("technical", 
            "Java 17 Features", 
            "New features in Java 17...", 
            "Developer A");
        System.out.println("Created: " + post1);
        
        BlogPost post2 = registry.createPost("news", 
            "Tech Conference 2024", 
            "Annual conference announcement...", 
            "Editor B");
        System.out.println("Created: " + post2);
    }
    
    private static void demonstrateAdapter() {
        System.out.println("\n\n### 6. ADAPTER PATTERN ###");
        System.out.println("Purpose: Adapt different content formats to common interface\n");
        
        // Using HTML renderer directly
        com.blog.patterns.structural.ContentRenderer htmlRenderer = 
            new com.blog.patterns.structural.HTMLRenderer();
        System.out.println(htmlRenderer.render("Simple HTML content"));
        
        // Using Markdown through adapter
        com.blog.patterns.structural.ContentRenderer markdownAdapter = 
            new MarkdownAdapter();
        System.out.println(markdownAdapter.render("# Markdown Title"));
    }
    
    private static void demonstrateDecorator() {
        System.out.println("\n\n### 7. DECORATOR PATTERN ###");
        System.out.println("Purpose: Add features to blog posts dynamically\n");
        
        BlogPost post = new BlogPost("1", "Design Patterns", "Content here", "Author");
        
        // Start with basic post
        BlogPostComponent basicPost = new BasicBlogPost(post);
        
        // Add comments
        BlogPostComponent postWithComments = new CommentDecorator(basicPost, 15);
        
        // Add likes
        BlogPostComponent postWithCommentsAndLikes = 
            new LikeDecorator(postWithComments, 42);
        
        System.out.println("Description: " + postWithCommentsAndLikes.getDescription());
        postWithCommentsAndLikes.display();
    }
    
    private static void demonstrateFacade() {
        System.out.println("\n\n### 8. FACADE PATTERN ###");
        System.out.println("Purpose: Simplify complex blog management operations\n");
        
        BlogManagementFacade facade = new BlogManagementFacade();
        
        BlogPost post = new BlogPost("1", 
            "Facade Pattern Example", 
            "Content about facade...", 
            "System Admin");
        
        facade.publishPost(post);
    }
    
    private static void demonstrateProxy() {
        System.out.println("\n\n### 9. PROXY PATTERN ###");
        System.out.println("Purpose: Lazy load blog post content\n");
        
        PostContent postContent = new PostContentProxy("post-123");
        
        System.out.println("Post content created (not loaded yet)");
        System.out.println("\nFirst access:");
        System.out.println(postContent.getContent());
        
        System.out.println("\nSecond access:");
        System.out.println(postContent.getContent());
    }
    
    private static void demonstrateObserver() {
        System.out.println("\n\n### 10. OBSERVER PATTERN ###");
        System.out.println("Purpose: Notify subscribers when new posts are published\n");
        
        BlogPublisher publisher = new BlogPublisher();
        
        // Add subscribers
        publisher.subscribe(new EmailSubscriber("user1@example.com"));
        publisher.subscribe(new EmailSubscriber("user2@example.com"));
        publisher.subscribe(new SMSSubscriber("+1234567890"));
        
        // Publish a post
        BlogPost post = new BlogPost("1", 
            "New Feature Release", 
            "We've released...", 
            "Product Team");
        publisher.publishPost(post);
    }
    
    private static void demonstrateStrategy() {
        System.out.println("\n\n### 11. STRATEGY PATTERN ###");
        System.out.println("Purpose: Switch between different rendering strategies\n");
        
        com.blog.patterns.behavioral.ContentRenderer renderer = 
            new com.blog.patterns.behavioral.ContentRenderer();
        String content = "Hello World from Strategy Pattern";
        
        // Render as plain text
        renderer.setStrategy(new PlainTextStrategy());
        System.out.println(renderer.renderContent(content));
        
        // Render as HTML
        renderer.setStrategy(new HTMLRenderingStrategy());
        System.out.println(renderer.renderContent(content));
        
        // Render as JSON
        renderer.setStrategy(new JSONRenderingStrategy());
        System.out.println(renderer.renderContent(content));
    }
    
    private static void demonstrateTemplateMethod() {
        System.out.println("\n\n### 12. TEMPLATE METHOD PATTERN ###");
        System.out.println("Purpose: Define publishing workflow template\n");
        
        // Technical post publishing
        BlogPost techPost = new BlogPost("1", 
            "Advanced Java Tutorial", 
            "Learn advanced concepts...", 
            "Tech Writer");
        techPost.addTag("tutorial");
        techPost.addTag("java");
        
        PostPublishingTemplate techPublisher = new TechnicalPostPublisher();
        techPublisher.publishPost(techPost);
        
        // News post publishing
        BlogPost newsPost = new BlogPost("2", 
            "Breaking: New Framework Released", 
            "Major announcement...", 
            "News Editor");
        
        PostPublishingTemplate newsPublisher = new NewsPostPublisher();
        newsPublisher.publishPost(newsPost);
    }
}
