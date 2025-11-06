package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;

/**
 * Decorator Pattern - BlogPostDecorator
 * Adds additional features to blog posts dynamically
 */
public abstract class BlogPostDecorator {
    protected BlogPost post;
    
    public BlogPostDecorator(BlogPost post) {
        this.post = post;
    }
    
    public abstract String getContent();
    public abstract String getTitle();
}

/**
 * Concrete decorator - Adds SEO metadata
 */
class SEODecorator extends BlogPostDecorator {
    private String metaDescription;
    private String keywords;
    
    public SEODecorator(BlogPost post, String metaDescription, String keywords) {
        super(post);
        this.metaDescription = metaDescription;
        this.keywords = keywords;
    }
    
    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!-- SEO Metadata -->\n");
        sb.append("<!-- Meta Description: ").append(metaDescription).append(" -->\n");
        sb.append("<!-- Keywords: ").append(keywords).append(" -->\n\n");
        sb.append(post.getContent());
        return sb.toString();
    }
    
    @Override
    public String getTitle() {
        return post.getTitle();
    }
}

/**
 * Concrete decorator - Adds social media sharing buttons
 */
class SocialMediaDecorator extends BlogPostDecorator {
    public SocialMediaDecorator(BlogPost post) {
        super(post);
    }
    
    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(post.getContent());
        sb.append("\n\n--- Share this post ---\n");
        sb.append("[Facebook] [Twitter] [LinkedIn] [Reddit]\n");
        return sb.toString();
    }
    
    @Override
    public String getTitle() {
        return post.getTitle();
    }
}

/**
 * Concrete decorator - Adds reading time estimation
 */
class ReadingTimeDecorator extends BlogPostDecorator {
    private static final int WORDS_PER_MINUTE = 200;
    
    public ReadingTimeDecorator(BlogPost post) {
        super(post);
    }
    
    @Override
    public String getContent() {
        return post.getContent();
    }
    
    @Override
    public String getTitle() {
        int wordCount = post.getContent().split("\\s+").length;
        int readingTime = Math.max(1, wordCount / WORDS_PER_MINUTE);
        return post.getTitle() + " [" + readingTime + " min read]";
    }
}

/**
 * Concrete decorator - Adds advertisement
 */
class AdDecorator extends BlogPostDecorator {
    private String adContent;
    
    public AdDecorator(BlogPost post, String adContent) {
        super(post);
        this.adContent = adContent;
    }
    
    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(post.getContent());
        sb.append("\n\n--- Advertisement ---\n");
        sb.append(adContent).append("\n");
        sb.append("--- End Advertisement ---\n");
        return sb.toString();
    }
    
    @Override
    public String getTitle() {
        return post.getTitle();
    }
}
