package strategy;

import java.util.Collections;
import java.util.List;

public class AlphabeticalSortStrategy implements SortStrategy {
    @Override
    public void sort(List<String> posts) {
        System.out.println("Sorting alphabetically...");
        Collections.sort(posts);
    }
    
    @Override
    public String getStrategyName() {
        return "Alphabetical Sort";
    }
}
