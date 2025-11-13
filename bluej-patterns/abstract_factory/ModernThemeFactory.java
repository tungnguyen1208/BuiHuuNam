package abstract_factory;

/**
 * Concrete Factory - Tạo Modern theme components
 */
public class ModernThemeFactory implements ThemeFactory {
    
    @Override
    public Button createButton() {
        return new ModernButton();
    }
    
    @Override
    public Header createHeader() {
        return new ModernHeader();
    }
    
    @Override
    public Footer createFooter() {
        return new ModernFooter();
    }
}
