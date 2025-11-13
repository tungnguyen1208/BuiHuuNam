package com.blog.patterns.pattern10_observer;

import com.blog.patterns.shared.BlogPost;

public class EmailSubscriber implements BlogSubscriber {
    private String email;
    
    public EmailSubscriber(String email) {
        this.email = email;
    }
    
    @Override
    public void update(BlogPost post) {
        System.out.println("[Email to " + email + "] New post: '" + 
            post.getTitle() + "' by " + post.getAuthor());
    }
}
