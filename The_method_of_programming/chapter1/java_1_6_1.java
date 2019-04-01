package chapter1;

/**
 * 最长回文子串
 */
public class java_1_6_1 {

    public static void main(String[] argv) {
        String str = "abba";
        System.out.println(longestPalindrome(str));
    }

    //对每一个点，都求它的最长回文串的长度，区分奇数偶数
    //另一种解法Manacher以后有机会再看
    private static int longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int center = 0;
        int max = 1, currentLength = 0;
        for (int i = 0; i < str.length(); i++) {
            //回文长度为奇数
            for (int j = 0; (i - j) >= 0 && (i + j) < str.length(); j++) {
                if (str.charAt(i - j) != str.charAt(i + j)) {
                    break;
                }
                currentLength = j * 2 + 1;
            }
            if (currentLength > max) {
                max = currentLength;
                center = i;
            }
            //回文长度为偶数
            for (int j = 0; (i - j) >= 0 && (i + j + 1) < str.length(); j++) {
                if (str.charAt(i - j) != str.charAt(i + j + 1)) {
                    break;
                }
                currentLength = j * 2 + 2;
            }
            if (currentLength > max) {
                max = currentLength;
                center = i;
            }
        }
        System.out.println("center " + center + " max " + max);
        int startPos = center - ((max - 1) >> 1);
        int endPos = startPos + max - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = startPos; i <= endPos; i++) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
        return max;
    }


}
