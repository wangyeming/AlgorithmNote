package chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class java_1_3 {

    public static void main(String[] argv) {
        String str = "ABCA";
        List<String> results = getStringAllArrangement(str);
        System.out.println(results.size());
        System.out.println(results);
    }

    public static List<String> getStringAllArrangement(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(String.valueOf(str.charAt(i)), 0);
        }
        List<String> results = new ArrayList<>();
        int length = 0;
        while (length < str.length()) {
            List<String> newResults = new ArrayList<>();
            for(String key: map.keySet()) {
                if(length > 0) {
                    for(String result: results) {
                        newResults.add(result + key);
                    }
                } else {
                    newResults.add(key);
                }
            }
            length++;
            results = newResults;
        }
        return results;
    }

}