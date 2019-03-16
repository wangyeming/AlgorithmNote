package chapter3;

/**
 * 表示数值的字符串
 * <p>
 * 请实现一个函数来判断字符串是否表示数值，
 * 数值：+100，5e2, -123, 3.1416, -1E-16, .324, -1.34e+4
 * 非数值：12e, 1a3.14, 1.2.3, +-5, 12e+5.4
 * <p>
 * 考察点：字符串的编程能力，分析问题照出规律，全面性
 */
public class JAVA_20 {

    public static void main(String[] argv) {
        System.out.println(isNumeric("99".toCharArray()));
        System.out.println(isNumeric("+100".toCharArray()));
        System.out.println(isNumeric("+5e2".toCharArray()));
        System.out.println(isNumeric("-123".toCharArray()));
        System.out.println(isNumeric("3.1416".toCharArray()));
        System.out.println(isNumeric("-1E-16".toCharArray()));
        System.out.println(isNumeric("+100".toCharArray()));
        System.out.println(isNumeric(".324".toCharArray()));
        System.out.println(isNumeric("-1.34e+4".toCharArray()));
        System.out.println("----------");
        System.out.println(isNumeric("".toCharArray()));
        System.out.println(isNumeric("12e".toCharArray()));
        System.out.println(isNumeric("1a3.14".toCharArray()));
        System.out.println(isNumeric("1.2.3".toCharArray()));
        System.out.println(isNumeric(".+-5".toCharArray()));
        System.out.println(isNumeric("12e+5.4".toCharArray()));
    }

    //(+|-)*(A)*(.B)*(e|E(+|-)*C)*
    public static boolean isNumeric(char[] chars) {
        if (chars.length == 0) {
            return false;
        }
        int[] index = new int[]{0};
        boolean isNumeric = scanInteger(chars, index);
//        System.out.println("scan integer " + isNumeric + " " + index[0]);
        if (index[0] >= chars.length) {
            return isNumeric;
        }
        if (chars[index[0]] == '.') {
            index[0]++;
//            System.out.println("include dot " + isNumeric + " " + index[0]);
            //注意先后顺序！！，前面哪怕没有数字，如.31也是ok
            isNumeric = scanUnsignedInteger(chars, index) || isNumeric;
//            System.out.println("scan unsigned integer " + isNumeric + " " + index[0]);
        }
        if (index[0] >= chars.length) {
            return isNumeric;
        }
        if (chars[index[0]] == 'e' || chars[index[0]] == 'E') {
            index[0]++;
//            System.out.println("include e|E " + isNumeric + " " + index[0]);
            if (index[0] >= chars.length) {
                return false;
            }
            //e|E前后都必须是数字
            isNumeric = isNumeric && scanInteger(chars, index);
//            System.out.println("scan integer " + isNumeric + " " + index[0]);
        }
        return isNumeric && index[0] == chars.length;
    }

    private static boolean scanUnsignedInteger(char[] str, int[] index) {
        int indexValue = index[0];
        int i = index[0];
        while (i < str.length && (str[i] >= '0' && str[i] <= '9')) {
            i++;
        }
        index[0] = i;
        return index[0] > indexValue;
    }

    private static boolean scanInteger(char[] str, int[] index) {
        int i = index[0];
        if (str[i] == '+' || str[i] == '-') {
            index[0]++;
        }
        return scanUnsignedInteger(str, index);
    }

}
