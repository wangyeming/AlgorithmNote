package chapter5;

import support.Partition;

import java.util.Arrays;

/**
 * 最小的K个数
 * <p>
 * 输入n个整数，找出其中最小的k个数
 * <p>
 * 考察点：快排思想
 */
public class JAVA_40 {

    public static void main(String[] argv) {
        int[] data = {5, 3, 21, 4, 6, 7, 89, 9, 1, 2};
        System.out.println(Arrays.toString(findLeastNumber1(data, 0)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 1)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 2)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 3)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 4)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 5)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 6)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 7)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 8)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 9)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 10)));
        System.out.println(Arrays.toString(findLeastNumber1(data, 11)));
    }

    //借助快排的思想，和39题类似，优点是速度快O(n)，缺点是会改动原数组
    //如果不能改定元素住，可以通过维护最大堆来做
    public static int[] findLeastNumber1(int[] nums, int k) {
        int[] result = initResult(k);
        if (nums == null || nums.length < k || k <= 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = Partition.partition1(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = Partition.partition1(nums, start, end);
            } else {
                start = index + 1;
                index = Partition.partition1(nums, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }
        return result;
    }

    private static int[] initResult(int k) {
        int[] result = initResult(k);
        for (int i = 0; i < k; i++) {
            result[i] = -1;
        }
        return result;
    }

}
