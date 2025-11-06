package com.blog.patterns.creational;

/**
 * Modern Theme UI Factory
 */
public class ModernUIFactory implements UIComponentFactory {
    
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
    
    static class ModernButton implements Button {
        @Override
        public void render() {
            System.out.println("[Modern Button] Flat design with gradient");
        }
    }
    
    static class ModernHeader implements Header {
        @Override
        public void render() {
            System.out.println("[Modern Header] Minimalist header with search bar");
        }
    }
    
    static class ModernFooter implements Footer {
        @Override
        public void render() {
            System.out.println("[Modern Footer] Social media links and newsletter signup");
        }
    }
}
