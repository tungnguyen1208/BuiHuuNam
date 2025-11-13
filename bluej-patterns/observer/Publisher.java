package observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers;
    private String blogName;
    
    public Publisher(String blogName) {
        this.blogName = blogName;
        this.subscribers = new ArrayList<>();
    }
    
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " subscribed to " + blogName);
    }
    
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " unsubscribed from " + blogName);
    }
    
    public void publishPost(String title, String content) {
        System.out.println("\n=== Publishing: " + title + " ===");
        notifySubscribers(title, content);
    }
    
    private void notifySubscribers(String title, String content) {
        System.out.println("\nNotifying " + subscribers.size() + " subscribers...");
        for (Subscriber subscriber : subscribers) {
            subscriber.update(title, content);
        }
    }
}
