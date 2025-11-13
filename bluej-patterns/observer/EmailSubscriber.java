package observer;

public class EmailSubscriber implements Subscriber {
    private String name;
    private String email;
    
    public EmailSubscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public void update(String postTitle, String postContent) {
        System.out.println("\n[Email to " + email + "]");
        System.out.println("Hi " + name + ",");
        System.out.println("New post: " + postTitle);
        System.out.println("Preview: " + postContent.substring(0, Math.min(50, postContent.length())) + "...");
    }
    
    @Override
    public String getName() {
        return name;
    }
}
