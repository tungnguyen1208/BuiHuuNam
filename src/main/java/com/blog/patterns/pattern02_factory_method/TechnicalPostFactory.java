package com.blog.patterns.pattern02_factory_method;

import com.blog.patterns.shared.BlogPost;

public class TechnicalPostFactory extends PostFactory {
    
    @Override
    public BlogPost createPost(String title, String content, String author) {
        BlogPost post = new BlogPost(title, content, author);
        post.setCategory("Technical");
        post.addTag("technical");
        post.addTag("programming");
        return post;
    }
}
