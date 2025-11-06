package com.blog.patterns.structural;

/**
 * Real Subject - Actual post content loaded from database
 */
public class RealPostContent implements PostContent {
    private String postId;
    private String content;
    
    public RealPostContent(String postId) {
        this.postId = postId;
        loadContentFromDatabase();
    }
    
    private void loadContentFromDatabase() {
        // Simulate expensive database operation
        System.out.println("[Real Post] Loading content from database for post: " + postId);
        try {
            Thread.sleep(1000); // Simulate loading delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = "This is the full content of post " + postId + " loaded from database...";
    }
    
    @Override
    public String getContent() {
        return content;
    }
}
