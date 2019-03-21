package chapter4;

/**
 * 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列
 * <p>
 * 考察点：字符串，递归
 */
public class JAVA_38_1 {

    public static void main(String[] argv) {
//        printAllPermutation("");
//        System.out.println("------");
//        printAllPermutation("a");
//        System.out.println("------");
        printAllPermutation("ab");
//        System.out.println("------");
//        printAllPermutation("abc");
//        System.out.println("------");
    }

    //思路是，将字符串看成两部分，第一个字符和后面，每次交换第一个字符和后面每一个字符.
    //对于其它字符，也做类似操作
    public static void printAllPermutation(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        char[] chars = str.toCharArray();
        _printAllPermutation(chars, 0);
    }

    private static void _printAllPermutation(char[] chars, int index) {
        if (index == chars.length - 1) {
            //当进行到最后一个字符时，表示所有的交换操作已经结束，这时需要输出结果
            System.out.println(chars);
            return;
        }
        for (int i = index; i < chars.length; i++) {
            //交换index和第i个元素之后，问题转成后面index+1个元素的全排列
            swap(chars, index, i);
            _printAllPermutation(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int m, int n) {
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
    }
}