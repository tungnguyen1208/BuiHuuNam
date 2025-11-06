package com.blog.designpatterns.structural;

/**
 * Composite Pattern - Factory for creating comment structures
 */
public class CommentFactory {
    
    public static CommentComponent createSingleComment(String id, String author, String content) {
        return new SingleComment(id, author, content);
    }
    
    public static CommentComponent createCommentThread(String id, String author, String content) {
        return new CommentThread(id, author, content);
    }
}
