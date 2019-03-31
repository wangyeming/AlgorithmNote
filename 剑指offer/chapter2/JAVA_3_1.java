package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里所有数字都在0~n-1的范围内。数组中某些数字是重复的，请找出任意一个重复的数字。
 * <p>
 * 考察点:一维数组的理解和编程能力
 */
public class JAVA_3_1 {
    public static void main(String[] argv) {
        System.out.println(findOneRepeatNumber(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 5}));
    }

    public static int findOneRepeatNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                continue;
            }
            if (array[i] == array[array[i]]) {
                return array[i];
            } else {
                swap(array, i, array[i]);
                i--;
            }
        }
        return -1;
    }

    //不借助额外的储存空间，找出所有的重复元素
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        for(int num: nums) {
            if(num < 1 || num > nums.length) {
                return result;
            }
        }
        for(int i = 0; i< nums.length; i++) {
            while(i != nums[i] - 1) {
                if(nums[i] == -1) {
                    break;
                }
                if(nums[nums[i] - 1] == nums[i]) {
                    result.add(nums[i]);
                    //这里，将重复元素置为-1，可以避免最终结果的重复
                    //注意，这里不可以将nums[i]置为-1，因为后续可能存在某元素恰好值为nums[i]
                    //index=nums[i] - 1的元素就在它自己的位置上，不会影响到其它元素
                    nums[nums[i] - 1] = -1;
                    break;
                }
                swap(nums, i, nums[i]-1);
            }
        }
        return result;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
