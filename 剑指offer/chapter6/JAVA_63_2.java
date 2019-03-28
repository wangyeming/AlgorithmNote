package chapter6;

/**
 * 买卖股票的最佳时机 Ⅱ
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格.设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 考察点:抽象建模
 */
public class JAVA_63_2 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
        System.out.println(maxProfit(new int[]{10, 9, 8, 7}));
        System.out.println(maxProfit(new int[]{10, 8, 7, 6}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));
    }

    //找到所有的上升序列，把每个位置比上一个位置大的值累加即可
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return maxProfit;
    }
}
