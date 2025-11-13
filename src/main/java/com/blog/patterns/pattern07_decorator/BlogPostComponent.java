package com.blog.patterns.pattern07_decorator;

import com.blog.patterns.shared.*;

/**
 * Decorator Pattern - Blog Post Component
 * Base interface for blog posts with additional features
 */
public interface BlogPostComponent {
    void display();
    String getDescription();
}
