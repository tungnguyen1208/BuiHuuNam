package com.blog.patterns.structural;

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
