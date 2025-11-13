package abstract_factory;

/**
 * Abstract Product - Footer
 */
public interface Footer extends UIComponent {
    void setCopyright(String text);
    void addSocialLink(String platform, String url);
}
