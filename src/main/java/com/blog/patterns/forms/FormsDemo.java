package com.blog.patterns.forms;

import java.util.Arrays;

/**
 * Demo class showing both forms using all 12 design patterns
 * 
 * Form 1: Post Submission Form - For creating blog posts
 * Form 2: Blog Settings Form - For configuring blog
 * 
 * Both forms demonstrate all 12 GoF Design Patterns
 */
public class FormsDemo {
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║       DEMO: 2 FORMS USING ALL 12 DESIGN PATTERNS            ║");
        System.out.println("║              Blog Website Application                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        
        // Demo Form 1: Post Submission Form
        demoPostSubmissionForm();
        
        System.out.println("\n\n");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("\n\n");
        
        // Demo Form 2: Blog Settings Form
        demoBlogSettingsForm();
        
        System.out.println("\n\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                   DEMO COMPLETED                              ║");
        System.out.println("║          Both forms successfully used all 12 patterns         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        
        printPatternsSummary();
    }
    
    /**
     * Demo Form 1: Post Submission Form
     * Shows how all 12 patterns work together when submitting a blog post
     */
    private static void demoPostSubmissionForm() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║            FORM 1: POST SUBMISSION FORM                       ║");
        System.out.println("║    (Demonstrating all 12 Design Patterns in action)          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        // Create form data (simulating user input)
        PostSubmissionFormData formData = new PostSubmissionFormData();
        formData.setTitle("Introduction to Design Patterns in Java");
        formData.setAuthor("John Developer");
        formData.setPostType("technical");
        formData.setContentFormat("markdown");
        formData.setContent("# Design Patterns\n\nThis is a comprehensive guide to **design patterns**...");
        formData.setTags(Arrays.asList("java", "design-patterns", "programming", "tutorial"));
        formData.setTheme("modern");
        formData.setEnableComments(true);
        formData.setEnableLikes(true);
        formData.setLazyLoad(true);
        formData.setNotifyEmail(true);
        formData.setNotifySMS(false);
        formData.setLoadFromTemplate(false);
        
        // Process form with controller
        PostSubmissionController controller = new PostSubmissionController();
        controller.processFormSubmission(formData);
        
        System.out.println("\n📄 Form 1 HTML File: src/main/webapp/forms/post-submission-form.html");
        System.out.println("🎯 Controller: PostSubmissionController.java");
    }
    
    /**
     * Demo Form 2: Blog Settings Form
     * Shows how all 12 patterns work together when configuring blog settings
     */
    private static void demoBlogSettingsForm() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          FORM 2: BLOG SETTINGS CONFIGURATION FORM             ║");
        System.out.println("║    (Demonstrating all 12 Design Patterns in action)          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        // Create form data (simulating user input)
        BlogSettingsFormData formData = new BlogSettingsFormData();
        
        // Singleton - Global Config
        formData.setBlogName("Tech Insights Blog");
        formData.setLanguage("vi");
        formData.setPostsPerPage(15);
        formData.setTimezone("UTC+7");
        
        // Abstract Factory - UI Theme
        formData.setUiTheme("modern");
        
        // Factory Method & Prototype
        formData.setDefaultPostType("technical");
        formData.setUseTechTemplate(true);
        formData.setUseNewsTemplate(true);
        formData.setLoadDefaults(false);
        
        // Strategy & Adapter
        formData.setRenderStrategy("html");
        formData.setSupportMarkdown(true);
        formData.setSupportHTML(true);
        
        // Decorator
        formData.setEnableCommentsGlobal(true);
        formData.setEnableLikesGlobal(true);
        formData.setEnableShare(true);
        formData.setEnableReactions(false);
        
        // Proxy
        formData.setLazyLoadContent(true);
        formData.setLazyLoadImages(true);
        formData.setLazyLoadComments(false);
        
        // Observer
        formData.setNotifyEmail(true);
        formData.setNotifySMS(false);
        formData.setNotifyPush(true);
        formData.setNotifyRSS(true);
        
        // Template Method & Facade
        formData.setAutoFormat(true);
        formData.setAutoIndex(true);
        formData.setAutoNotify(true);
        formData.setPublishMode("immediate");
        
        // Builder - Advanced Settings
        formData.setSeoTitle("{title} - {blogName}");
        formData.setPermalinkFormat("/{year}/{month}/{slug}");
        formData.setCacheExpiry(60);
        formData.setMaxImageSize(5);
        
        // Process form with controller
        BlogSettingsController controller = new BlogSettingsController();
        controller.processSettingsUpdate(formData);
        
        System.out.println("\n📄 Form 2 HTML File: src/main/webapp/forms/blog-settings-form.html");
        System.out.println("🎯 Controller: BlogSettingsController.java");
    }
    
    /**
     * Print summary of how patterns are used in both forms
     */
    private static void printPatternsSummary() {
        System.out.println("\n\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          PATTERN USAGE SUMMARY IN BOTH FORMS                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        String[][] patterns = {
            {"1", "Singleton", "Global blog configuration", "BlogConfiguration.getInstance()"},
            {"2", "Factory Method", "Create posts by type", "TechnicalPostFactory, LifestylePostFactory"},
            {"3", "Abstract Factory", "UI theme components", "ModernUIFactory, ClassicUIFactory"},
            {"4", "Builder", "Build complex objects", "BlogPostBuilder, AdvancedSettingsBuilder"},
            {"5", "Prototype", "Clone from templates", "PostPrototypeRegistry, SettingsPrototype"},
            {"6", "Adapter", "Content format conversion", "MarkdownAdapter"},
            {"7", "Decorator", "Add features dynamically", "CommentDecorator, LikeDecorator"},
            {"8", "Facade", "Simplify operations", "BlogManagementFacade, ConfigurationFacade"},
            {"9", "Proxy", "Lazy loading", "PostContentProxy"},
            {"10", "Observer", "Notify subscribers", "BlogPublisher, SettingsChangePublisher"},
            {"11", "Strategy", "Rendering strategies", "HTMLStrategy, JSONStrategy, PlainTextStrategy"},
            {"12", "Template Method", "Publishing workflow", "PostPublishingTemplate"}
        };
        
        System.out.println("┌─────┬─────────────────────┬──────────────────────────┬───────────────────────────┐");
        System.out.println("│ No. │ Pattern             │ Purpose                  │ Implementation            │");
        System.out.println("├─────┼─────────────────────┼──────────────────────────┼───────────────────────────┤");
        
        for (String[] pattern : patterns) {
            System.out.printf("│ %-3s │ %-19s │ %-24s │ %-25s │%n", 
                pattern[0], pattern[1], pattern[2], pattern[3]);
        }
        
        System.out.println("└─────┴─────────────────────┴──────────────────────────┴───────────────────────────┘");
        
        System.out.println("\n📋 Files Created:");
        System.out.println("   1. src/main/webapp/forms/post-submission-form.html");
        System.out.println("   2. src/main/webapp/forms/blog-settings-form.html");
        System.out.println("   3. src/main/java/com/blog/patterns/forms/PostSubmissionController.java");
        System.out.println("   4. src/main/java/com/blog/patterns/forms/BlogSettingsController.java");
        System.out.println("   5. src/main/java/com/blog/patterns/forms/FormsDemo.java");
        
        System.out.println("\n💡 To view the forms:");
        System.out.println("   Open the HTML files in a web browser");
        System.out.println("   Or run: mvn exec:java -Dexec.mainClass=\"com.blog.patterns.forms.FormsDemo\"");
        
        System.out.println("\n✅ Both forms successfully demonstrate all 12 Gang of Four Design Patterns!");
    }
}
