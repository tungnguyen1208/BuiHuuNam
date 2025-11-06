package com.blog.patterns.creational;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton Pattern - BlogConfiguration
 * Ensures only one instance of blog configuration exists throughout the application
 */
public class BlogConfiguration {
    private static BlogConfiguration instance;
    private Map<String, String> settings;
    
    private BlogConfiguration() {
        settings = new HashMap<>();
        loadDefaultSettings();
    }
    
    public static synchronized BlogConfiguration getInstance() {
        if (instance == null) {
            instance = new BlogConfiguration();
        }
        return instance;
    }
    
    private void loadDefaultSettings() {
        settings.put("blogName", "Tech Blog");
        settings.put("theme", "modern");
        settings.put("postsPerPage", "10");
        settings.put("language", "en");
    }
    
    public String getSetting(String key) {
        return settings.get(key);
    }
    
    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
    
    public void displaySettings() {
        System.out.println("\n=== Blog Configuration (Singleton) ===");
        settings.forEach((key, value) -> 
            System.out.println(key + ": " + value));
    }
}
