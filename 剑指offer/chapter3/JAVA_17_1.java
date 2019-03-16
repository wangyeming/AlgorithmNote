package chapter3;

/**
 * 打印从1到最大的n位数
 * <p>
 * 输入数字n，按顺序打印从1到最大的n位十进制数。
 * <p>
 * 考察点：大数处理，考虑用户的交互习惯
 */
public class JAVA_17_1 {

    public static void main(String[] argv) {
//        printToMaxOfDigits1(3);
//        printToMaxOfDigits2(2);
        printToMaxOfDigits3(2);
    }

    //没有考虑大数！！
    public static void printToMaxOfDigits1(int n) {
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (i = 1; i < number; i++) {
            System.out.println(i);
        }
    }

    //方法二用char数组模拟数结构，并且实现加法
    public static void printToMaxOfDigits2(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = '0';
        }
        while (!plusOneAndIsOverflow(numbers)) {
            printNumber(numbers);
        }
    }

    //+1并且判断是否溢出
    private static boolean plusOneAndIsOverflow(char[] numbers) {
        boolean isOverflow = false;
        int nTakeOver = 0;  //进位
        int nLength = numbers.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = (numbers[i] - '0') + nTakeOver;
            if (i == nLength - 1) {
                //如果是最后一位数字，+1
                nSum++;
            }
            if (nSum >= 10) {
                //进位
                if (i == 0) {
                    //如果第一位数字为0，表示首位需要进位
                    isOverflow = true;
                } else {
                    //不是第一位，那么计算该位最终值，并标记下一位需要进位
                    nSum -= 10;
                    nTakeOver = 1;
                    numbers[i] = (char) (nSum + '0');
                }
            } else {
                numbers[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }


    private static void printNumber(char[] numbers) {
        boolean hasNoZero = false;
        for (char number : numbers) {
            if (number != '0' || hasNoZero) {
                hasNoZero = true;
                System.out.print(number);
            }
        }
        System.out.println();
    }

    //方法3最优，每一个都是0-9的全排列
    //用递归的思路去做
    public static void printToMaxOfDigits3(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            printToMaxOfDigits3recursively(numbers, 0);
        }
    }

    private static void printToMaxOfDigits3recursively(char[] numbers, int index) {
        if (index == numbers.length - 1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) (i + '0');
            printToMaxOfDigits3recursively(numbers, index + 1);
        }
    }
}