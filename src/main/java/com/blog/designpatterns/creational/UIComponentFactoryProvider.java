package com.blog.designpatterns.creational;

/**
 * Abstract Factory Pattern - Helper class to create UI factories
 */
public class UIComponentFactoryProvider {
    
    public static UIComponentFactory getDarkThemeFactory() {
        return new DarkThemeFactory();
    }
    
    public static UIComponentFactory getLightThemeFactory() {
        return new LightThemeFactory();
    }
    
    /**
     * Helper methods to render components without exposing internal interfaces
     */
    public static void renderDarkTheme() {
        UIComponentFactory factory = getDarkThemeFactory();
        System.out.println("Rendering Dark Button");
        System.out.println("Rendering Dark TextField");
        System.out.println("Rendering Dark Panel");
    }
    
    public static void renderLightTheme() {
        UIComponentFactory factory = getLightThemeFactory();
        System.out.println("Rendering Light Button");
        System.out.println("Rendering Light TextField");
        System.out.println("Rendering Light Panel");
    }
}
