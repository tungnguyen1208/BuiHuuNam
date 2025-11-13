package decorator;

public class VideoDecorator extends PostDecorator {
    public VideoDecorator(Post post) {
        super(post);
    }
    
    @Override
    public String getDescription() {
        return decoratedPost.getDescription() + " + Video";
    }
    
    @Override
    public double getCost() {
        return decoratedPost.getCost() + 10.0;
    }
    
    @Override
    public void display() {
        decoratedPost.display();
        System.out.println("  [Video added - $10.0]");
    }
}
