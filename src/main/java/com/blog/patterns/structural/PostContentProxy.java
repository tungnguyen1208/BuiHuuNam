package com.blog.patterns.structural;

/**
 * Proxy - Lazy loading proxy for post content
 */
public class PostContentProxy implements PostContent {
    private String postId;
    private RealPostContent realPostContent;
    
    public PostContentProxy(String postId) {
        this.postId = postId;
    }
    
    @Override
    public String getContent() {
        // Lazy initialization - only load when needed
        if (realPostContent == null) {
            System.out.println("[Proxy] First access - loading content...");
            realPostContent = new RealPostContent(postId);
        } else {
            System.out.println("[Proxy] Content already loaded - returning cached version");
        }
        return realPostContent.getContent();
    }
}
