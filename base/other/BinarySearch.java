package other;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] argv) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(array, 10));
    }

    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
