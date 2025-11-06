package com.blog.designpatterns.structural;

import com.blog.model.BlogPost;
import java.util.List;
import java.util.ArrayList;

/**
 * Adapter Pattern - LegacyBlogAdapter
 * Adapts legacy blog system to work with new system
 */
public class LegacyBlogAdapter implements ModernBlogInterface {
    private LegacyBlogSystem legacySystem;
    
    public LegacyBlogAdapter(LegacyBlogSystem legacySystem) {
        this.legacySystem = legacySystem;
    }
    
    @Override
    public BlogPost getPostById(String id) {
        LegacyPost legacyPost = legacySystem.fetchPost(Integer.parseInt(id));
        return convertLegacyPost(legacyPost);
    }
    
    @Override
    public List<BlogPost> getAllPosts() {
        List<LegacyPost> legacyPosts = legacySystem.getAllArticles();
        List<BlogPost> posts = new ArrayList<>();
        for (LegacyPost legacyPost : legacyPosts) {
            posts.add(convertLegacyPost(legacyPost));
        }
        return posts;
    }
    
    @Override
    public void savePost(BlogPost post) {
        LegacyPost legacyPost = convertToLegacyPost(post);
        legacySystem.storeArticle(legacyPost);
    }
    
    private BlogPost convertLegacyPost(LegacyPost legacyPost) {
        BlogPost post = new BlogPost();
        post.setId(String.valueOf(legacyPost.getArticleId()));
        post.setTitle(legacyPost.getHeadline());
        post.setContent(legacyPost.getBody());
        post.setAuthor(legacyPost.getWriterName());
        return post;
    }
    
    private LegacyPost convertToLegacyPost(BlogPost post) {
        LegacyPost legacyPost = new LegacyPost();
        legacyPost.setArticleId(Integer.parseInt(post.getId()));
        legacyPost.setHeadline(post.getTitle());
        legacyPost.setBody(post.getContent());
        legacyPost.setWriterName(post.getAuthor());
        return legacyPost;
    }
}

/**
 * Modern blog interface
 */
interface ModernBlogInterface {
    BlogPost getPostById(String id);
    List<BlogPost> getAllPosts();
    void savePost(BlogPost post);
}

/**
 * Legacy blog system with different method names and data types
 */
class LegacyBlogSystem {
    private List<LegacyPost> articles = new ArrayList<>();
    
    public LegacyPost fetchPost(int articleId) {
        for (LegacyPost post : articles) {
            if (post.getArticleId() == articleId) {
                return post;
            }
        }
        return null;
    }
    
    public List<LegacyPost> getAllArticles() {
        return new ArrayList<>(articles);
    }
    
    public void storeArticle(LegacyPost post) {
        articles.add(post);
    }
}

/**
 * Legacy post structure
 */
class LegacyPost {
    private int articleId;
    private String headline;
    private String body;
    private String writerName;
    
    public int getArticleId() { return articleId; }
    public void setArticleId(int articleId) { this.articleId = articleId; }
    
    public String getHeadline() { return headline; }
    public void setHeadline(String headline) { this.headline = headline; }
    
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    
    public String getWriterName() { return writerName; }
    public void setWriterName(String writerName) { this.writerName = writerName; }
}
