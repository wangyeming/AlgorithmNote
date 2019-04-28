package chapter4;


/**
 * 有序数组的查找
 * <p>
 * 给定一个排好序的数组，查找某个数是否在这个数组中
 */
public class java_4_1 {

    public static void main(String[] argv) {
        int[] sortedNum = {1, 3, 5, 6, 8, 10};
        System.out.println(findTargetInSortNums(sortedNum, 2));
        System.out.println(findTargetInSortNums(sortedNum, 6));
    }

    //就是二分法
    public static boolean findTargetInSortNums(int[] sortedNum, int target) {
        if (sortedNum == null || sortedNum.length == 0) return false;
        int left = 0, right = sortedNum.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (sortedNum[mid] > target) {
                right = mid - 1;
            } else if (sortedNum[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
