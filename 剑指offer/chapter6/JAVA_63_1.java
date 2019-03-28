package chapter6;

/**
 * 股票的最大利润
 * <p>
 * 假设把某只股票的价格按照时间先后存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 考察点:抽象建模
 */
public class JAVA_63_1 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
        System.out.println(maxProfit(new int[]{10, 9, 8, 7}));
        System.out.println(maxProfit(new int[]{10, 8, 7, 6}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //题目很简单,扫描到第i个数的时候，记录下前面的最小值，计算出当前的差价，如果比最大值大，那么就保存下来。
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        //至少买卖一次
        int maxDiff = prices[1] - min;
        //可以不买卖
//        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentDiff = prices[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxDiff;
    }
}