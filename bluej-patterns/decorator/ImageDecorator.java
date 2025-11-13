package decorator;

public class ImageDecorator extends PostDecorator {
    public ImageDecorator(Post post) {
        super(post);
    }
    
    @Override
    public String getDescription() {
        return decoratedPost.getDescription() + " + Images";
    }
    
    @Override
    public double getCost() {
        return decoratedPost.getCost() + 5.0;
    }
    
    @Override
    public void display() {
        decoratedPost.display();
        System.out.println("  [Images added - $5.0]");
    }
}
