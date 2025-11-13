package com.blog.patterns.pattern10_observer;

import com.blog.patterns.shared.BlogPost;

public class SMSSubscriber implements BlogSubscriber {
    private String phoneNumber;
    
    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("[SMS to " + phoneNumber + "] New post: " + post.getTitle());
    }
}
