package chapter1;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 1. 无空格字符构成一个单词。
 * 2. 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 3. 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class java_1_1_3 {

    public static void main(String[] argv) {
        String str = " I am a  student  ";
        System.out.println(reverseWords(str));
//        str = "the sky is blue";
//        System.out.println(solution.reverseWords(str));
//        String str3 = "abc";
//        System.out.println(solution.reverseWords(str3));
//        String str4 = " ";
//        System.out.println("result is|" + solution.reverseWords(str4) + "|end");
    }

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] sentenceChars = s.toCharArray();
        int start = 0;
        int end = sentenceChars.length - 1;
        for (int i = start; i <= end; i++) {
            if (sentenceChars[i] == ' ') {
                start++;
            } else {
                break;
            }
        }
        for (int i = end; i >= start; i--) {
            if (sentenceChars[i] == ' ') {
                end--;
            } else {
                break;
            }
        }
        reverseSentence(sentenceChars, start, end);
        StringBuilder sb = new StringBuilder();
        boolean leadingWithLetter = false;
        for (int i = start; i <= end; i++) {
            if (sentenceChars[i] == ' ') {
                if (leadingWithLetter) sb.append(sentenceChars[i]);
                leadingWithLetter = false;
            } else {
                sb.append(sentenceChars[i]);
                leadingWithLetter = true;
            }
        }
        return sb.toString();
    }

    private static void reverseSentence(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || start < 0 || end >= chars.length || end < start) {
            return;
        }
        //读到空格时，reverse单词，并且start = end
        for (int previous = start, current = start; current <= end; previous++, current++) {
            if(current == end) {
                if (previous != current) {
                    reverse(chars, previous, current);
                    previous = current;
                }
            } else if(chars[current] == ' ') {
                if (previous != current) {
                    reverse(chars, previous, current - 1);
                    previous = current;
                }
            } else {
                //读到普通单词
                previous--;
            }
        }
        reverse(chars, start, end);
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
