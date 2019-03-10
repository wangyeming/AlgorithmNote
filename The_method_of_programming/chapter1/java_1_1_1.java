package chapter1;

/**
 * 旋转字符串前面的若干字符
 * <p>
 * 比如abcdef旋转前3个字符到字符串末尾，变成defabc
 */
public class java_1_1_1 {

    public static void main(String[] argv) {
        char[] str1 = "abcdef".toCharArray();
        reverseStr(str1, 3);
        System.out.println(str1);
        char[] str2 = "".toCharArray();
        reverseStr(str2, 0);
        System.out.println(str2);
    }

    //三步旋转法
    //1. 将字符串分为两部分，abc，def
    //2. 分别原地旋转这两部分，cba，fed
    //3. 整个旋转 defabc
    public static void reverseStr(char[] str, int count) {
        if(str.length == 0) {
            return;
        }
        count %= str.length;
        reverseStr(str, 0, count - 1);
        reverseStr(str, count, str.length - 1);
        reverseStr(str, 0, str.length - 1);
    }

    private static void reverseStr(char[] str, int from, int to) {
        while (from < to) {
            char t = str[from];
            str[from++] = str[to];
            str[to--] = t;
        }
    }

}
