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
        if(n < 2) return n;
        int valueN = 0, value0 = 0, value1 = 1;
        for(int i = 2; i <= n ; i++) {
            valueN = value0 + value1;
            value0 = value1;
            value1 = valueN;
        }
        return valueN;
    }

}
