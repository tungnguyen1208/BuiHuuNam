package strategy;

import java.util.ArrayList;
import java.util.List;

public class BlogDisplay {
    private List<String> posts;
    private SortStrategy sortStrategy;
    
    public BlogDisplay() {
        this.posts = new ArrayList<>();
    }
    
    public void addPost(String post) {
        posts.add(post);
    }
    
    public void setSortStrategy(SortStrategy strategy) {
        this.sortStrategy = strategy;
    }
    
    public void displayPosts() {
        if (sortStrategy != null) {
            System.out.println("\n=== Displaying Posts (" + sortStrategy.getStrategyName() + ") ===");
            List<String> sortedPosts = new ArrayList<>(posts);
            sortStrategy.sort(sortedPosts);
            for (int i = 0; i < sortedPosts.size(); i++) {
                System.out.println((i + 1) + ". " + sortedPosts.get(i));
            }
        } else {
            System.out.println("No sort strategy set!");
        }
    }
}
