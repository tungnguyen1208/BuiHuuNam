package abstract_factory;

/**
 * Concrete Product - Modern Button
 */
public class ModernButton implements Button {
    private String label;
    
    public ModernButton() {
        this.label = "Click Me";
    }
    
    @Override
    public void click() {
        System.out.println("Modern button clicked: " + label);
    }
    
    @Override
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public void render() {
        System.out.println("Rendering modern button: [" + label + "]");
    }
    
    @Override
    public String getStyle() {
        return "Modern: Flat design, rounded corners, shadow effects";
    }
}
