import org.example.OrderStrategy;

import java.util.Map;
import java.util.Set;

public class NumberOrder implements OrderStrategy {
    @Override
    public int compare(Map.Entry<String, Set<String>> stringSetEntry, Map.Entry<String, Set<String>> t1) {
        return 0;
    }
}
