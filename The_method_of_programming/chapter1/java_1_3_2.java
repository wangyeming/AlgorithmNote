package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 字典序的所有排列
 * <p>
 * 对于字符串ab而言，它的字典序的所有排列就是aa,bb,ab,ba,假设字符串所有字符都不相同
 */
public class java_1_3_2 {

    public static void main(String[] argv) {
        String str = "ABC";
        List<String> results = permutation(str);
        System.out.println(results.size());
        System.out.println(results);
    }

    //思路就是：对于任意一个位置，假如先放上A，那么后面的位置可以用递归来放置。后面的放置完后，把Apop出来，继续放B
    public static List<String> permutation(String str) {
        List<String> result = new ArrayList<>();
        _permutation(str.toCharArray(), new Stack<>(), result);
        return result;
    }

    private static void _permutation(char[] rawStr, Stack<Character> newStr, List<String> result) {
        if (newStr.size() == rawStr.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : newStr) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        for (char c : rawStr) {
            newStr.push(c);
            _permutation(rawStr, newStr, result);
            newStr.pop();
        }
    }
}
