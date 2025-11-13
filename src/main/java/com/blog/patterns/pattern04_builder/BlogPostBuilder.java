package com.blog.patterns.pattern04_builder;

import com.blog.patterns.shared.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Builder Pattern - BlogPostBuilder
 * Constructs complex BlogPost objects step by step
 */
public class BlogPostBuilder {
    private String id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime publishDate;
    private List<String> tags;
    private String category;
    
    public BlogPostBuilder() {
        this.id = UUID.randomUUID().toString();
        this.tags = new ArrayList<>();
        this.publishDate = LocalDateTime.now();
    }
    
    public BlogPostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    
    public BlogPostBuilder setContent(String content) {
        this.content = content;
        return this;
    }
    
    public BlogPostBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }
    
    public BlogPostBuilder setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
        return this;
    }
    
    public BlogPostBuilder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }
    
    public BlogPostBuilder setCategory(String category) {
        this.category = category;
        return this;
    }
    
    public BlogPost build() {
        BlogPost post = new BlogPost();
        post.setId(this.id);
        post.setTitle(this.title);
        post.setContent(this.content);
        post.setAuthor(this.author);
        // post.setPublishDate(this.publishDate); // Not in shared BlogPost
        post.setTags(new ArrayList<>(this.tags));
        post.setCategory(this.category);
        return post;
    }
}
