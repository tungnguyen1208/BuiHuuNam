package com.blog.designpatterns.creational;

import java.util.Properties;

/**
 * Singleton Pattern - BlogConfiguration
 * Ensures only one instance of configuration exists throughout the application
 */
public class BlogConfiguration {
    private static BlogConfiguration instance;
    private Properties properties;
    
    private BlogConfiguration() {
        properties = new Properties();
        // Load default configuration
        properties.setProperty("blog.name", "My Tech Blog");
        properties.setProperty("blog.description", "A blog about technology and design patterns");
        properties.setProperty("blog.posts.per.page", "10");
        properties.setProperty("blog.comments.enabled", "true");
        properties.setProperty("blog.theme", "default");
    }
    
    public static synchronized BlogConfiguration getInstance() {
        if (instance == null) {
            instance = new BlogConfiguration();
        }
        return instance;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    public int getPostsPerPage() {
        return Integer.parseInt(properties.getProperty("blog.posts.per.page", "10"));
    }
    
    public boolean isCommentsEnabled() {
        return Boolean.parseBoolean(properties.getProperty("blog.comments.enabled", "true"));
    }
    
    public String getBlogName() {
        return properties.getProperty("blog.name");
    }
    
    public String getBlogDescription() {
        return properties.getProperty("blog.description");
    }
    
    public String getTheme() {
        return properties.getProperty("blog.theme");
    }
}
