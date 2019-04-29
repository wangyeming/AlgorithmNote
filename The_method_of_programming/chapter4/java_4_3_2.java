package chapter4;

/**
 * 出现次数刚好是一半的数
 */
public class java_4_3_2 {

    public static void main(String[] argv) {
        System.out.println(findHalfNum(new int[]{4, 5, 6, 5, 6, 5, 5, 6}));
        System.out.println(findHalfNum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(findHalfNum(new int[]{5, 6, 5, 6, 5, 5, 6, 7}));
        System.out.println(findHalfNum(new int[]{5, 6, 5, 6, 5, 5, 6, 5}));
    }

    //如果是超过一半，我们的思路是一个变量记住当前次数最多的元素，但是问题就是如果恰好是一半,原来的办法变量就重置了
    //这里我们用两个变量，变量1记住值1，变量2记住值2，当出现变量3的时候，才去对变量1，2的次数--，这样就规避了上面的问题。
    //但是最后还是要对值进行校验，判断是不是真的占一半
    public static int findHalfNum(int[] nums) {
        if (nums == null || nums.length == 0 || (nums.length & 1) == 1) {
            return -1;
        }
        int times1 = 0, times2 = 0;
        int moreNum1 = -1, moreNum2 = -1;
        for (int num : nums) {
            if (times1 == 0) {
                moreNum1 = num;
                times1++;
            } else if (times2 == 0 && moreNum1 != num) {
                moreNum2 = num;
                times2++;
            } else {
                if (num == moreNum1) {
                    times1++;
                } else if (num == moreNum2) {
                    times2++;
                } else {
                    times1--;
                    times2--;
                }
            }
        }
        int moreNum = times1 > times2 ? moreNum1 : moreNum2;
        System.out.println("moreNum1: " + moreNum1 + " times1 " + times1);
        System.out.println("moreNum2: " + moreNum2 + " times2 " + times2);
        if (!checkNumIsMoreThanHalf(nums, moreNum)) {
            return -1;
        }
        return moreNum;
    }

    private static boolean checkNumIsMoreThanHalf(int[] nums, int moreThanHalfNum) {
        if ((nums.length & 1) == 1) return false;
        int half = nums.length / 2;
        int count = 0;
        for (int num : nums) {
            if (num == moreThanHalfNum) {
                count++;
            }
            if (count > half) {
                return false;
            }
        }
        if (count == half) {
            return true;
        }
        return false;
    }
}
