import org.example.OrderStrategy;

import java.util.Map;
import java.util.Set;

public class NumberOrder implements OrderStrategy {
    @Override
    public int compare(Map.Entry<String, Set<String>> t1, Map.Entry<String, Set<String>> t2) {
        return Integer.compare(t1.getValue().size(), t2.getValue().size());
    }
}
