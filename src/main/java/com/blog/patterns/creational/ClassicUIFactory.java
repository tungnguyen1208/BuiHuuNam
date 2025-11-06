package com.blog.patterns.creational;

/**
 * Classic Theme UI Factory
 */
public class ClassicUIFactory implements UIComponentFactory {
    
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
    
    static class ClassicButton implements Button {
        @Override
        public void render() {
            System.out.println("[Classic Button] Traditional button with border");
        }
    }
    
    static class ClassicHeader implements Header {
        @Override
        public void render() {
            System.out.println("[Classic Header] Traditional header with navigation menu");
        }
    }
    
    static class ClassicFooter implements Footer {
        @Override
        public void render() {
            System.out.println("[Classic Footer] Copyright and contact information");
        }
    }
}
