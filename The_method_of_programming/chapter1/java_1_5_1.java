package chapter1;

import java.util.Stack;

/**
 * 回文判断
 * <p>
 * 给定一个字符串，判断这个字符串是否为回文串
 */
public class java_1_5_1 {

    public static void main(String[] argv) {
        System.out.println(isPalindrome3("abc"));
        System.out.println(isPalindrome3("abba"));
        System.out.println(isPalindrome3("aba"));
        System.out.println(isPalindrome3("a"));
    }

    //从两头向中间
    public static boolean isPalindrome1(String str) {
        for (int s = 0, e = str.length() - 1; s < str.length() && e >= 0; s++, e--) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
        }
        return true;
    }

    //从中间向两头
    public static boolean isPalindrome2(String str) {
        int n = str.length();
        int middle = str.length() >> 1;
        int s = middle - 1, e = n % 2 == 0 ? middle : middle + 1;
        for (; s >= 0 && e < str.length(); s--, e++) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
        }
        return true;
    }

    //借助栈结构来判断回文
    public static boolean isPalindrome3(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
        }
        StringBuilder newSb = new StringBuilder();
        while (!stack.isEmpty()) {
            newSb.append(stack.pop());
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != newSb.toString().charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
