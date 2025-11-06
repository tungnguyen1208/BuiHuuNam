package com.blog.designpatterns.creational;

/**
 * Abstract Factory Pattern - UIComponentFactory
 * Creates families of related UI components for different themes
 */
public interface UIComponentFactory {
    Button createButton();
    TextField createTextField();
    Panel createPanel();
}

interface Button {
    void render();
}

interface TextField {
    void render();
}

interface Panel {
    void render();
}

/**
 * Factory for Dark Theme UI components
 */
class DarkThemeFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    
    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }
    
    @Override
    public Panel createPanel() {
        return new DarkPanel();
    }
}

/**
 * Factory for Light Theme UI components
 */
class LightThemeFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }
    
    @Override
    public TextField createTextField() {
        return new LightTextField();
    }
    
    @Override
    public Panel createPanel() {
        return new LightPanel();
    }
}

// Dark Theme Components
class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Dark TextField");
    }
}

class DarkPanel implements Panel {
    @Override
    public void render() {
        System.out.println("Rendering Dark Panel");
    }
}

// Light Theme Components
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Light TextField");
    }
}

class LightPanel implements Panel {
    @Override
    public void render() {
        System.out.println("Rendering Light Panel");
    }
}
