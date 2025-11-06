package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;

/**
 * Decorator Pattern - Factory for creating decorated blog posts
 */
public class BlogPostDecoratorFactory {
    
    public static BlogPostDecorator withSEO(BlogPost post, String metaDescription, String keywords) {
        return new SEODecorator(post, metaDescription, keywords);
    }
    
    public static BlogPostDecorator withSocialMedia(BlogPost post) {
        return new SocialMediaDecorator(post);
    }
    
    public static BlogPostDecorator withReadingTime(BlogPost post) {
        return new ReadingTimeDecorator(post);
    }
    
    public static BlogPostDecorator withAd(BlogPost post, String adContent) {
        return new AdDecorator(post, adContent);
    }
}
