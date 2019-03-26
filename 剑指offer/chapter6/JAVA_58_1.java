package chapter6;

/**
 * 翻转字符串
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内的字符顺序不变。为简单起见，标点符号和字母一样处理。
 * I am a student. => .student a am I
 * <p>
 * 考察点：字符串
 */
public class JAVA_58_1 {

    public static void main(String[] args) {
        char[] str = "I am a student.".toCharArray();
        reverse(str);
        System.out.println(str);
    }

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
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

}