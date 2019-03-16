package chapter3;

import com.sun.tools.javac.util.Assert;

/**
 * 正则匹配表达式
 * <p>
 * .匹配任意字符，*表示前面一个字符可以出现0次或更多。
 * <p>
 * 考察点：字符串编程能力，正则表达式理解能力，考虑问题的全面性
 */
public class JAVA_19 {

    public static void main(String[] argv) {
        test("", "", true);
        test("", "a", false);
        test("", "a*", true);
        test("", ".*", true);
        test("", "a*b*", true);
        test("a", "", false);
        test("aa", "a", false);
        test("aa", "a*", true);
        test("abc", "abc", true);
        test("abc", "ab*c", true);
        test("abc", "ad*bc", true);
        test("abb", "ab", false);
        test("abc", ".*c", true);
        test("abc", ".*b", false);
        test("abc", ".*bc", true);
    }

    private static void test(String str, String pattern, boolean result) {
        boolean isMatch = match(str.toCharArray(), pattern.toCharArray());
        Assert.check(isMatch == result);
    }

    public static boolean match(char[] str, char[] pattern) {
        return _match(str, 0, pattern, 0);
    }

    private static boolean _match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (patternIndex == pattern.length) {
            //模式匹配符结束，是否匹配就看字符串是否结束
            return strIndex == str.length;
        }
        //如果pattern后面一个存在且是*的情况
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex < str.length &&
                    (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                //a <-> a*(.*）
                return _match(str, strIndex + 1, pattern, patternIndex + 2)
                        //aa <-> a*(.*)
                        || _match(str, strIndex + 1, pattern, patternIndex)
                        //'' <-> a*(.*)
                        || _match(str, strIndex, pattern, patternIndex + 2);
            } else {
                //b <-> a* or '' <-> a*
                return _match(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if (strIndex >= str.length) {
            //字符串结束,模式匹配符
            return false;
        }
        if ((str[strIndex] == pattern[patternIndex]) || (pattern[patternIndex] == '.')) {
            return _match(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
