package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.StringReader;
import java.util.*;

public class Facebuk {

    private final Map<String, Set<String>> users = new LinkedHashMap<>();
    private final Map<String, Set<String>> amiciSet = new TreeMap<>();

    private ViewStrategy strategyView = new ListView();
    private OrderStrategy strategyOrder = null;

    public Facebuk(StringReader input) {
        Scanner s = new Scanner(input);
        while (s.hasNextLine()){
            popolaMappa(s.nextLine());
        }
    }

    private void popolaMappa(@NotNull String s){
        String [] nomi = s.split(" ");
        Set<String> amici = new LinkedHashSet<>(Arrays.asList(nomi).subList(1, nomi.length));
        users.put(nomi[0], amici);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : users.keySet()){
            sb.append(s);
            sb.append(" ");
            for (String v : users.get(s)){
                sb.append(v);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Set<String> amiciComuni(String u1, String u2) {
        Set<String> comuni = new LinkedHashSet<>(users.get(u1));
        comuni.retainAll(users.get(u2));
        return comuni;
    }

    public String output() {
        for (String key : users.keySet()){
            for (String v : users.get(key)){
                if (!key.equals(v) && sonoAmici(key, v)) {
                    if (!amiciSet.containsKey(v + " " + key)){
                        amiciSet.put(key + " " + v, amiciComuni(key, v));
                    }
                }

            }
        }


        StringBuilder sb = new StringBuilder();
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(amiciSet.entrySet());
        list.sort(strategyOrder);
        strategyView.format(sb, list);

        return sb.toString();
    }

    private boolean sonoAmici(String key, String v) {
        return users.get(key).contains(v);
    }

    public void setViewStrategy(ViewStrategy s) {
        strategyView = s;
    }

    public void setOrderStrategy(OrderStrategy s) {strategyOrder = s;}
}
