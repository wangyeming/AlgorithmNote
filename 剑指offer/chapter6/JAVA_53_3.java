package chapter6;

/**
 * 数组中数值和下标相等的元素
 * <p>
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。找出任意一个数值和下标相等的元素
 * <p>
 * 考察点：二分法
 */
public class JAVA_53_3 {
    public static void main(String[] args) {
        System.out.println(getNumberSameAsIndex(new int[]{-3, 0, 1, 3, 5}));
        System.out.println(getNumberSameAsIndex(new int[]{-3, 0, 1, 2, 4}));
        System.out.println(getNumberSameAsIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(getNumberSameAsIndex(new int[]{1, 2, 3, 4, 5}));
    }

    public static int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (middle > array[middle]) {
                left = middle + 1;
            } else if (middle < array[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
