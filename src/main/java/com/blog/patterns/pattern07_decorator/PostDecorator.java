package com.blog.patterns.pattern07_decorator;

/**
 * Abstract Decorator
 */
public abstract class PostDecorator implements BlogPostComponent {
    protected BlogPostComponent decoratedPost;
    
    public PostDecorator(BlogPostComponent post) {
        this.decoratedPost = post;
    }
    
    @Override
    public void display() {
        decoratedPost.display();
    }
    
    @Override
    public String getDescription() {
        return decoratedPost.getDescription();
    }
}
