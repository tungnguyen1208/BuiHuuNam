package decorator;

public abstract class PostDecorator implements Post {
    protected Post decoratedPost;
    
    public PostDecorator(Post post) {
        this.decoratedPost = post;
    }
    
    @Override
    public String getDescription() {
        return decoratedPost.getDescription();
    }
    
    @Override
    public double getCost() {
        return decoratedPost.getCost();
    }
    
    @Override
    public void display() {
        decoratedPost.display();
    }
}
