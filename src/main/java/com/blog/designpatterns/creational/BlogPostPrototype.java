package com.blog.designpatterns.creational;

import com.blog.model.BlogPost;
import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Pattern - BlogPostPrototype
 * Creates new objects by cloning existing ones
 */
public class BlogPostPrototype {
    private Map<String, BlogPost> prototypes = new HashMap<>();
    
    public BlogPostPrototype() {
        loadPrototypes();
    }
    
    private void loadPrototypes() {
        // Create standard blog post template
        BlogPost standardPost = new BlogPost();
        standardPost.setTitle("Standard Post Template");
        standardPost.setContent("This is a standard blog post template.");
        standardPost.addTag("General");
        prototypes.put("standard", standardPost);
        
        // Create technical post template
        BlogPost technicalPost = new BlogPost();
        technicalPost.setTitle("Technical Post Template");
        technicalPost.setContent("This is a technical blog post template with code examples.");
        technicalPost.addTag("Technical");
        technicalPost.addTag("Programming");
        technicalPost.addTag("Code");
        prototypes.put("technical", technicalPost);
        
        // Create tutorial post template
        BlogPost tutorialPost = new BlogPost();
        tutorialPost.setTitle("Tutorial Post Template");
        tutorialPost.setContent("Step-by-step tutorial template.");
        tutorialPost.addTag("Tutorial");
        tutorialPost.addTag("How-To");
        tutorialPost.addTag("Guide");
        prototypes.put("tutorial", tutorialPost);
    }
    
    public BlogPost createPost(String type) {
        BlogPost prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
    
    public void addPrototype(String key, BlogPost prototype) {
        prototypes.put(key, prototype);
    }
    
    public BlogPost getPrototype(String key) {
        return prototypes.get(key);
    }
}
