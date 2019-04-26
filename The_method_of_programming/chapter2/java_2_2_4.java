package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找三个数和为0
 * <p>
 * 输入一个整数数组，在数组中查找三个数，满足他们的和正好是0。
 * 不可以重复利用数组中同样的元素，返回所有符合条件的元素组合。
 */
public class java_2_2_4 {

    public static void main(String[] argv) {
        int[] nums = {1, -3, 1, -3, 1, 1, 2, -3, 2, -4};
        List<Integer[]> results = threeSumZero(nums);
        for (Integer[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    //排序后的左右指针，排序时间复杂度O(nlogn)，查找时间复杂度O(n)
    public static List<Integer[]> threeSumZero(int[] array) {
        List<Integer[]> result = new ArrayList<>();
        if (array == null || array.length < 3) {
            return result;
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                //避免重复
                continue;
            }
            int left = i + 1, right = array.length - 1;
            int sum = -array[i];
            while (left < right) {
                int realSum = array[left] + array[right];
                if (realSum < sum) {
                    left++;
                } else if (realSum > sum) {
                    right--;
                } else {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                    while (left < right && array[left] == array[left]) {
                        left++;
                    }
                    while (right > left && array[right] == array[right]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
