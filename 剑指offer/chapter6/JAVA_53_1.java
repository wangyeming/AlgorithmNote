package chapter6;

/**
 * 在排序数组中查找数字
 * <p>
 * 统计一个数字在排序数组中出现的次数
 * <p>
 * 考察点：二分法
 */
public class JAVA_53_1 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 3, 4, 5, 6, 7};
        int[] array2 = new int[]{1, 2, 3, 3};
        int[] array3 = new int[]{1, 2, 3};
        int[] array4 = new int[]{1, 2, 4};
        System.out.println(getNumberCount(array1, 3));
        System.out.println(getNumberCount(array2, 3));
        System.out.println(getNumberCount(array3, 3));
        System.out.println(getNumberCount(array4, 3));
    }

    //二分法先找到第一个的位置，再找到最后一个的位置，最后位置距离差
    //时间O(nlogn)
    public static int getNumberCount(int[] array, int k) {
        int firstPos = getFirstK(array, k);
        int lastPos = getLastK(array, k);
        if (firstPos != -1 && lastPos != -1) {
            return lastPos - firstPos + 1;
        }
        return 0;
    }

    private static int getFirstK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] > k) {
                right = middle - 1;
            } else if (array[middle] < k) {
                left = middle + 1;
            } else {
                if (middle - 1 < left) {
                    return middle;
                }
                if (array[middle - 1] == k) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }

    private static int getLastK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] > k) {
                right = middle - 1;
            } else if (array[middle] < k) {
                left = middle + 1;
            } else {
                if (middle + 1 > right) {
                    return middle;
                }
                if (array[middle + 1] == k) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }
}
