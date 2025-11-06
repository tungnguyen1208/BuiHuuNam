package com.blog.patterns.structural;

/**
 * Plain HTML Renderer
 */
public class HTMLRenderer implements ContentRenderer {
    @Override
    public String render(String content) {
        System.out.println("[HTML Renderer] Rendering plain HTML");
        return "<div>" + content + "</div>";
    }
}
