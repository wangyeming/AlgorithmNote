package chapter2;

/**
 * 找零钱问题
 * <p>
 * 想兑换100元零钱，有1，2，5，10元零钱，计算有多少种方式。
 */
public class java_2_5_3 {


    private static final int[] COINS = {1, 2, 5, 10};

    public static void main(String[] argv) {
        System.out.println(calTypeCount(5));
    }

    //假设第m元，兑换方法F(m) = F(m-1) + F(m-2) + F(m-5) + F(m-10)
    public static int calTypeCount(int money) {
        int[] results = new int[money + 1];
        results[0] = 1;
        if (money <= 0) return 0;
        for (int coin : COINS) {
            for (int j = coin; j <= money; j++) {
                results[j] += results[j - coin];
            }
        }
        return results[money];
    }

}
