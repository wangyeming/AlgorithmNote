package chapter1;

import java.util.HashMap;

/**
 * 变位词(兄弟字符串)
 * <p>
 * 如果两个字符串的字符一样，出现的次数也一样，只是出现的顺序不一样，则认为这两个字符串是兄弟字符串。
 * 现提供一个字符串，如何在字典中迅速找到他的兄弟字符串。
 */
public class java_1_2_2 {

    public static void main(String[] argv) {
        String str1 = "ABCA";
        String str2 = "BAAC";
        System.out.println(isBrotherStr(str1, str2));
    }

    //这里我只写了如何判断两个字符串是否是兄弟字符串
    public static boolean isBrotherStr(String str1, String str2) {
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
