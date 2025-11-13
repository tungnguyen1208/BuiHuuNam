package strategy;

import java.util.Collections;
import java.util.List;

public class PopularitySortStrategy implements SortStrategy {
    @Override
    public void sort(List<String> posts) {
        System.out.println("Sorting by popularity (most viewed)...");
        Collections.shuffle(posts); // Simulate popularity sort
    }
    
    @Override
    public String getStrategyName() {
        return "Popularity Sort";
    }
}
