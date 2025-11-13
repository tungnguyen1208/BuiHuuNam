package prototype;

import java.util.HashMap;
import java.util.Map;

public class PostRegistry {
    private Map<String, BlogPost> templates;
    
    public PostRegistry() {
        templates = new HashMap<>();
        loadTemplates();
    }
    
    private void loadTemplates() {
        templates.put("technical", new BlogPost("technical"));
        templates.put("news", new BlogPost("news"));
        templates.put("lifestyle", new BlogPost("lifestyle"));
    }
    
    public BlogPost getTemplate(String type) {
        BlogPost prototype = templates.get(type);
        return prototype != null ? prototype.clone() : null;
    }
    
    public void addTemplate(String type, BlogPost post) {
        templates.put(type, post);
    }
}
