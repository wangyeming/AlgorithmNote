package chapter6;

import java.util.Arrays;

/**
 * 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和数字s，在数组中查找任意两个数，使他们的和刚好为啥。
 * <p>
 * 考察点：左右指针
 */
public class JAVA_57_1 {

    public static void main(String[] args) {
        int[] result = new int[2];
        boolean find = findNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15, result);
        if (find) {
            System.out.println("find result " + Arrays.toString(result));
        } else {
            System.out.println("not find");
        }
    }

    //左右指针，和小于sum的，左边+1，大于sum的，右边-1
    public static boolean findNumbersWithSum(int[] array, int sum, int[] result) {
        if (array == null || array.length < 2) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                result[0] = array[start];
                result[1] = array[end];
                return true;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
