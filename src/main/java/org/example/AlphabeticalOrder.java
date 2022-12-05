package org.example;

import java.util.Map;
import java.util.Set;

public class AlphabeticalOrder implements OrderStrategy {
    @Override
    public int compare(Map.Entry<String, Set<String>> t1, Map.Entry<String, Set<String>> t2) {
        return t1.getKey().compareTo(t2.getKey());
    }
}
