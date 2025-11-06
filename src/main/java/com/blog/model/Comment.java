package com.blog.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Model class representing a comment
 */
public class Comment {
    private String id;
    private String author;
    private String content;
    private Date timestamp;
    private List<Comment> replies;
    
    public Comment() {
        this.replies = new ArrayList<>();
    }
    
    public Comment(String id, String author, String content) {
        this();
        this.id = id;
        this.author = author;
        this.content = content;
        this.timestamp = new Date();
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    
    public List<Comment> getReplies() { return replies; }
    public void setReplies(List<Comment> replies) { this.replies = replies; }
    
    public void addReply(Comment reply) { this.replies.add(reply); }
    
    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", replies=" + replies.size() +
                '}';
    }
}
