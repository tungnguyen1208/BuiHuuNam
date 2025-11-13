package com.blog.patterns.pattern07_decorator;

/**
 * Concrete Decorator - Adds like functionality
 */
public class LikeDecorator extends PostDecorator {
    private int likeCount;
    
    public LikeDecorator(BlogPostComponent post, int likeCount) {
        super(post);
        this.likeCount = likeCount;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Likes: " + likeCount + " likes");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Likes";
    }
}
