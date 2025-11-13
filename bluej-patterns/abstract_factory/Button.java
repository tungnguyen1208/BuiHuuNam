package abstract_factory;

/**
 * Abstract Product - Button
 */
public interface Button extends UIComponent {
    void click();
    void setLabel(String label);
}
