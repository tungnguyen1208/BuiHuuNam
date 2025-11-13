package com.blog.patterns.pattern06_adapter;

import com.blog.patterns.shared.*;

/**
 * Demo class for Adapter Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                            ADAPTER                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Chuyển đổi interface của class thành interface khác mà client mong đợi");
        System.out.println("English: Converts the interface of a class into another interface clients expect\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        ContentRenderer renderer = new MarkdownAdapter();
        String html = renderer.render("# Markdown Content\n\nParagraph here");
        System.out.println(html);

        
        System.out.println("\n✅ Adapter Pattern demonstrated successfully!");
    }
}
