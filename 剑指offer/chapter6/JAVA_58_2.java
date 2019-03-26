package chapter6;

/**
 * 左旋字符串
 * <p>
 * 字符串的左旋操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串abcdefg和2, 输出cdefgab
 * <p>
 * 考察点：字符串的原地操作
 */
public class JAVA_58_2 {

    public static void main(String[] args) {
        char[] str = "abcdef".toCharArray();
        leftRotateString(str, 2);
        System.out.println(str);
    }

    public static void leftRotateString(char[] str, int n) {
        if (str == null || str.length == 0) {
            return;
        }
        n = n % str.length;
        reverse(str, 0, n - 1);
        reverse(str, n, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private static void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0) {
            return;
        }
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }


}
