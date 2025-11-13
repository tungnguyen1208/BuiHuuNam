package com.blog.patterns.pattern02_factory_method;

import com.blog.patterns.shared.BlogPost;

public class LifestylePostFactory extends PostFactory {
    
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(title, content, author);
        post.setCategory("Lifestyle");
        post.addTag("lifestyle");
        post.addTag("health");
        return post;
    }
}
