package abstract_factory;

/**
 * Concrete Factory - Tạo Classic theme components
 */
public class ClassicThemeFactory implements ThemeFactory {
    
    @Override
    public Button createButton() {
        return new ClassicButton();
    }
    
    @Override
    public Header createHeader() {
        return new ClassicHeader();
    }
    
    @Override
    public Footer createFooter() {
        return new ClassicFooter();
    }
}
