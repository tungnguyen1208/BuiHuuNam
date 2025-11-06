package com.blog.patterns.structural;

/**
 * Concrete Decorator - Adds comment functionality
 */
public class CommentDecorator extends PostDecorator {
    private int commentCount;
    
    public CommentDecorator(BlogPostComponent post, int commentCount) {
        super(post);
        this.commentCount = commentCount;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Comments: " + commentCount + " comments");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Comments";
    }
}
