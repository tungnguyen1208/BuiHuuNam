package com.blog.patterns.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlogPost implements Cloneable {
    private String id;
    private String title;
    private String content;
    private String author;
    private String category;
    private List<String> tags;
    
    public BlogPost() {
        this.id = UUID.randomUUID().toString();
        this.tags = new ArrayList<>();
    }
    
    public BlogPost(String title, String content, String author) {
        this();
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    @Override
    public BlogPost clone() {
        try {
            BlogPost cloned = (BlogPost) super.clone();
            cloned.id = UUID.randomUUID().toString();
            cloned.tags = new ArrayList<>(this.tags);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public void addTag(String tag) { this.tags.add(tag); }
    
    @Override
    public String toString() {
        return "BlogPost{id='" + id + "', title='" + title + "', author='" + author + "'}";
    }
}
