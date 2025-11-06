package com.blog.designpatterns.behavioral;

import com.blog.model.BlogPost;
import com.blog.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern - BlogSubscriber
 * Notifies subscribers when new blog posts are published
 */
interface BlogObserver {
    void update(BlogPost post);
}

/**
 * Subject - Blog that publishers notify observers
 */
class Blog {
    private List<BlogObserver> subscribers = new ArrayList<>();
    private List<BlogPost> posts = new ArrayList<>();
    
    public void subscribe(BlogObserver observer) {
        subscribers.add(observer);
        System.out.println("New subscriber added. Total subscribers: " + subscribers.size());
    }
    
    public void unsubscribe(BlogObserver observer) {
        subscribers.remove(observer);
        System.out.println("Subscriber removed. Total subscribers: " + subscribers.size());
    }
    
    public void publishPost(BlogPost post) {
        posts.add(post);
        System.out.println("Publishing new post: " + post.getTitle());
        notifySubscribers(post);
    }
    
    private void notifySubscribers(BlogPost post) {
        for (BlogObserver observer : subscribers) {
            observer.update(post);
        }
    }
    
    public List<BlogPost> getPosts() {
        return new ArrayList<>(posts);
    }
}

/**
 * Concrete Observer - Email subscriber
 */
class EmailSubscriber implements BlogObserver {
    private String email;
    private String name;
    
    public EmailSubscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("Sending email to " + email + ":");
        System.out.println("  Subject: New post - " + post.getTitle());
        System.out.println("  To: " + name);
        System.out.println("  Preview: " + getPreview(post.getContent()));
    }
    
    private String getPreview(String content) {
        return content.length() > 50 ? content.substring(0, 50) + "..." : content;
    }
}

/**
 * Concrete Observer - SMS subscriber
 */
class SMSSubscriber implements BlogObserver {
    private String phoneNumber;
    private String name;
    
    public SMSSubscriber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("Sending SMS to " + phoneNumber + ":");
        System.out.println("  Hi " + name + ", new blog post: " + post.getTitle());
    }
}

/**
 * Concrete Observer - Push notification subscriber
 */
class PushNotificationSubscriber implements BlogObserver {
    private String deviceId;
    private User user;
    
    public PushNotificationSubscriber(User user, String deviceId) {
        this.user = user;
        this.deviceId = deviceId;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("Sending push notification to device " + deviceId + ":");
        System.out.println("  User: " + user.getUsername());
        System.out.println("  Title: " + post.getTitle());
        System.out.println("  Author: " + post.getAuthor());
    }
}

/**
 * Concrete Observer - RSS feed updater
 */
class RSSFeedSubscriber implements BlogObserver {
    private String feedUrl;
    
    public RSSFeedSubscriber(String feedUrl) {
        this.feedUrl = feedUrl;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("Updating RSS feed at " + feedUrl);
        System.out.println("  Adding new entry: " + post.getTitle());
        System.out.println("  Publication date: " + post.getPublishDate());
    }
}
