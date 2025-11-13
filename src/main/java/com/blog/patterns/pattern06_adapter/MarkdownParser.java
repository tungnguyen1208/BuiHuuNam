package com.blog.patterns.pattern06_adapter;

/**
 * Legacy Markdown Parser - Adaptee
 */
public class MarkdownParser {
    public String parseMarkdown(String markdown) {
        // Simulated markdown parsing
        return markdown
            .replace("# ", "<h1>")
            .replace("## ", "<h2>")
            .replace("**", "<b>")
            .replace("*", "<i>");
    }
}
