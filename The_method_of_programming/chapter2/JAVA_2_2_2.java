package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找和为定值的两个数
 * <p>
 * 输入一个整数数组和一个整数，在数组中查找一对数，满足他们的和正好是输入的那个整数。
 * 不可以重复利用数组中同样的元素
 */
public class JAVA_2_2_2 {

    //三数之和为0的话，a+b+c=0 => a+b=-c
    public static void main(String[] argv) {
        int[] nums = {7, 9, 10, 5, 13, 1, 2, 15, 3, 4, 6, 11, 12, 8, 14};
        System.out.println(Arrays.toString(twoSum1(nums, 26)));
        System.out.println(Arrays.toString(twoSum2(nums, 26)));
    }

    //用时间换空间的做法，空间复杂度O(n),时间复杂度O(n)
    //寻找两个数的下标显然可以通过key对于的value来获取
    public static int[] twoSum1(int[] array, int sum) {
        int[] result = new int[2];
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
                    if (index != i) {
                        //避免复用同一个元素
                        result[0] = num;
                        result[1] = findNum;
                        break;
                    }
                }

            }
        }
        return result;
    }

    //排序后的左右指针，排序时间复杂度O(nlogn)，查找时间复杂度O(n)
    //寻找两个数的下标显然也很简单,这里因为只需要找到一个结果，所以不需要去重
    public static int[] twoSum2(int[] array, int sum) {
        int[] result = new int[2];
        if (array == null || array.length < 2) {
            return result;
        }
        Arrays.sort(array);
        int start = 0, end = array.length - 1;
        while (start < end) {
            int realSum = array[start] + array[end];
            if (realSum < sum) {
                start++;
            } else if (realSum > sum) {
                end--;
            } else {
                result[0] = array[start];
                result[1] = array[end];
                break;
            }
        }
        return result;
    }
}
