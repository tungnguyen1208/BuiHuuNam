package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== STRATEGY PATTERN DEMO ===\n");
        
        BlogDisplay blog = new BlogDisplay();
        blog.addPost("Java Tutorial");
        blog.addPost("Design Patterns");
        blog.addPost("Spring Boot Guide");
        blog.addPost("Algorithm Basics");
        
        // Strategy 1: Date sort
        blog.setSortStrategy(new DateSortStrategy());
        blog.displayPosts();
        
        // Strategy 2: Popularity sort
        blog.setSortStrategy(new PopularitySortStrategy());
        blog.displayPosts();
        
        // Strategy 3: Alphabetical sort
        blog.setSortStrategy(new AlphabeticalSortStrategy());
        blog.displayPosts();
    }
}
