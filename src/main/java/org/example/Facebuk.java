package org.example;

import java.io.StringReader;
import java.util.*;

public class Facebuk {

    private final Map<String, Set<String>> users = new LinkedHashMap<>();
    public Facebuk(StringReader input) {
        Scanner s = new Scanner(input);
        while (s.hasNextLine()){
            popolaMappa(s.nextLine());
        }
    }

    private void popolaMappa(String s){
        String [] nomi = s.split(" ");
        Set<String> amici = new LinkedHashSet<>();
        for (int i = 1; i<nomi.length; i++){
            amici.add(nomi[i]);
        }
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
}
