package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;

/**
 * Bridge Pattern - BlogRenderer
 * Separates abstraction (blog post) from implementation (rendering platform)
 */
public abstract class BlogRenderer {
    protected RenderingPlatform platform;
    
    protected BlogRenderer(RenderingPlatform platform) {
        this.platform = platform;
    }
    
    public abstract void render(BlogPost post);
}

/**
 * Refined abstraction for detailed rendering
 */
class DetailedBlogRenderer extends BlogRenderer {
    public DetailedBlogRenderer(RenderingPlatform platform) {
        super(platform);
    }
    
    @Override
    public void render(BlogPost post) {
        platform.renderTitle(post.getTitle());
        platform.renderAuthor(post.getAuthor());
        platform.renderDate(post.getPublishDate().toString());
        platform.renderContent(post.getContent());
        platform.renderTags(post.getTags().toString());
    }
}

/**
 * Refined abstraction for summary rendering
 */
class SummaryBlogRenderer extends BlogRenderer {
    public SummaryBlogRenderer(RenderingPlatform platform) {
        super(platform);
    }
    
    @Override
    public void render(BlogPost post) {
        platform.renderTitle(post.getTitle());
        platform.renderAuthor(post.getAuthor());
        String summary = post.getContent().length() > 100 
            ? post.getContent().substring(0, 100) + "..." 
            : post.getContent();
        platform.renderContent(summary);
    }
}

/**
 * Implementation interface
 */
interface RenderingPlatform {
    void renderTitle(String title);
    void renderAuthor(String author);
    void renderDate(String date);
    void renderContent(String content);
    void renderTags(String tags);
}

/**
 * Concrete implementation for HTML
 */
class HTMLPlatform implements RenderingPlatform {
    @Override
    public void renderTitle(String title) {
        System.out.println("<h1>" + title + "</h1>");
    }
    
    @Override
    public void renderAuthor(String author) {
        System.out.println("<p class='author'>By: " + author + "</p>");
    }
    
    @Override
    public void renderDate(String date) {
        System.out.println("<p class='date'>" + date + "</p>");
    }
    
    @Override
    public void renderContent(String content) {
        System.out.println("<div class='content'>" + content + "</div>");
    }
    
    @Override
    public void renderTags(String tags) {
        System.out.println("<div class='tags'>" + tags + "</div>");
    }
}

/**
 * Concrete implementation for Markdown
 */
class MarkdownPlatform implements RenderingPlatform {
    @Override
    public void renderTitle(String title) {
        System.out.println("# " + title);
    }
    
    @Override
    public void renderAuthor(String author) {
        System.out.println("**Author:** " + author);
    }
    
    @Override
    public void renderDate(String date) {
        System.out.println("**Date:** " + date);
    }
    
    @Override
    public void renderContent(String content) {
        System.out.println("\n" + content + "\n");
    }
    
    @Override
    public void renderTags(String tags) {
        System.out.println("*Tags:* " + tags);
    }
}

/**
 * Concrete implementation for Plain Text
 */
class PlainTextPlatform implements RenderingPlatform {
    @Override
    public void renderTitle(String title) {
        System.out.println(title.toUpperCase());
        System.out.println("=".repeat(title.length()));
    }
    
    @Override
    public void renderAuthor(String author) {
        System.out.println("By: " + author);
    }
    
    @Override
    public void renderDate(String date) {
        System.out.println("Published: " + date);
    }
    
    @Override
    public void renderContent(String content) {
        System.out.println("\n" + content + "\n");
    }
    
    @Override
    public void renderTags(String tags) {
        System.out.println("Tags: " + tags);
    }
}
