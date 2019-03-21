package support;

import java.util.Arrays;
import java.util.Random;

public class Partition {

    public static void main(String[] argv) {
        int[] nums = {3, 7, 1, 6, 4, 2};
        System.out.println("small is " + partition(nums, 0, 5));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 分治法思想，将数组的[start, end]之间的元素，比small大的放在右边，比small小的放在左边
     */
    public static int partition(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length) {
            return -1;
        }
        int index = randomInRange(start, end);
        swap(nums, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (nums[index] < nums[end]) {
                small++;
                if (small != index) {
                    swap(nums, index, small);
                }
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private static int randomInRange(int start, int end) {
        Random random = new Random();
        return random.nextInt((end) % (end - start + 1) + start);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
