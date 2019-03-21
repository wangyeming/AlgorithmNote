package chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * 正方体顶角数字和相等
 * <p>
 * 输入一个包含8个数字的数组，判断有没有可能把这八个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
 * <p>
 * 考察点：全排列
 */
public class JAVA_38_3 {

    public static void main(String[] argv) {
        System.out.println(hasValidPermutation(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    //先求出所有的排列可能，再挨个判断
    //当然更好的做法是，每计算出一种排列，就判断，如果存在，就返回true
    //这里没有考虑重复数字的问题
    private static boolean hasValidPermutation(int[] data) {
        if (data == null || data.length != 8) {
            return false;
        }
        List<List<Integer>> results = new ArrayList<>();
        getAllPermutation(data, 0, results);
        System.out.println("共有" + results.size() + "种全排列");
        for (List<Integer> result : results) {
            System.out.println(result);
            if (isValid(result)) {
                return true;
            }
        }
        return false;
    }

    private static void getAllPermutation(int[] data, int index, List<List<Integer>> results) {
        if (index == data.length - 1) {
            //当进行到最后一个字符时，表示所有的交换操作已经结束，这时需要输出结果
            List<Integer> result = new ArrayList<>();
            for (int num : data) {
                result.add(num);
            }
            results.add(result);
            return;
        }
        for (int i = index; i < data.length; i++) {
            //交换index和第i个元素之后，问题转成后面index+1个元素的全排列
            swap(data, index, i);
            getAllPermutation(data, index + 1, results);
            swap(data, i, index);
        }
    }

    private static void swap(int[] data, int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    private static boolean isValid(List<Integer> result) {
        return isValid(result, new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}) &&
                isValid(result, new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}) &&
                isValid(result, new int[]{1, 2, 5, 6}, new int[]{3, 4, 7, 8});
    }

    private static boolean isValid(List<Integer> result, int[] nums1, int[] nums2) {
        int sum1 = 0;
        for (int num1 : nums1) {
            sum1 += result.get(num1 - 1);
        }
        int sum2 = 0;
        for (int num2 : nums2) {
            sum2 += result.get(num2 - 1);
        }
        return sum1 == sum2;
    }


}
