package chapter5;

/**
 * 删除字符串中所有重复出现的字符
 * <p>
 * google -> gole
 * <p>
 * 考察点：字符串，哈希表
 */
public class JAVA_50_3 {
    public static void main(String[] args) {
        System.out.println(deleteRepeatChar("google"));
    }

    public static String deleteRepeatChar(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean[] charMap = new boolean[256];
        for (char c : str.toCharArray()) {
            if (!charMap[c]) {
                sb.append(c);
                charMap[c] = true;
            }
        }
        return sb.toString();
    }

}
