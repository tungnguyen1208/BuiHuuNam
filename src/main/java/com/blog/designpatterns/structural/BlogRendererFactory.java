package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;

/**
 * Bridge Pattern - Helper class to create renderers
 */
public class BlogRendererFactory {
    
    public static BlogRenderer createDetailedHTMLRenderer() {
        return new DetailedBlogRenderer(new HTMLPlatform());
    }
    
    public static BlogRenderer createSummaryHTMLRenderer() {
        return new SummaryBlogRenderer(new HTMLPlatform());
    }
    
    public static BlogRenderer createDetailedMarkdownRenderer() {
        return new DetailedBlogRenderer(new MarkdownPlatform());
    }
    
    public static BlogRenderer createSummaryMarkdownRenderer() {
        return new SummaryBlogRenderer(new MarkdownPlatform());
    }
    
    public static BlogRenderer createDetailedPlainTextRenderer() {
        return new DetailedBlogRenderer(new PlainTextPlatform());
    }
}
