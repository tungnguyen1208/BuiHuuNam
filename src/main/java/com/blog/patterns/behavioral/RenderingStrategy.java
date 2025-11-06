package com.blog.patterns.behavioral;

/**
 * Strategy Pattern - Content Rendering Strategy
 * Defines different algorithms for rendering blog content
 */
public interface RenderingStrategy {
    String render(String content);
}
