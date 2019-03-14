package chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class java_1_3_2 {

    public static void main(String[] argv) {
        String str = "ABC";
        List<String> results = getStrAllCombination(str);
        System.out.println(results.size());
        System.out.println(results);
    }

    public static List<String> getStrAllCombination(String str) {
        List<String> results = new ArrayList<>();
        int len = str.length();
        int n = 1 << len;
        //从1循环到2^len-1
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < len; j++) {
                System.out.println("i " + i + " j " + j);
                if ((i & (1 << j)) != 0) {
                    result.append(str.charAt(j));
                }
            }
            if (result.length() != 0) {
                results.add(result.toString());
            }
        }
        return results;
    }

}