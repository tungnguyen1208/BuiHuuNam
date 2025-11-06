package com.blog.patterns.behavioral;

/**
 * Concrete Strategy - JSON Rendering
 */
public class JSONRenderingStrategy implements RenderingStrategy {
    @Override
    public String render(String content) {
        System.out.println("[Strategy] Rendering as JSON");
        return "{\"content\": \"" + content + "\"}";
    }
}
