package chapter2;

/**
 * 剪绳子
 * <p>
 * 长度为n的绳子，剪为m段，m段乘积最大是多少？
 */
public class JAVA_14 {

    public static void main(String[] argv) {
        for (int i = 2; i < 10; i++) {
            System.out.println("绳子长为 " + i + "时:");
            System.out.println("动态规划算法 " + maxProduct1(i));
            System.out.println("贪婪算法 " + maxProduct2(i));
        }
    }

    //动态规划算法，时间复杂度O(n^2),空间复杂度O(n)
    public static int maxProduct1(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;    //长度为1
        products[2] = 2;    //剩余长度为2的绳子，不减，最大值2
        products[3] = 3;    //剩余长度为3的绳子，不减，最大值3

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
            }
            products[i] = max;
        }

        return products[n];
    }

    //贪婪算法，如果剩余绳子的长度>=5,那么尽可能多减长度为3的绳子，当剩下的绳子长度为4时，把绳子剪成2*2
    public static int maxProduct2(int n) {
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if(n - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOF2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOF2));
    }


}
