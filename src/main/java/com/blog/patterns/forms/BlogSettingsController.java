package com.blog.patterns.forms;

import com.blog.patterns.behavioral.*;
import com.blog.patterns.creational.*;
import com.blog.patterns.models.BlogPost;
import com.blog.patterns.structural.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for Blog Settings Configuration Form
 * Demonstrates all 12 Design Patterns working together
 */
public class BlogSettingsController {
    
    // Singleton - Global configuration instance
    private BlogConfiguration config;
    
    // Prototype - Registry for default settings
    private SettingsPrototypeRegistry prototypeRegistry;
    
    // Observer - For configuration change notifications
    private SettingsChangePublisher changePublisher;
    
    // Facade - Simplify complex configuration updates
    private ConfigurationFacade configFacade;
    
    public BlogSettingsController() {
        // Initialize patterns
        this.config = BlogConfiguration.getInstance();  // Singleton
        this.prototypeRegistry = new SettingsPrototypeRegistry();  // Prototype
        this.changePublisher = new SettingsChangePublisher();  // Observer
        this.configFacade = new ConfigurationFacade();  // Facade
    }
    
    /**
     * Process settings form submission - Uses ALL 12 Design Patterns
     */
    public void processSettingsUpdate(BlogSettingsFormData formData) {
        System.out.println("\n========================================");
        System.out.println("PROCESSING BLOG SETTINGS FORM");
        System.out.println("Demonstrating All 12 Design Patterns");
        System.out.println("========================================\n");
        
        // 1. SINGLETON PATTERN
        // Update global configuration
        System.out.println("1. [Singleton] Updating global configuration...");
        config.setSetting("blogName", formData.getBlogName());
        config.setSetting("language", formData.getLanguage());
        config.setSetting("postsPerPage", String.valueOf(formData.getPostsPerPage()));
        config.setSetting("timezone", formData.getTimezone());
        System.out.println("   Configuration updated in singleton instance");
        config.displaySettings();
        
        // 2. FACTORY METHOD PATTERN
        // Create default post factory based on settings
        System.out.println("\n2. [Factory Method] Setting default post type factory...");
        PostFactory defaultFactory = createDefaultFactory(formData.getDefaultPostType());
        System.out.println("   Default factory set to: " + formData.getDefaultPostType());
        
        // 3. ABSTRACT FACTORY PATTERN
        // Create UI theme components
        System.out.println("\n3. [Abstract Factory] Applying UI theme...");
        UIComponentFactory uiFactory = createUIFactory(formData.getUiTheme());
        Button button = uiFactory.createButton();
        Header header = uiFactory.createHeader();
        Footer footer = uiFactory.createFooter();
        System.out.println("   Theme components created:");
        System.out.print("   ");
        button.render();
        System.out.print("   ");
        header.render();
        System.out.print("   ");
        footer.render();
        
        // 4. BUILDER PATTERN
        // Build complex settings object
        System.out.println("\n4. [Builder] Building advanced settings...");
        AdvancedSettings advSettings = new AdvancedSettingsBuilder()
            .setSeoTitleTemplate(formData.getSeoTitle())
            .setPermalinkFormat(formData.getPermalinkFormat())
            .setCacheExpiry(formData.getCacheExpiry())
            .setMaxImageSize(formData.getMaxImageSize())
            .build();
        System.out.println("   Advanced settings built: " + advSettings);
        
        // 5. PROTOTYPE PATTERN
        // Load or save settings template
        System.out.println("\n5. [Prototype] Managing settings templates...");
        if (formData.isLoadDefaults()) {
            BlogSettingsFormData defaultSettings = prototypeRegistry.getDefaultSettings();
            System.out.println("   Default settings loaded from prototype");
        } else {
            prototypeRegistry.saveAsTemplate("custom", formData);
            System.out.println("   Current settings saved as template");
        }
        
        // 6. ADAPTER PATTERN
        // Adapt content format support
        System.out.println("\n6. [Adapter] Configuring content format adapters...");
        if (formData.isSupportMarkdown()) {
            com.blog.patterns.structural.ContentRenderer markdownAdapter = new MarkdownAdapter();
            System.out.println("   Markdown adapter enabled");
        }
        if (formData.isSupportHTML()) {
            com.blog.patterns.structural.ContentRenderer htmlRenderer = new HTMLRenderer();
            System.out.println("   Direct HTML renderer enabled");
        }
        
        // 7. DECORATOR PATTERN
        // Configure default features
        System.out.println("\n7. [Decorator] Configuring default post features...");
        Map<String, Boolean> features = new HashMap<>();
        features.put("comments", formData.isEnableCommentsGlobal());
        features.put("likes", formData.isEnableLikesGlobal());
        features.put("share", formData.isEnableShare());
        features.put("reactions", formData.isEnableReactions());
        
        System.out.println("   Default features configured:");
        features.forEach((feature, enabled) -> 
            System.out.println("   - " + feature + ": " + (enabled ? "enabled" : "disabled"))
        );
        
        // 8. PROXY PATTERN
        // Configure lazy loading settings
        System.out.println("\n8. [Proxy] Configuring lazy loading (Proxy)...");
        Map<String, Boolean> lazyLoadSettings = new HashMap<>();
        lazyLoadSettings.put("content", formData.isLazyLoadContent());
        lazyLoadSettings.put("images", formData.isLazyLoadImages());
        lazyLoadSettings.put("comments", formData.isLazyLoadComments());
        
        System.out.println("   Lazy loading settings:");
        lazyLoadSettings.forEach((resource, enabled) -> 
            System.out.println("   - " + resource + ": " + (enabled ? "lazy" : "eager"))
        );
        
        // 9. OBSERVER PATTERN
        // Configure notification channels
        System.out.println("\n9. [Observer] Configuring notification observers...");
        changePublisher.clearSubscribers();
        
        if (formData.isNotifyEmail()) {
            changePublisher.addSubscriber(new EmailNotificationObserver());
            System.out.println("   + Email notification observer added");
        }
        if (formData.isNotifySMS()) {
            changePublisher.addSubscriber(new SMSNotificationObserver());
            System.out.println("   + SMS notification observer added");
        }
        if (formData.isNotifyPush()) {
            changePublisher.addSubscriber(new PushNotificationObserver());
            System.out.println("   + Push notification observer added");
        }
        if (formData.isNotifyRSS()) {
            changePublisher.addSubscriber(new RSSUpdateObserver());
            System.out.println("   + RSS update observer added");
        }
        
        // 10. STRATEGY PATTERN
        // Set rendering strategy
        System.out.println("\n10. [Strategy] Setting default rendering strategy...");
        RenderingStrategy renderStrategy = createRenderingStrategy(formData.getRenderStrategy());
        System.out.println("   Rendering strategy: " + formData.getRenderStrategy());
        
        // 11. TEMPLATE METHOD PATTERN
        // Configure publishing workflow
        System.out.println("\n11. [Template Method] Configuring publishing workflow...");
        PublishingWorkflowConfig workflowConfig = new PublishingWorkflowConfig();
        workflowConfig.setAutoFormat(formData.isAutoFormat());
        workflowConfig.setAutoIndex(formData.isAutoIndex());
        workflowConfig.setAutoNotify(formData.isAutoNotify());
        workflowConfig.setPublishMode(formData.getPublishMode());
        
        System.out.println("   Workflow steps configured:");
        System.out.println("   - Auto validate: always enabled (required)");
        System.out.println("   - Auto format: " + formData.isAutoFormat());
        System.out.println("   - Auto save: always enabled (required)");
        System.out.println("   - Auto index: " + formData.isAutoIndex());
        System.out.println("   - Auto notify: " + formData.isAutoNotify());
        System.out.println("   - Publish mode: " + formData.getPublishMode());
        
        // 12. FACADE PATTERN
        // Use facade to apply all settings at once
        System.out.println("\n12. [Facade] Applying all settings via facade...");
        configFacade.applySettings(formData);
        System.out.println("   All settings applied successfully");
        
        // Notify observers about configuration change
        changePublisher.notifyConfigurationChange("Settings updated");
        
        System.out.println("\n========================================");
        System.out.println("✅ ALL 12 PATTERNS SUCCESSFULLY APPLIED!");
        System.out.println("Blog settings updated successfully");
        System.out.println("========================================\n");
    }
    
    // Helper methods
    
    private PostFactory createDefaultFactory(String type) {
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
    
    private RenderingStrategy createRenderingStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "html":
                return new HTMLRenderingStrategy();
            case "json":
                return new JSONRenderingStrategy();
            case "plain":
            default:
                return new PlainTextStrategy();
        }
    }
}

/**
 * Settings Form Data Transfer Object
 */
class BlogSettingsFormData {
    // Singleton - Global Config
    private String blogName;
    private String language;
    private int postsPerPage;
    private String timezone;
    
    // Abstract Factory - UI Theme
    private String uiTheme;
    
    // Factory Method & Prototype
    private String defaultPostType;
    private boolean useTechTemplate;
    private boolean useNewsTemplate;
    private boolean loadDefaults;
    
    // Strategy & Adapter
    private String renderStrategy;
    private boolean supportMarkdown;
    private boolean supportHTML;
    
    // Decorator
    private boolean enableCommentsGlobal;
    private boolean enableLikesGlobal;
    private boolean enableShare;
    private boolean enableReactions;
    
    // Proxy
    private boolean lazyLoadContent;
    private boolean lazyLoadImages;
    private boolean lazyLoadComments;
    
    // Observer
    private boolean notifyEmail;
    private boolean notifySMS;
    private boolean notifyPush;
    private boolean notifyRSS;
    
    // Template Method & Facade
    private boolean autoFormat;
    private boolean autoIndex;
    private boolean autoNotify;
    private String publishMode;
    
    // Builder - Advanced Settings
    private String seoTitle;
    private String permalinkFormat;
    private int cacheExpiry;
    private int maxImageSize;
    
    // Getters and Setters
    public String getBlogName() { return blogName; }
    public void setBlogName(String blogName) { this.blogName = blogName; }
    
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    
    public int getPostsPerPage() { return postsPerPage; }
    public void setPostsPerPage(int postsPerPage) { this.postsPerPage = postsPerPage; }
    
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
    
    public String getUiTheme() { return uiTheme; }
    public void setUiTheme(String uiTheme) { this.uiTheme = uiTheme; }
    
    public String getDefaultPostType() { return defaultPostType; }
    public void setDefaultPostType(String defaultPostType) { this.defaultPostType = defaultPostType; }
    
    public boolean isUseTechTemplate() { return useTechTemplate; }
    public void setUseTechTemplate(boolean useTechTemplate) { this.useTechTemplate = useTechTemplate; }
    
    public boolean isUseNewsTemplate() { return useNewsTemplate; }
    public void setUseNewsTemplate(boolean useNewsTemplate) { this.useNewsTemplate = useNewsTemplate; }
    
    public boolean isLoadDefaults() { return loadDefaults; }
    public void setLoadDefaults(boolean loadDefaults) { this.loadDefaults = loadDefaults; }
    
    public String getRenderStrategy() { return renderStrategy; }
    public void setRenderStrategy(String renderStrategy) { this.renderStrategy = renderStrategy; }
    
    public boolean isSupportMarkdown() { return supportMarkdown; }
    public void setSupportMarkdown(boolean supportMarkdown) { this.supportMarkdown = supportMarkdown; }
    
    public boolean isSupportHTML() { return supportHTML; }
    public void setSupportHTML(boolean supportHTML) { this.supportHTML = supportHTML; }
    
    public boolean isEnableCommentsGlobal() { return enableCommentsGlobal; }
    public void setEnableCommentsGlobal(boolean enableCommentsGlobal) { this.enableCommentsGlobal = enableCommentsGlobal; }
    
    public boolean isEnableLikesGlobal() { return enableLikesGlobal; }
    public void setEnableLikesGlobal(boolean enableLikesGlobal) { this.enableLikesGlobal = enableLikesGlobal; }
    
    public boolean isEnableShare() { return enableShare; }
    public void setEnableShare(boolean enableShare) { this.enableShare = enableShare; }
    
    public boolean isEnableReactions() { return enableReactions; }
    public void setEnableReactions(boolean enableReactions) { this.enableReactions = enableReactions; }
    
    public boolean isLazyLoadContent() { return lazyLoadContent; }
    public void setLazyLoadContent(boolean lazyLoadContent) { this.lazyLoadContent = lazyLoadContent; }
    
    public boolean isLazyLoadImages() { return lazyLoadImages; }
    public void setLazyLoadImages(boolean lazyLoadImages) { this.lazyLoadImages = lazyLoadImages; }
    
    public boolean isLazyLoadComments() { return lazyLoadComments; }
    public void setLazyLoadComments(boolean lazyLoadComments) { this.lazyLoadComments = lazyLoadComments; }
    
    public boolean isNotifyEmail() { return notifyEmail; }
    public void setNotifyEmail(boolean notifyEmail) { this.notifyEmail = notifyEmail; }
    
    public boolean isNotifySMS() { return notifySMS; }
    public void setNotifySMS(boolean notifySMS) { this.notifySMS = notifySMS; }
    
    public boolean isNotifyPush() { return notifyPush; }
    public void setNotifyPush(boolean notifyPush) { this.notifyPush = notifyPush; }
    
    public boolean isNotifyRSS() { return notifyRSS; }
    public void setNotifyRSS(boolean notifyRSS) { this.notifyRSS = notifyRSS; }
    
    public boolean isAutoFormat() { return autoFormat; }
    public void setAutoFormat(boolean autoFormat) { this.autoFormat = autoFormat; }
    
    public boolean isAutoIndex() { return autoIndex; }
    public void setAutoIndex(boolean autoIndex) { this.autoIndex = autoIndex; }
    
    public boolean isAutoNotify() { return autoNotify; }
    public void setAutoNotify(boolean autoNotify) { this.autoNotify = autoNotify; }
    
    public String getPublishMode() { return publishMode; }
    public void setPublishMode(String publishMode) { this.publishMode = publishMode; }
    
    public String getSeoTitle() { return seoTitle; }
    public void setSeoTitle(String seoTitle) { this.seoTitle = seoTitle; }
    
    public String getPermalinkFormat() { return permalinkFormat; }
    public void setPermalinkFormat(String permalinkFormat) { this.permalinkFormat = permalinkFormat; }
    
    public int getCacheExpiry() { return cacheExpiry; }
    public void setCacheExpiry(int cacheExpiry) { this.cacheExpiry = cacheExpiry; }
    
    public int getMaxImageSize() { return maxImageSize; }
    public void setMaxImageSize(int maxImageSize) { this.maxImageSize = maxImageSize; }
}

// Helper classes for patterns

class AdvancedSettings {
    private String seoTitleTemplate;
    private String permalinkFormat;
    private int cacheExpiry;
    private int maxImageSize;
    
    public AdvancedSettings(String seoTitleTemplate, String permalinkFormat, int cacheExpiry, int maxImageSize) {
        this.seoTitleTemplate = seoTitleTemplate;
        this.permalinkFormat = permalinkFormat;
        this.cacheExpiry = cacheExpiry;
        this.maxImageSize = maxImageSize;
    }
    
    @Override
    public String toString() {
        return String.format("AdvancedSettings{seo='%s', permalink='%s', cache=%dmin, maxImg=%dMB}",
            seoTitleTemplate, permalinkFormat, cacheExpiry, maxImageSize);
    }
}

class AdvancedSettingsBuilder {
    private String seoTitleTemplate;
    private String permalinkFormat;
    private int cacheExpiry;
    private int maxImageSize;
    
    public AdvancedSettingsBuilder setSeoTitleTemplate(String template) {
        this.seoTitleTemplate = template;
        return this;
    }
    
    public AdvancedSettingsBuilder setPermalinkFormat(String format) {
        this.permalinkFormat = format;
        return this;
    }
    
    public AdvancedSettingsBuilder setCacheExpiry(int minutes) {
        this.cacheExpiry = minutes;
        return this;
    }
    
    public AdvancedSettingsBuilder setMaxImageSize(int megabytes) {
        this.maxImageSize = megabytes;
        return this;
    }
    
    public AdvancedSettings build() {
        return new AdvancedSettings(seoTitleTemplate, permalinkFormat, cacheExpiry, maxImageSize);
    }
}

class SettingsPrototypeRegistry {
    private Map<String, BlogSettingsFormData> templates = new HashMap<>();
    
    public BlogSettingsFormData getDefaultSettings() {
        BlogSettingsFormData defaults = new BlogSettingsFormData();
        defaults.setBlogName("My Awesome Blog");
        defaults.setLanguage("vi");
        defaults.setPostsPerPage(10);
        defaults.setUiTheme("modern");
        return defaults;
    }
    
    public void saveAsTemplate(String name, BlogSettingsFormData settings) {
        templates.put(name, settings);
    }
}

class SettingsChangePublisher {
    private java.util.List<SettingsObserver> subscribers = new java.util.ArrayList<>();
    
    public void addSubscriber(SettingsObserver observer) {
        subscribers.add(observer);
    }
    
    public void clearSubscribers() {
        subscribers.clear();
    }
    
    public void notifyConfigurationChange(String message) {
        System.out.println("   Notifying " + subscribers.size() + " observers of configuration change");
        for (SettingsObserver observer : subscribers) {
            observer.onConfigChange(message);
        }
    }
}

interface SettingsObserver {
    void onConfigChange(String message);
}

class EmailNotificationObserver implements SettingsObserver {
    public void onConfigChange(String message) {
        System.out.println("   [Email Observer] " + message);
    }
}

class SMSNotificationObserver implements SettingsObserver {
    public void onConfigChange(String message) {
        System.out.println("   [SMS Observer] " + message);
    }
}

class PushNotificationObserver implements SettingsObserver {
    public void onConfigChange(String message) {
        System.out.println("   [Push Observer] " + message);
    }
}

class RSSUpdateObserver implements SettingsObserver {
    public void onConfigChange(String message) {
        System.out.println("   [RSS Observer] " + message);
    }
}

class PublishingWorkflowConfig {
    private boolean autoFormat;
    private boolean autoIndex;
    private boolean autoNotify;
    private String publishMode;
    
    public void setAutoFormat(boolean autoFormat) { this.autoFormat = autoFormat; }
    public void setAutoIndex(boolean autoIndex) { this.autoIndex = autoIndex; }
    public void setAutoNotify(boolean autoNotify) { this.autoNotify = autoNotify; }
    public void setPublishMode(String publishMode) { this.publishMode = publishMode; }
}

class ConfigurationFacade {
    public void applySettings(BlogSettingsFormData settings) {
        // Facade simplifies applying all settings at once
        System.out.println("   Validating settings...");
        System.out.println("   Saving to configuration store...");
        System.out.println("   Updating cache...");
        System.out.println("   Reloading components...");
    }
}
