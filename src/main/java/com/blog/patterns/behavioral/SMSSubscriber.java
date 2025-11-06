package com.blog.patterns.behavioral;

import com.blog.patterns.models.BlogSubscriber;

/**
 * Concrete Observer - SMS Subscriber
 */
public class SMSSubscriber implements BlogSubscriber {
    private String phoneNumber;
    
    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void update(String postTitle, String author) {
        System.out.println("[SMS to " + phoneNumber + "] New post: '" + postTitle + "' by " + author);
    }
}
