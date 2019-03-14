package chapter2;

/**
 * 将字符串中的ab->替换为c
 */
public class JAVA_5_3 {

    public static void main(String[] argv) {
        test("abababababab");
        test("acbadbabffgabaabbbaaaab");
    }

    private static void test(String str) {
        char[] rawStr1 = str.toCharArray();
        replaceSpace(rawStr1);
        System.out.println(rawStr1);
    }

    public static void replaceSpace(char[] rawStr) {
        boolean isA = false;
        int i = 0;
        for (int j = 0; j < rawStr.length; i++, j++) {
            if (rawStr[j] == 'a') {
                isA = true;
                continue;
            }
            if (rawStr[j] == 'b' && isA) {
                i -= 1;
                rawStr[i] = 'c';
                isA = false;
                continue;
            }
            isA = false;
        }
        for (int j = i; j < rawStr.length; j++) {
            rawStr[j] = ' ';
        }
    }
}
