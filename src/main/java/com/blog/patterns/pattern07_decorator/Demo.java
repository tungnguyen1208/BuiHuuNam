package com.blog.patterns.pattern07_decorator;

import com.blog.patterns.shared.*;

/**
 * Demo class for Decorator Pattern
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                           DECORATOR                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Vietnamese: Gắn thêm responsibilities cho object một cách động");
        System.out.println("English: Attaches additional responsibilities to an object dynamically\n");
        
        System.out.println("Demo:");
        System.out.println("------");
        
        BlogPost post = new BlogPost("Title", "Content", "Author");
        BlogPostComponent component = new BasicBlogPost(post);
        
        // Add comments
        component = new CommentDecorator(component, 5);
        
        // Add likes
        component = new LikeDecorator(component, 10);
        
        component.display();

        
        System.out.println("\n✅ Decorator Pattern demonstrated successfully!");
    }
}
