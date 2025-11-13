package facade;

public class FacadeDemo {
    public static void main(String[] args) {
        System.out.println("=== FACADE PATTERN DEMO ===\n");
        
        BlogFacade blog = new BlogFacade();
        
        blog.publishPost(
            "Design Patterns in Java",
            "This is a comprehensive guide to design patterns..."
        );
        
        blog.publishPost("Bad", "Short");
    }
}
