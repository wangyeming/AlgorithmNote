package chapter6;

/**
 * 把字符串转换成整数
 * <p>
 * 输入一个字符串，把它转换成一个整数
 * <p>
 * 考察点：特殊情况，边界条件，鲁棒性
 */
public class JAVA_67 {

    public static void main(String[] args) {
        test(null);
        test("");
        test("+");
        test("-");
        test("1");
        test("111");
        test("+871");
        test("-908");
        test("-000");
        test("+78*");
        test("-9643o$");
        test("2147483647");
        test("2147483648");
        test("-2147483648");
        test("-2147483649");
    }

    private static void test(String s) {
        System.out.println("test " + s);
        try {
            System.out.println(atoi(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字符串转整型数字，需要考虑到的因素有以下情况：
    //1. 输入为null或者空
    //2. 以+，-号开头
    //3. 非0-9之间的字符
    //4. 超过最大值或者最小值
    public static int atoi(String s) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("input is null");
        }
        int len = s.length();
        if (len == 0) {
            throw new NumberFormatException("s is empty");
        }
        boolean negative = false;
        int i = 0;
        char firstChar = s.charAt(0);
        if (firstChar > '9') {
            throw new NumberFormatException("invalid");
        }
        if (firstChar < '0') {      // maybe leading + or -
            if (firstChar == '-') {
                negative = true;
            } else if (firstChar != '+') {
                throw new NumberFormatException("invalid");
            }
            if (len == 1) {
                //长度只有1的话，不允许只是特殊字符
                throw new NumberFormatException("not allow alone + or -");
            }
            i++;
        }
        long result = 0;
        while (i < len) {
            int digit = s.charAt(i++) - '0';
            if (digit < 0 || digit > 9) {
                throw new NumberFormatException("invalid");
            }
            result = result * 10 + digit;
            if (negative) {
                if (result - 1 > Integer.MAX_VALUE) {
                    throw new NumberFormatException("limit");
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    throw new NumberFormatException("limit");
                }
            }
        }
        return (int) (negative ? -result : result);

    }
}
