package chapter2;

import java.util.Arrays;

/**
 * 荷兰国旗
 * <p>
 * 有n个红白蓝三种颜色的小球，乱序排列，请通过两两交换，使得顺序为红白蓝
 */
public class java_2_7_1 {

    public static void main(String[] argv) {
        int[] nums = {2, 2, 0, 1, 2, 1, 2, 0, 2, 1, 0};
        colorSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 把红白蓝三种颜色分别对应成0，1，2
     * 利用三个指针排序，前指针负责把中指针的0交换到数组前面，后指针负责把中指针的2交换到数组后面
     */
    public static void colorSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1, center = left;
        while (center < right) {
            if (nums[center] == 0) {
                swap(nums, left, center);
                center++;
                left++;
            } else if (nums[center] == 1) {
                center++;
            } else if (nums[center] == 2) {
                swap(nums, center, right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
