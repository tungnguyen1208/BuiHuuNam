package com.blog.patterns.structural;

import com.blog.patterns.models.BlogPost;

/**
 * Decorator Pattern - Blog Post Component
 * Base interface for blog posts with additional features
 */
public interface BlogPostComponent {
    void display();
    String getDescription();
}
