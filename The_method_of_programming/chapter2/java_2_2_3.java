package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找和为定值的两个数的下标
 * <p>
 * 输入一个整数数组和一个整数，在数组中查找一对数，满足他们的和正好是输入的那个整数。
 * 不可以重复利用数组中同样的元素，返回所有符合条件的元素的下标
 */
public class java_2_2_3 {

    //寻找下标的难点在于，如果数组中存在重复的元素，寻找index的过程会相对比较棘手
    public static void main(String[] argv) {
        int[] nums = {1, 1, 1, 1, 2, 2};
        List<Integer[]> results = twoSum2(nums, 3);
        for (Integer[] result : results) {
            System.out.println(Arrays.toString(result));

        }
    }

    //用时间换空间的做法，空间复杂度O(n),时间复杂度O(n)
    //寻找两个数的下标显然可以通过key对于的value来获取
    public static List<Integer[]> twoSum1(int[] array, int sum) {
        List<Integer[]> result = new ArrayList<>();
        if (array == null || array.length < 2) {
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                map.put(num, indexs);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int findNum = sum - num;
            if (map.containsKey(findNum)) {
                List<Integer> indexs = map.get(findNum);
                for (Integer index : indexs) {
                    if (array[i] < array[index]) {       //避免复用同一个元素以及重复
                        result.add(new Integer[]{i, index});
                    }
                }

            }
        }
        return result;
    }

    //排序后的左右指针，排序时间复杂度O(nlogn)，查找时间复杂度O(n)
    public static List<Integer[]> twoSum2(int[] array, int sum) {
        List<Integer[]> result = new ArrayList<>();
        if (array == null || array.length < 2) {
            return result;
        }
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while (left < right) {
            int realSum = array[left] + array[right];
            if (realSum < sum) {
                left++;
            } else if (realSum > sum) {
                right--;
            } else {
                result.add(new Integer[]{left, right});
                //left和right的移动需要注意
                for (int tmpRight = right - 1; left < tmpRight && array[tmpRight] == array[right]; tmpRight--) {
                    result.add(new Integer[]{left, tmpRight});
                }
                for (int tmpLeft = left + 1; tmpLeft < right && array[tmpLeft] == array[left]; tmpLeft++) {
                    result.add(new Integer[]{tmpLeft, right});
                }
                left++;
                right--;
            }
        }
        return result;
    }
}
