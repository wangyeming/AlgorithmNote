package chapter2;

import java.util.Arrays;

/**
 * 奇偶数排序
 * <p>
 * 给定一个整数数组，请调整数组中树的顺序，使得所有的奇数位于数组的前半部分
 * 所有偶数位于数组的后半部分
 */
public class Java_2_6_1 {

    public static void main(String[] argv) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        oddEvenSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 左右指针的思路，时间复杂度O(n),缺点是会改变元素相对顺序
     */
    public static void oddEvenSort1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int left = 0, right = nums.length - 1; left < right; ) {
            while (left < right && !isOddNum(nums[left])) left++;
            while (left < right && isOddNum(nums[right])) right--;
            swap(nums, left, right);
        }
    }

    /**
     * 前后指针的思路
     * <p>
     * 后指针++向后走，前指针只有遇到奇数才向后走，每次交换前，前指针++总能保证是奇偶数交换
     */
    public static void oddEvenSort2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pre = -1;
        for (int cur = 0; cur < nums.length; cur++) {
            if (isOddNum(nums[cur])) {
                pre++;
                swap(nums, pre, cur);
            }
        }
        swap(nums, pre + 1, nums.length - 1);
    }

    private static boolean isOddNum(int num) {
        return (num & 1) == 1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
