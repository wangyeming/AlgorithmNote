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
        reverse(chars);
        System.out.println(chars);
    }

    //和剑指offer58-1题一样
    public static void reverse(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        //读到空格时，reverse单词，并且start = end
        for (int start = 0, end = 0; end < chars.length; start++, end++) {
            if (chars[end] == ' ' || end == chars.length - 1) {
                if (start != end) {
                    reverse(chars, start, end - 1);
                    start = end;
                }
            } else {
                //读到普通单词
                start--;
            }
        }
        reverse(chars, 0, chars.length - 1);
    }


    private static void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0) {
            return;
        }
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
