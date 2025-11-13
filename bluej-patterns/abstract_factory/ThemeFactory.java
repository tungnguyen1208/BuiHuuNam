package abstract_factory;

/**
 * Abstract Factory - Tạo family of related objects
 */
public interface ThemeFactory {
    Button createButton();
    Header createHeader();
    Footer createFooter();
}
