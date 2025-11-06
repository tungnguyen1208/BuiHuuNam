package com.blog;

import com.blog.model.BlogPost;
import com.blog.model.Comment;
import com.blog.model.User;

// Creational Patterns
import com.blog.designpatterns.creational.BlogConfiguration;
import com.blog.designpatterns.creational.BlogPostBuilder;
import com.blog.designpatterns.creational.BlogPostPrototype;
import com.blog.designpatterns.creational.UIComponentFactory;
import com.blog.designpatterns.creational.UIComponentFactoryProvider;
import com.blog.designpatterns.creational.BlogPostFactory;
import com.blog.designpatterns.creational.BlogPostFactoryProvider;

// Structural Patterns
import com.blog.designpatterns.structural.LegacyBlogAdapter;
import com.blog.designpatterns.structural.LegacyBlogAdapterFactory;
import com.blog.designpatterns.structural.BlogRenderer;
import com.blog.designpatterns.structural.BlogRendererFactory;
import com.blog.designpatterns.structural.CommentComponent;
import com.blog.designpatterns.structural.CommentFactory;
import com.blog.designpatterns.structural.BlogPostDecorator;
import com.blog.designpatterns.structural.BlogPostDecoratorFactory;
import com.blog.designpatterns.structural.BlogManagementFacade;
import com.blog.designpatterns.structural.BlogPostProxyFactory;

// Behavioral Patterns
import com.blog.designpatterns.behavioral.BlogSubscriberFacade;

/**
 * Demo application showcasing 12 Design Patterns for a Blog Website
 * 
 * Creational Patterns:
 * 1. Singleton - BlogConfiguration
 * 2. Factory Method - BlogPostFactory
 * 3. Abstract Factory - UIComponentFactory
 * 4. Builder - BlogPostBuilder
 * 5. Prototype - BlogPostPrototype
 * 
 * Structural Patterns:
 * 6. Adapter - LegacyBlogAdapter
 * 7. Bridge - BlogRenderer
 * 8. Composite - CommentComponent
 * 9. Decorator - BlogPostDecorator
 * 10. Facade - BlogManagementFacade
 * 11. Proxy - BlogPostProxy
 * 
 * Behavioral Patterns:
 * 12. Observer - BlogSubscriber
 */
public class BlogDesignPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("BLOG WEBSITE - 12 DESIGN PATTERNS DEMONSTRATION");
        System.out.println("=".repeat(80));
        
        demonstrateSingleton();
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
        demonstrateBuilder();
        demonstratePrototype();
        demonstrateAdapter();
        demonstrateBridge();
        demonstrateComposite();
        demonstrateDecorator();
        demonstrateFacade();
        demonstrateProxy();
        demonstrateObserver();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL 12 DESIGN PATTERNS DEMONSTRATED SUCCESSFULLY!");
        System.out.println("=".repeat(80));
    }
    
    private static void demonstrateSingleton() {
        System.out.println("\n--- 1. SINGLETON PATTERN (BlogConfiguration) ---");
        BlogConfiguration config = BlogConfiguration.getInstance();
        System.out.println("Blog Name: " + config.getBlogName());
        System.out.println("Posts Per Page: " + config.getPostsPerPage());
        System.out.println("Comments Enabled: " + config.isCommentsEnabled());
        
        // Verify it's the same instance
        BlogConfiguration config2 = BlogConfiguration.getInstance();
        System.out.println("Same instance: " + (config == config2));
    }
    
    private static void demonstrateFactoryMethod() {
        System.out.println("\n--- 2. FACTORY METHOD PATTERN (BlogPostFactory) ---");
        BlogPostFactory factory = BlogPostFactoryProvider.getTechnicalFactory();
        BlogPost post = factory.createAndPublish(
            "Introduction to Design Patterns",
            "Design patterns are reusable solutions...",
            "John Doe"
        );
        System.out.println("Created: " + post);
    }
    
    private static void demonstrateAbstractFactory() {
        System.out.println("\n--- 3. ABSTRACT FACTORY PATTERN (UIComponentFactory) ---");
        
        // Create dark theme components
        System.out.println("Dark Theme:");
        UIComponentFactoryProvider.renderDarkTheme();
        
        // Create light theme components
        System.out.println("\nLight Theme:");
        UIComponentFactoryProvider.renderLightTheme();
    }
    
    private static void demonstrateBuilder() {
        System.out.println("\n--- 4. BUILDER PATTERN (BlogPostBuilder) ---");
        BlogPost post = BlogPostBuilder.builder()
            .withTitle("Advanced Java Techniques")
            .withContent("This post covers advanced Java programming techniques...")
            .withAuthor("Jane Smith")
            .addTag("Java")
            .addTag("Programming")
            .addTag("Advanced")
            .build();
        System.out.println("Built post: " + post);
    }
    
    private static void demonstratePrototype() {
        System.out.println("\n--- 5. PROTOTYPE PATTERN (BlogPostPrototype) ---");
        BlogPostPrototype prototype = new BlogPostPrototype();
        
        // Clone from template
        BlogPost technicalPost = prototype.createPost("technical");
        technicalPost.setAuthor("Alice");
        technicalPost.setContent("My technical blog content...");
        System.out.println("Cloned technical post: " + technicalPost);
        
        BlogPost tutorialPost = prototype.createPost("tutorial");
        tutorialPost.setAuthor("Bob");
        System.out.println("Cloned tutorial post: " + tutorialPost);
    }
    
    private static void demonstrateAdapter() {
        System.out.println("\n--- 6. ADAPTER PATTERN (LegacyBlogAdapter) ---");
        LegacyBlogAdapter adapter = LegacyBlogAdapterFactory.createAdapter();
        
        // Use modern interface with legacy system
        BlogPost newPost = new BlogPost("1", "Migrating Legacy Systems", 
                                        "How to migrate old systems...", "Adapter Expert");
        adapter.savePost(newPost);
        System.out.println("Post saved through adapter");
    }
    
    private static void demonstrateBridge() {
        System.out.println("\n--- 7. BRIDGE PATTERN (BlogRenderer) ---");
        BlogPost post = new BlogPost("1", "Bridge Pattern Demo", 
                                     "This demonstrates the bridge pattern in action.", 
                                     "Bridge Developer");
        
        System.out.println("\nDetailed HTML Rendering:");
        BlogRenderer htmlRenderer = BlogRendererFactory.createDetailedHTMLRenderer();
        htmlRenderer.render(post);
        
        System.out.println("\nSummary Markdown Rendering:");
        BlogRenderer markdownRenderer = BlogRendererFactory.createSummaryMarkdownRenderer();
        markdownRenderer.render(post);
    }
    
    private static void demonstrateComposite() {
        System.out.println("\n--- 8. COMPOSITE PATTERN (CommentComponent) ---");
        
        // Create a comment tree
        CommentComponent rootComment = CommentFactory.createCommentThread("1", "Alice", "Great article!");
        rootComment.add(CommentFactory.createSingleComment("2", "Bob", "I agree!"));
        
        CommentComponent reply = CommentFactory.createCommentThread("3", "Charlie", "Can you elaborate?");
        reply.add(CommentFactory.createSingleComment("4", "Alice", "Sure, let me explain..."));
        reply.add(CommentFactory.createSingleComment("5", "David", "Thanks for clarifying!"));
        
        rootComment.add(reply);
        rootComment.add(CommentFactory.createSingleComment("6", "Eve", "Very helpful!"));
        
        System.out.println("Comment tree structure:");
        rootComment.display(0);
        System.out.println("Total comments: " + rootComment.getCommentCount());
    }
    
    private static void demonstrateDecorator() {
        System.out.println("\n--- 9. DECORATOR PATTERN (BlogPostDecorator) ---");
        BlogPost post = new BlogPost("1", "Decorator Pattern Example",
                                     "This is a basic blog post that will be decorated with additional features.",
                                     "Decorator Dev");
        
        // Add multiple decorators
        BlogPostDecorator seoDecorated = BlogPostDecoratorFactory.withSEO(post, 
            "Learn about decorator pattern", "design patterns, decorator, java");
        BlogPostDecorator socialDecorated = BlogPostDecoratorFactory.withSocialMedia(post);
        BlogPostDecorator timeDecorated = BlogPostDecoratorFactory.withReadingTime(post);
        
        System.out.println("Title with reading time: " + timeDecorated.getTitle());
        System.out.println("\nContent with SEO:");
        System.out.println(seoDecorated.getContent());
        System.out.println("\nContent with social media:");
        System.out.println(socialDecorated.getContent());
    }
    
    private static void demonstrateFacade() {
        System.out.println("\n--- 10. FACADE PATTERN (BlogManagementFacade) ---");
        BlogManagementFacade facade = new BlogManagementFacade();
        
        User author = new User("1", "john_doe", "john@example.com", "author");
        BlogPost post = new BlogPost("1", "Facade Pattern in Action",
                                     "Simplifying complex subsystems...", "John Doe");
        
        // Simplified publishing through facade
        facade.publishBlogPost(post, author);
        
        // Simplified comment addition
        Comment comment = new Comment("1", "Jane", "Excellent explanation!");
        facade.addComment("1", comment, new User("2", "jane_doe", "jane@example.com", "user"));
        
        // Simplified search
        facade.searchPosts("Facade");
    }
    
    private static void demonstrateProxy() {
        System.out.println("\n--- 11. PROXY PATTERN (BlogPostProxy) ---");
        
        // Caching proxy
        System.out.println("\nCaching Proxy:");
        BlogPostProxyFactory.demonstrateCachingProxy("123");
        
        // Protected proxy
        System.out.println("\nProtected Proxy:");
        User adminUser = new User("1", "admin", "admin@example.com", "admin");
        User regularUser = new User("2", "user", "user@example.com", "user");
        BlogPost post = new BlogPost("1", "Test", "Content", "Author");
        
        BlogPostProxyFactory.demonstrateProtectedProxy(adminUser, post); // Allowed
        BlogPostProxyFactory.demonstrateProtectedProxy(regularUser, post); // Denied
    }
    
    private static void demonstrateObserver() {
        System.out.println("\n--- 12. OBSERVER PATTERN (BlogSubscriber) ---");
        
        BlogSubscriberFacade blogFacade = new BlogSubscriberFacade();
        
        // Subscribe different types of observers
        blogFacade.subscribeEmail("Alice", "alice@example.com");
        blogFacade.subscribeSMS("Bob", "+1234567890");
        
        User user = new User("1", "charlie", "charlie@example.com", "user");
        blogFacade.subscribePushNotification(user, "device123");
        
        // Publish a post - all subscribers get notified
        BlogPost post = new BlogPost("1", "Observer Pattern Tutorial",
                                     "Learn how to implement the observer pattern in your applications.",
                                     "Pattern Expert");
        blogFacade.publishPost(post);
    }
}
