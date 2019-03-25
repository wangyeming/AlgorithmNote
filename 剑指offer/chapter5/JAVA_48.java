package chapter5;

/**
 * 最长不包含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该字符串最长子字符串的长度。
 * 假设该字符串只包括'a'-'z'的字符。
 * <p>
 * 考察点：动态规划
 */
public class JAVA_48 {

    public static void main(String[] args) {
        System.out.println(getLongestSubstringWithoutDuplication("arabcacfr".toCharArray()));
    }

    //思路是：对于以第i个字符结尾的子字符串，最大值f(i)的计算如下分析
    //如果第i个字符之前从未出现过，那么f(i)=f(i-1)+1
    //如果第i个字符之前出现过，假设距离上一次出现的位置d
    // d>f(i-1) 说明f(i-1)串中不包含上一次的重复字符，f(i)=f(i-1)+1
    // d<=f(i-1)说明f(i-1)串中包含上一次的重复字符   f(i)=d
    //时间复杂度O(n)，空间复杂度常量
    public static int getLongestSubstringWithoutDuplication(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        //记录26个字母首次出现的位置
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = -1;
        }
        int currentLongestSubStringLength = 0;
        int maxLongestSubStringLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            int pos = positions[letter - 'a'];
            if (pos == -1) {
                currentLongestSubStringLength++;
            } else {
                if (i - pos > currentLongestSubStringLength) {
                    currentLongestSubStringLength++;
                } else {
                    currentLongestSubStringLength = i - pos;
                }
            }
            if (currentLongestSubStringLength > maxLongestSubStringLength) {
                maxLongestSubStringLength = currentLongestSubStringLength;
            }
            positions[letter - 'a'] = i;
        }
        return maxLongestSubStringLength;

    }
}
