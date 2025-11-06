package com.blog.designpatterns.behavioral;

import com.blog.model.BlogPost;
import com.blog.model.User;

/**
 * Observer Pattern - Factory and facade for blog subscription
 */
public class BlogSubscriberFacade {
    private Blog blog;
    
    public BlogSubscriberFacade() {
        this.blog = new Blog();
    }
    
    public void subscribeEmail(String name, String email) {
        blog.subscribe(new EmailSubscriber(name, email));
    }
    
    public void subscribeSMS(String name, String phoneNumber) {
        blog.subscribe(new SMSSubscriber(name, phoneNumber));
    }
    
    public void subscribePushNotification(User user, String deviceId) {
        blog.subscribe(new PushNotificationSubscriber(user, deviceId));
    }
    
    public void subscribeRSSFeed(String feedUrl) {
        blog.subscribe(new RSSFeedSubscriber(feedUrl));
    }
    
    public void unsubscribe(BlogObserver observer) {
        blog.unsubscribe(observer);
    }
    
    public void publishPost(BlogPost post) {
        blog.publishPost(post);
    }
}
