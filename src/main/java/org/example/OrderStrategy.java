package org.example;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public interface OrderStrategy extends Comparator<Map.Entry<String, Set<String>>> {
}
