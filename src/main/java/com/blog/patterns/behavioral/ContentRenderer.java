package com.blog.patterns.behavioral;

/**
 * Context class that uses rendering strategy
 */
public class ContentRenderer {
    private RenderingStrategy strategy;
    
    public void setStrategy(RenderingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String renderContent(String content) {
        if (strategy == null) {
            throw new IllegalStateException("Rendering strategy not set");
        }
        return strategy.render(content);
    }
}
