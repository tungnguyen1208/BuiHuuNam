package abstract_factory;

/**
 * Concrete Product - Classic Button
 */
public class ClassicButton implements Button {
    private String label;
    
    public ClassicButton() {
        this.label = "Submit";
    }
    
    @Override
    public void click() {
        System.out.println("Classic button clicked: " + label);
    }
    
    @Override
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public void render() {
        System.out.println("Rendering classic button: [ " + label + " ]");
    }
    
    @Override
    public String getStyle() {
        return "Classic: 3D beveled edges, gradient fill, bold text";
    }
}
