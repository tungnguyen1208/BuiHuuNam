package com.blog.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Model class representing a blog post
 */
public class BlogPost implements Cloneable {
    private String id;
    private String title;
    private String content;
    private String author;
    private Date publishDate;
    private List<String> tags;
    private List<Comment> comments;
    
    public BlogPost() {
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }
    
    public BlogPost(String id, String title, String content, String author) {
        this();
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = new Date();
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public Date getPublishDate() { return publishDate; }
    public void setPublishDate(Date publishDate) { this.publishDate = publishDate; }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    
    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
    
    public void addTag(String tag) { this.tags.add(tag); }
    public void addComment(Comment comment) { this.comments.add(comment); }
    
    @Override
    public BlogPost clone() {
        try {
            BlogPost cloned = (BlogPost) super.clone();
            cloned.tags = new ArrayList<>(this.tags);
            cloned.comments = new ArrayList<>(this.comments);
            cloned.publishDate = this.publishDate != null ? (Date) this.publishDate.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    @Override
    public String toString() {
        return "BlogPost{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", tags=" + tags.size() +
                ", comments=" + comments.size() +
                '}';
    }
}
