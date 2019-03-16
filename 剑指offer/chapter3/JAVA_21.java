package chapter3;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * [2,3,4,5,6,6] => [3,5,2,4,6,6]
 * <p>
 * 考察点：前后指针
 */
public class JAVA_21 {

    public static void main(String[] argv) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        resort(array1);
        System.out.println(Arrays.toString(array1));
    }

    public static void resort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && isOdd(array[start])) {
                start++;
            }
            while (end > start && !isOdd(array[end])) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }
    }

    private static boolean isOdd(int value) {
        return (value & 0x1) == 1;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
