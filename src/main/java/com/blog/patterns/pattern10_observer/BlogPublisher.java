package com.blog.patterns.pattern10_observer;

import com.blog.patterns.shared.*;
import com.blog.patterns.shared.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern - Blog Publisher
 * Notifies subscribers when new posts are published
 */
public class BlogPublisher {
    private List<BlogSubscriber> subscribers = new ArrayList<>();
    
    public void subscribe(BlogSubscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("New subscriber added");
    }
    
    public void unsubscribe(BlogSubscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("Subscriber removed");
    }
    
    public void publishPost(BlogPost post) {
        System.out.println("\n=== Publishing new post: " + post.getTitle() + " ===");
        notifySubscribers(post);
    }
    
    private void notifySubscribers(BlogPost post) {
        System.out.println("[Observer] Notifying " + subscribers.size() + " subscribers...");
        for (BlogSubscriber subscriber : subscribers) {
            subscriber.update(post);
        }
    }
}
