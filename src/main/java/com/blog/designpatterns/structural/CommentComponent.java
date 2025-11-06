package com.blog.designpatterns.structural;

import com.blog.model.Comment;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern - CommentComponent
 * Treats individual comments and comment trees uniformly
 */
public abstract class CommentComponent {
    protected String id;
    protected String author;
    protected String content;
    
    public abstract void display(int depth);
    public abstract int getCommentCount();
    
    public void add(CommentComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }
    
    public void remove(CommentComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }
    
    public CommentComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a leaf component");
    }
}

/**
 * Leaf - Individual comment
 */
class SingleComment extends CommentComponent {
    public SingleComment(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
    
    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "- Comment by " + author + ": " + content);
    }
    
    @Override
    public int getCommentCount() {
        return 1;
    }
}

/**
 * Composite - Comment thread with replies
 */
class CommentThread extends CommentComponent {
    private List<CommentComponent> children = new ArrayList<>();
    
    public CommentThread(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
    
    @Override
    public void add(CommentComponent component) {
        children.add(component);
    }
    
    @Override
    public void remove(CommentComponent component) {
        children.remove(component);
    }
    
    @Override
    public CommentComponent getChild(int index) {
        return children.get(index);
    }
    
    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "+ Comment by " + author + ": " + content);
        for (CommentComponent child : children) {
            child.display(depth + 1);
        }
    }
    
    @Override
    public int getCommentCount() {
        int count = 1; // Count this comment
        for (CommentComponent child : children) {
            count += child.getCommentCount();
        }
        return count;
    }
}
