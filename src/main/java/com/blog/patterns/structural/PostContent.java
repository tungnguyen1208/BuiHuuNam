package com.blog.patterns.structural;

import com.blog.patterns.models.BlogPost;

/**
 * Proxy Pattern - Lazy Loading Blog Post Content
 * Interface for loading blog post content
 */
public interface PostContent {
    String getContent();
}
