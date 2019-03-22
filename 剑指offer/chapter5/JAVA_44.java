package chapter5;

/**
 * 数字序列中某一位的数字
 * <p>
 * 数字以0123456789101112131415...的格式序列化道一个字符串列中。在这个序列中，第5位(从0开始计数)是5，第13位是1，第19位是4.
 * 请写一个函数，求任意第n位对应的数字
 * <p>
 * 考察点：优化时间
 */
public class JAVA_44 {

    public static void main(String[] argv) {
        for (int i = 0; i <= 1001; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }
            System.out.print(getNumber(i));
        }
    }

    //1位数有10个，2位数有90个，3位数有900个
    //1位数长度为1*10=10，2位数长度为2*90=180，3位数长度为3*900=2700
    public static int getNumber(int n) {
        if (n < 10) {
            return n;
        }
        for (int i = 1; ; i++) {
            if (n < getBitLength(i)) {
                //
                int num = getBitTotalCount(i - 1) + n / i;
                return String.valueOf(num).toCharArray()[n % i] - '0';
            }
            n -= getBitLength(i);
        }
    }

    //1->0123456789->1*10=10
    private static int getBitLength(int bit) {
        return bit * getBitCount(bit);
    }

    //小于最大bit位数的个数，比如bit=3，那么所有小于999的数一共有
    private static int getBitTotalCount(int bit) {
        if (bit <= 0) {
            return 0;
        }
        return powerBase10(bit);
    }

    //1->0-9->10
    //2->10-99->90
    //获取bit位数的个数
    private static int getBitCount(int bit) {
        if (bit <= 0) {
            return 0;
        }
        if (bit == 1) {
            return 10;
        }
        return (powerBase10(bit) - powerBase10(bit - 1));
    }

    // 10^n
    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

}