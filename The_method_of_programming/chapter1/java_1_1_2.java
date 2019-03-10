package chapter1;

/**
 * 翻转一句话中的单词
 * <p>
 * I am a student. => student. a am I
 */
public class java_1_1_2 {

    public static void main(String[] argv) {
        String str = "I am a student.";
        char[] chars = str.toCharArray();
        reverseWords(chars);
        System.out.println(chars);
    }

    public static void reverseWords(char[] str) {
        if (str.length == 0) {
            return;
        }
        int wordStart = -1;
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                //读到句末了
                if (wordStart != -1) {
                    reverseStr(str, wordStart, str.length - 1);
                    break;
                }
            }
            char s = str[i];
            if (s == ' ') {
                //读到空格了
                if (wordStart == -1) {
                    //连续空格，忽略
                } else {
                    //单词结束
                    reverseStr(str, wordStart, -1);
                    wordStart = -1;
                }
            } else {
                //读到单词了
                if (wordStart == -1) {
                    wordStart = i;
                }
            }
        }
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
