package chapter5;

/**
 * 第一次只出现一次的字符
 * <p>
 * 在字符串中找出第一个只出现一次的字符。
 * <p>
 * 考察点：字符串，哈希表
 */
public class JAVA_50_1 {

    public static void main(String[] args) {
        System.out.println(findFirstNotRepeatChar("abaccdeff".toCharArray()));
        System.out.println(findFirstNotRepeatChar("aaccdeff".toCharArray()));
        System.out.println(findFirstNotRepeatChar("aaccff".toCharArray()));
    }

    //借助hash去完成
    public static char findFirstNotRepeatChar(char[] chars) {
        if (chars == null || chars.length == 0) {
            return ' ';
        }
        //ASCII字符只有256个，可以认为时间复杂度是O(1)
        int[] charMap = new int[256];
        for (char c : chars) {
            charMap[c]++;
        }
        for (char c : chars) {
            if (charMap[c] == 1) {
                return c;
            }
        }
        return ' ';
    }

}
