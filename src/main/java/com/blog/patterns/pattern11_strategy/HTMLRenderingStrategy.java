package com.blog.patterns.pattern11_strategy;

/**
 * Concrete Strategy - HTML Rendering
 */
public class HTMLRenderingStrategy implements RenderingStrategy {
    @Override
    public String render(String content) {
        System.out.println("[Strategy] Rendering as HTML");
        return "<html><body><p>" + content + "</p></body></html>";
    }
}
