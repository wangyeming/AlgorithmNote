package chapter6;

/**
 * 0~n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0-n-1之内，有且仅有一个数字不在该数组中，找出该数字。
 * <p>
 * 考察点：二分法
 */
public class JAVA_53_2 {

    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11};
        int[] array2 = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] array3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int[] array4 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] array5 = new int[]{0, 1};
        int[] array6 = new int[]{1};
        int[] array7 = new int[]{0};
        int[] array8 = new int[]{};
        int[] array9 = new int[]{1, 2};
        int[] array10 = new int[]{1, 2, 3};
        int[] array11 = new int[]{0, 0, 1, 2, 3};
        System.out.println(getMissingNumber(array1));
        System.out.println(getMissingNumber(array2));
        System.out.println(getMissingNumber(array3));
        System.out.println(getMissingNumber(array4));
        System.out.println(getMissingNumber(array5));
        System.out.println(getMissingNumber(array6));
        System.out.println(getMissingNumber(array7));
        System.out.println(getMissingNumber(array8));
        System.out.println(getMissingNumber(array9));
        System.out.println(getMissingNumber(array10));
        System.out.println(getMissingNumber(array11));
    }

    public static int getMissingNumber(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (array[middle] < middle) {
                //有重复元素
                return -1;
            }
            if (array[middle] > middle) {
                if (middle == 0) {
                    //缺失数字0
                    return middle;
                }
                right = middle - 1;
            } else {
                if (middle + 1 > right) {
                    //没有缺失任何数字
                    return -1;
                }
                if (array[middle + 1] > middle + 1) {
                    return middle + 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
