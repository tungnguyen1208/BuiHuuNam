package com.blog.patterns.pattern11_strategy;

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
