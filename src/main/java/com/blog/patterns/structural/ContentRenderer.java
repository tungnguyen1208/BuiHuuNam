package com.blog.patterns.structural;

/**
 * Adapter Pattern - Content Format Adapter
 * Converts content from different formats to a common format
 */
public interface ContentRenderer {
    String render(String content);
}
