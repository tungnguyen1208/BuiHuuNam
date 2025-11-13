package abstract_factory;

/**
 * Client class sử dụng Abstract Factory
 */
public class BlogPage {
    private Button submitButton;
    private Header pageHeader;
    private Footer pageFooter;
    
    public BlogPage(ThemeFactory factory) {
        this.submitButton = factory.createButton();
        this.pageHeader = factory.createHeader();
        this.pageFooter = factory.createFooter();
    }
    
    public void setupPage() {
        pageHeader.setTitle("Design Patterns Blog");
        pageHeader.setLogo("blog-logo.png");
        
        submitButton.setLabel("Publish Post");
        
        pageFooter.setCopyright("© 2024 Design Patterns Blog");
        pageFooter.addSocialLink("Facebook", "fb.com/blog");
        pageFooter.addSocialLink("Twitter", "twitter.com/blog");
    }
    
    public void render() {
        System.out.println("\n=== Rendering Blog Page ===");
        pageHeader.render();
        System.out.println("\n--- Main Content ---");
        submitButton.render();
        System.out.println("\n");
        pageFooter.render();
    }
    
    public void showStyles() {
        System.out.println("\n=== Theme Styles ===");
        System.out.println("Header: " + pageHeader.getStyle());
        System.out.println("Button: " + submitButton.getStyle());
        System.out.println("Footer: " + pageFooter.getStyle());
    }
}
