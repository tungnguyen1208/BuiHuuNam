package abstract_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete Product - Modern Footer
 */
public class ModernFooter implements Footer {
    private String copyright;
    private Map<String, String> socialLinks;
    
    public ModernFooter() {
        this.copyright = "© 2024 My Blog";
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
        System.out.println("=== Modern Footer ===");
        System.out.println(copyright);
        System.out.print("Social: ");
        for (String platform : socialLinks.keySet()) {
            System.out.print(platform + " ");
        }
        System.out.println();
    }
    
    @Override
    public String getStyle() {
        return "Modern: Dark theme, centered text, icon links";
    }
}
