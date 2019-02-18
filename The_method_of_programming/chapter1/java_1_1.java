package chapter1;

//
public class java_1_1 {

    public static void main(String[] argv) {
        String str = "I am a student.";
        String reverseWordsStr = reserveWords(str);
        System.out.println(reverseStr(reverseWordsStr, 0, reverseWordsStr.length() - 1));
    }

    public static String reverseStr(String str, int start, int end) {
        if (start >= end || end >= str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (start <= end) {
            //str[start], str[end] = str[end], str[start]
            char tmp = sb.charAt(start);
            sb.replace(start, start + 1, String.valueOf(sb.charAt(end)));
            sb.replace(end, end + 1, String.valueOf(tmp));
            start += 1;
            end -= 1;
        }
        return sb.toString();
    }

    public static String reserveWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String newString = str;
        int wordStart = -1;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                newString = reverseStr(newString, wordStart, i);
                break;
            }
            char s = newString.charAt(i);
            if (s == ' ') {
                if (wordStart == -1) {
                    continue;
                }
                newString = reverseStr(newString, wordStart, i - 1);
                wordStart = -1;
            } else {
                if (wordStart == -1) {
                    wordStart = i;
                }
            }
        }
        return newString;
    }


}
