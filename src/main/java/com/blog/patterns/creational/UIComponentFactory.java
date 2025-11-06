package com.blog.patterns.creational;

/**
 * Abstract Factory Pattern - UI Component Factory
 * Provides an interface for creating families of related UI components
 */
public interface UIComponentFactory {
    Button createButton();
    Header createHeader();
    Footer createFooter();
}
