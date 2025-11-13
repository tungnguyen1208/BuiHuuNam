package com.blog.patterns.pattern11_strategy;

import com.blog.patterns.shared.BlogPost;

/**
 * Context class that uses rendering strategy
 */
public class ContentRenderer {
    private RenderingStrategy strategy;
    
    public void setStrategy(RenderingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public String renderContent(BlogPost post) {
        if (strategy == null) {
            throw new IllegalStateException("Rendering strategy not set");
        }
        return strategy.render(post.getContent());
    }
    
    public String renderContent(String content) {
        if (strategy == null) {
            throw new IllegalStateException("Rendering strategy not set");
        }
        return strategy.render(content);
    }
}
