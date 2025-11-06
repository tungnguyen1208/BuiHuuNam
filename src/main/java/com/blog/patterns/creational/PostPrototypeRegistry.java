package com.blog.patterns.creational;

import com.blog.patterns.models.BlogPost;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Prototype Pattern - PostPrototypeRegistry
 * Creates new objects by cloning existing prototypes
 */
public class PostPrototypeRegistry {
    private Map<String, BlogPost> prototypes = new HashMap<>();
    
    public PostPrototypeRegistry() {
        loadPrototypes();
    }
    
    private void loadPrototypes() {
        // Technical post template
        BlogPost technicalPrototype = new BlogPost();
        technicalPrototype.setCategory("Technical");
        technicalPrototype.addTag("programming");
        technicalPrototype.addTag("tutorial");
        prototypes.put("technical", technicalPrototype);
        
        // News post template
        BlogPost newsPrototype = new BlogPost();
        newsPrototype.setCategory("News");
        newsPrototype.addTag("updates");
        newsPrototype.addTag("announcements");
        prototypes.put("news", newsPrototype);
    }
    
    public BlogPost createPost(String type, String title, String content, String author) {
        BlogPost prototype = prototypes.get(type);
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown prototype type: " + type);
        }
        
        BlogPost clonedPost = prototype.clone();
        clonedPost.setId(UUID.randomUUID().toString());
        clonedPost.setTitle(title);
        clonedPost.setContent(content);
        clonedPost.setAuthor(author);
        
        System.out.println("Created post from prototype: " + type);
        return clonedPost;
    }
    
    public void addPrototype(String key, BlogPost prototype) {
        prototypes.put(key, prototype);
    }
}
