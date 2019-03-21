package chapter5;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过了数组长度的一半，请找出这个数字
 */
public class JAVA_39 {

    public static void main(String[] argv) {
        System.out.println(findMoreThanHalfNum(new int[]{1, 2, 3, 2, 2}));
        System.out.println(findMoreThanHalfNum(new int[]{3, 2, 3, 2, 3}));
        System.out.println(findMoreThanHalfNum(new int[]{1, 2, 3, 2, 2, 4, 5, 2}));
    }

    //思路是：从头开始遍历，记录当前出现最多的数，如果下一个数是出现最多的数，次数+1，否则-1.
    //这样，如果存在超过一半的数，那最后记录的数肯定就是它。
    public static int findMoreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int times = 0;
        int moreNum = -1;
        for (int num : nums) {
            if (times == 0) {
                moreNum = num;
                times++;
            } else {
                if (num == moreNum) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        //检测数组中是不是不存在出现次数超过一半的数字
        if (!checkNumIsMoreThanHalf(nums, moreNum)) {
            return -1;
        }
        return moreNum;
    }

    private static boolean checkNumIsMoreThanHalf(int[] nums, int moreThanHalfNum) {
        int half = nums.length / 2;
        int count = 0;
        for (int num : nums) {
            if (num == moreThanHalfNum) {
                count++;
            }
            if (count > half) {
                return true;
            }
        }
        return false;
    }

}
