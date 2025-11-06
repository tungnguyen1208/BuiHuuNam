package com.blog.patterns.behavioral;

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
