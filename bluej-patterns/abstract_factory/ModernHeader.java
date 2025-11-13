package abstract_factory;

/**
 * Concrete Product - Modern Header
 */
public class ModernHeader implements Header {
    private String title;
    private String logoPath;
    
    public ModernHeader() {
        this.title = "My Blog";
        this.logoPath = "logo.png";
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public void setLogo(String logoPath) {
        this.logoPath = logoPath;
    }
    
    @Override
    public void render() {
        System.out.println("=== Modern Header ===");
        System.out.println("Logo: " + logoPath);
        System.out.println("Title: " + title);
    }
    
    @Override
    public String getStyle() {
        return "Modern: Minimalist, gradient background, sticky navigation";
    }
}
