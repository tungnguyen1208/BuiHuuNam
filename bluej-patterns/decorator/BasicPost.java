package decorator;

public class BasicPost implements Post {
    private String title;
    private String content;
    
    public BasicPost(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    @Override
    public String getDescription() {
        return "Basic Post: " + title;
    }
    
    @Override
    public double getCost() {
        return 0.0;
    }
    
    @Override
    public void display() {
        System.out.println(getDescription());
        System.out.println("Content: " + content);
        System.out.println("Cost: $" + getCost());
    }
}
