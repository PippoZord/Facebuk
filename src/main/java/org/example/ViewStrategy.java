package org.example;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ViewStrategy{
    void format(StringBuilder sb, List<Map.Entry<String, Set<String>>> list);
}
