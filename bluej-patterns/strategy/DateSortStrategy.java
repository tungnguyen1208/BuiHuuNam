package strategy;

import java.util.Collections;
import java.util.List;

public class DateSortStrategy implements SortStrategy {
    @Override
    public void sort(List<String> posts) {
        System.out.println("Sorting by date (newest first)...");
        Collections.reverse(posts);
    }
    
    @Override
    public String getStrategyName() {
        return "Date Sort";
    }
}
