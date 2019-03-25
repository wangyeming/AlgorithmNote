package chapter5;

/**
 * 变位词检测
 * <p>
 * 如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词。
 */
public class JAVA_50_4 {

    public static void main(String[] args) {
        System.out.println(isAnagram("silent", "listen"));
        System.out.println(isAnagram("evil", "live"));
        System.out.println(isAnagram("evil", "livv"));
    }

    public static boolean isAnagram(String str1, String str2) {
        int[] charMap = new int[256];
        for (char c : str1.toCharArray()) {
            charMap[c]++;
        }
        for (char c : str2.toCharArray()) {
            if (charMap[c] == 0) {
                return false;
            }
            charMap[c] -= 1;
        }
        for (int value : charMap) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
