package com.blog.patterns.behavioral;

import com.blog.patterns.models.BlogSubscriber;

/**
 * Concrete Observer - Email Subscriber
 */
public class EmailSubscriber implements BlogSubscriber {
    private String email;
    
    public EmailSubscriber(String email) {
        this.email = email;
    }
    
    @Override
    public void update(String postTitle, String author) {
        System.out.println("[Email to " + email + "] New post: '" + postTitle + "' by " + author);
    }
}
