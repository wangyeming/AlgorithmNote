package chapter5;

/**
 * 删除另一个字符串中出现的字符
 * <p>
 * 定义一个函数，输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的所有字符。
 * <p>
 * 考察点：字符串，哈希表
 */
public class JAVA_50_2 {

    public static void main(String[] args) {
        System.out.println(deleteChar("We are students".toCharArray(), "aeiou".toCharArray()));
    }

    public static String deleteChar(char[] chars1, char[] chars2) {
        int[] charMap = new int[256];
        for (char c : chars2) {
            charMap[c]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars1) {
            if (charMap[c] == 0) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}