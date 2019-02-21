package chapter1;

public class java_1_2_1 {

    public static void main(String[] argv) {
        String str1 = "ABCA";
        String str2 = "BAAC";
        System.out.println(isContain(str1, str2));
    }

    public static boolean isContain(String str1, String str2) {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            hash |= (1 << (str1.charAt(i) - 'A'));
        }

        for (int i = 0; i < str2.length(); i++) {
            if ((hash & (1 << (str1.charAt(i) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }
}
