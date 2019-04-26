package chapter2;

import java.util.Arrays;

/**
 * 最大连续子数组和
 * <p>
 * 给定一个整数数组，数组里可能有正数，负数和零。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和，求所有子数组的和的最大值。
 */
public class java_2_4_1 {

    public static void main(String[] argv) {
        int[] array1 = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSubSum(array1));
        System.out.println(Arrays.toString(maxSubSumWithPos(array1)));
        int[] array2 = new int[]{-8, -2, -3, -10, -4, -7, -2, -5};
        System.out.println(maxSubSum(array2));
        System.out.println(Arrays.toString(maxSubSumWithPos(array2)));
        int[] array3 = new int[]{1, 2, 0, 3, 4};
        System.out.println(maxSubSum(array3));
        System.out.println(Arrays.toString(maxSubSumWithPos(array3)));
    }

    //动态规划的思路
    //最笨的方法是求所有的子数组的和，然后找出最小值，以第i个元素开头，第j个元素结尾，窗口大小在(j-i)范围内滑动，所以是n^3的复杂度
    //动态规划的思路是：已知以第i个元素结尾的连续子数组的和的最大值S(i)，此时计算第i+1个元素，只有两种选择：
    //1. S(i) >= 0,那么S(i+1) = S(i) + nums[i+1]
    //2. S(i) < 0,那么S(i+1) = nums[i+1]
    //建立起状态转移方程，在一遍循环中就能计算出以所有元素为结尾的连续子数组的和的最大值{S(0), S(1), ...S(i)...}，求最大值即可。
    //时间复杂度降为O(n)
    public static int maxSubSum(int[] array) {
        if (array == null || array.length == 0) return Integer.MIN_VALUE;
        int currentSum = 0, maxSum = array[0];
        for (int num : array) {
            if (currentSum >= 0) {
                currentSum += num;
            } else {
                currentSum = num;
            }
            if (maxSum < currentSum) maxSum = currentSum;
        }
        return maxSum;
    }

    //同时要求输出开始位置和结束位置
    public static int[] maxSubSumWithPos(int[] array) {
        if (array == null || array.length == 0) return new int[]{0, -1, -1};
        int currentStart = 0, currentEnd = 0, currentSum = 0;
        int maxStart = 0, maxEnd = 0, maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (currentSum >= 0) {
                currentEnd++;
                currentSum += num;
            } else {
                currentStart = i;
                currentEnd = i;
                currentSum = num;
            }
            if (maxSum < currentSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = currentEnd;
            }
        }
        return new int[]{maxSum, maxStart, maxEnd};
    }

    //不要求连续的话，直接把所有正数相加即可
}
