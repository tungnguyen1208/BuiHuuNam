package com.blog.patterns.structural;

/**
 * Adapter - Adapts MarkdownParser to ContentRenderer interface
 */
public class MarkdownAdapter implements ContentRenderer {
    private MarkdownParser markdownParser;
    
    public MarkdownAdapter() {
        this.markdownParser = new MarkdownParser();
    }
    
    @Override
    public String render(String content) {
        System.out.println("[Adapter] Converting Markdown to HTML");
        return markdownParser.parseMarkdown(content);
    }
}
