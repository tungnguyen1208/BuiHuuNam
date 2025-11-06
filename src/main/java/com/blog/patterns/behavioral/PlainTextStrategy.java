package com.blog.patterns.behavioral;

/**
 * Concrete Strategy - Plain Text Rendering
 */
public class PlainTextStrategy implements RenderingStrategy {
    @Override
    public String render(String content) {
        System.out.println("[Strategy] Rendering as plain text");
        return content;
    }
}
