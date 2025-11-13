package observer;

public class SMSSubscriber implements Subscriber {
    private String name;
    private String phone;
    
    public SMSSubscriber(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    @Override
    public void update(String postTitle, String postContent) {
        System.out.println("\n[SMS to " + phone + "]");
        System.out.println(name + ": New post '" + postTitle + "'");
    }
    
    @Override
    public String getName() {
        return name;
    }
}
