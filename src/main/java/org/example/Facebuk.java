package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.StringReader;
import java.util.*;

public class Facebuk {

    private final Map<String, Set<String>> users = new LinkedHashMap<>();
    private final Map<String, Set<String>> amiciSet = new TreeMap<>();

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
        Set<String> comuni = new HashSet<>(users.get(u1));
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
        for (String k: amiciSet.keySet()) {
            sb.append("(");
            sb.append(k);
            sb.append(") ");
            sb.append("[");
            for (String v: amiciSet.get(k)) {
                sb.append(v);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]\n");
        }

        return sb.toString();
    }

    private boolean sonoAmici(String key, String v) {
        return users.get(key).contains(v);
    }
}
