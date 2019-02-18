package chapter1;

import java.util.HashMap;

public class java_1_2 {

    public static void main(String[] argv) {
        String str1 = "ABCA";
        String str2 = "BAAC";
        System.out.println(isBortherStr(str1, str2));
    }

    public static boolean isBortherStr(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            String s = String.valueOf(str1.charAt(i));
            if (map.containsKey(s)) {
                int value = map.get(s);
                map.put(s, value + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            String s = String.valueOf(str2.charAt(i));
            if (!map.containsKey(s)) {
                return false;
            }
            int value = map.get(s);
            if (value == 0) {
                return false;
            }
            map.put(s, value - 1);
        }
        return true;
    }
}
