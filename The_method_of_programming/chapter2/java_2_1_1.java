package chapter2;

import support.Partition;

import java.util.Arrays;

/**
 * 寻找最小的k个数
 * <p>
 * 有n个整数，请找出其中最小的k个数，要求时间复杂度尽可能的低
 */
public class java_2_1_1 {

    public static void main(String[] argv) {
        int[] result = findMinK(new int[]{3, 6, 8, 1, -4, 5, 7, 8, 3, 2}, 6);
        System.out.println(Arrays.toString(result));
    }

    //借助快排的思想，快排每次使pivot左边元素都小于pivot，如果index<k-1，那么左边的元素一定是最小的k个元素，剩余的在右边。对右边继续快排
    //如果index>k-1,那么最小的k个元素都在左边，对左边继续快排。如果index=k-1,那么左边的就是minK
    //平均时间复杂度是O(n)
    public static int[] findMinK(int[] nums, int k) {
        int n = nums.length;
        if (n < k || k < 1) {
            return null;
        }
        quickSelect(nums, k, 0, n - 1);
        int[] minK = new int[k];
        for (int i = 0; i < k; i++) {
            minK[i] = nums[i];
        }
        return minK;
    }

    public static void quickSelect(int[] nums, int k, int start, int end) {
        int index = Partition.partition1(nums, start, end);
        if (index > k - 1) {
            quickSelect(nums, k, start, index - 1);
        } else if (index < k - 1) {
            quickSelect(nums, k, index + 1, end);
        }
    }


}
