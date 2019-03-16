package chapter3;

/**
 * 两个数相加
 * <p>
 * 大数相加，考虑符号位
 * <p>
 * 考察点：大数处理
 */
public class JAVA_17_2 {

    public static void main(String[] argv) {
        printNumber(sum(new char[]{'+', '8', '7'}, new char[]{'+', '1', '9', '3'}));
        printNumber(sum(new char[]{'+', '4', '8', '7'}, new char[]{'+', '9', '3'}));
        printNumber(sum(new char[]{'+', '8', '7'}, new char[]{'-', '9', '3'}));
        printNumber(sum(new char[]{'+', '9', '3'}, new char[]{'-', '8', '7'}));
        printNumber(sum(new char[]{'-', '1', '3'}, new char[]{'+', '3', '8', '7'}));
        printNumber(sum(new char[]{'-', '7', '1', '3'}, new char[]{'+', '3', '8', '7'}));

    }

    public static char[] sum(char[] num1, char[] num2) {
        boolean isPositive; //结果是否为正数
        char[] result;
        //先判断符号
        if (num1[0] == num2[0]) {
            //符号位相同
            isPositive = (num1[0] == '+');
            //相同符号位，两数的绝对值相加
            result = _sum(num1, num2);
        } else {
            int compareResult = compare(num1, num2);
            //符号位不同
            isPositive = (num1[0] == '+') == (compareResult >= 0);
            //大绝对值-小绝对值
            result = compareResult >= 0 ? _minus(num1, num2) : _minus(num2, num1);
        }
        result[0] = isPositive ? '+' : '-';
        return result;
    }

    public static char[] _sum(char[] num1, char[] num2) {
        int length = Math.max(num1.length, num2.length) + 1;
        char[] result = new char[length];
        boolean isTakeOver = false;
        for (int i = 0; i < length - 1; i++) {
            int index1 = num1.length - 1 - i;
            int index2 = num2.length - 1 - i;
            int value1 = index1 >= 1 ? num1[index1] - '0' : 0;
            int value2 = index2 >= 1 ? num2[index2] - '0' : 0;
            int sum = value1 + value2;
            if (isTakeOver) {
                sum++;
            }
            if (sum >= 10) {
                sum -= 10;
                isTakeOver = true;
            } else {
                isTakeOver = false;
            }
            result[length - i - 1] = (char) (sum + '0');
        }
        return result;
    }

    private static char[] minus(char[] num1, char[] num2) {
        int compareResult = compare(num1, num2);
        if (compareResult >= 0) {
            return _minus(num1, num2);
        } else {
            return _minus(num2, num1);
        }
    }

    private static char[] _minus(char[] num1, char[] num2) {
        //移除符号位
        int length = Math.max(num1.length, num2.length);
        char[] result = new char[length];
        boolean isTakeDown = false;
        for (int i = 0; i < length - 1; i++) {
            int index1 = num1.length - 1 - i;
            int index2 = num2.length - 1 - i;
            int value1 = index1 >= 1 ? num1[index1] - '0' : 0;
            int value2 = index2 >= 1 ? num2[index2] - '0' : 0;
            int sum = value1 - value2;
            if (isTakeDown) {
                sum--;
            }
            if (sum < 0) {
                sum += 10;
                isTakeDown = true;
            } else {
                isTakeDown = false;
            }
            result[length - i - 1] = (char) (sum + '0');
        }
        return result;
    }

    private static int compare(char[] num1, char[] num2) {
        if (num1.length > num2.length) {
            return 1;
        } else if (num1.length < num2.length) {
            return -1;
        } else {
            for (int i = 1; i < num1.length; i++) {
                if (num1[i] == num2[i]) {
                    continue;
                }
                return num1[i] > num2[i] ? 1 : -1;
            }
            return 0;
        }
    }

    private static void printNumber(char[] numbers) {
        boolean hasNoZero = false;
        for (char number : numbers) {
            if (number == '-') {
                System.out.print('-');
                continue;
            }
            if (number != '0' || hasNoZero) {
                hasNoZero = true;
                System.out.print(number);
            }
        }
        System.out.println();
    }

}
