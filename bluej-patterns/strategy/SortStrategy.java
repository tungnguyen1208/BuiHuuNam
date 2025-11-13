package strategy;

import java.util.List;

public interface SortStrategy {
    void sort(List<String> posts);
    String getStrategyName();
}
