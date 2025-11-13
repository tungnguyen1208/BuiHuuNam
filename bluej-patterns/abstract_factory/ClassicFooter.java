package abstract_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete Product - Classic Footer
 */
public class ClassicFooter implements Footer {
    private String copyright;
    private Map<String, String> socialLinks;
    
    public ClassicFooter() {
        this.copyright = "Copyright 2024";
        this.socialLinks = new HashMap<>();
    }
    
    @Override
    public void setCopyright(String text) {
        this.copyright = text;
    }
    
    @Override
    public void addSocialLink(String platform, String url) {
        socialLinks.put(platform, url);
    }
    
    @Override
    public void render() {
        System.out.println("================================");
        System.out.println("    " + copyright);
        System.out.print("    Links: ");
        for (String platform : socialLinks.keySet()) {
            System.out.print("[" + platform + "] ");
        }
        System.out.println("\n================================");
    }
    
    @Override
    public String getStyle() {
        return "Classic: Light background, borders, text links";
    }
}
