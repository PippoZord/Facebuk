package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListView implements ViewStrategy {

    @Override
    public void format(StringBuilder sb, List<Map.Entry<String, Set<String>>> list) {
        for (Map.Entry<String, Set<String>> entry : list) {
            sb.append("(");
            sb.append(entry.getKey());
            sb.append(") [");
            for (String s : entry.getValue()){
                sb.append(s);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]\n");
        }

    }
}
