package com.blog.designpatterns.creational;

import com.blog.model.BlogPost;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Builder Pattern - BlogPostBuilder
 * Constructs complex BlogPost objects step by step
 */
public class BlogPostBuilder {
    private String id;
    private String title;
    private String content;
    private String author;
    private Date publishDate;
    private List<String> tags;
    
    public BlogPostBuilder() {
        this.tags = new ArrayList<>();
        this.publishDate = new Date();
    }
    
    public BlogPostBuilder withId(String id) {
        this.id = id;
        return this;
    }
    
    public BlogPostBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    
    public BlogPostBuilder withContent(String content) {
        this.content = content;
        return this;
    }
    
    public BlogPostBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }
    
    public BlogPostBuilder withPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }
    
    public BlogPostBuilder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }
    
    public BlogPostBuilder withTags(List<String> tags) {
        this.tags = new ArrayList<>(tags);
        return this;
    }
    
    public BlogPost build() {
        BlogPost post = new BlogPost();
        post.setId(id != null ? id : "POST-" + System.currentTimeMillis());
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setPublishDate(publishDate);
        post.setTags(tags);
        return post;
    }
    
    public static BlogPostBuilder builder() {
        return new BlogPostBuilder();
    }
}
