package chapter2;

/**
 * 斐波那契数列/青蛙跳台阶问题/覆盖问题
 */
public class JAVA_10 {

    public static void main(String[] argv) {
        System.out.println(fibonacci1(20));
        System.out.println(fibonacci2(20));
    }

    //递归算法,效率低，递归中有大量重复运算
    public static long fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    //非递归算法
    public static long fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        long valueN = 0;
        long value1 = 0;
        long value2 = 1;
        for (int i = 2; i <= n; i++) {
            valueN = value1 + value2;
            value1 = value2;
            value2 = valueN;
        }

        return valueN;
    }

}
