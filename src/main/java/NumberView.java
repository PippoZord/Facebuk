import org.example.ViewStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberView implements ViewStrategy {
    @Override
    public void format(StringBuilder sb, List<Map.Entry<String, Set<String>>> list) {
        for (Map.Entry<String, Set<String>> entry : list) {
            sb.append("(");
            sb.append(entry.getKey());
            sb.append(") ");
            sb.append(entry.getValue().size());
            sb.append("\n");
        }
    }
}
