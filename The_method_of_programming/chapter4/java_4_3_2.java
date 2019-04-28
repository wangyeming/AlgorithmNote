package chapter4;

/**
 * 出现次数刚好是一半的数
 */
public class java_4_3_2 {

    public static void main(String[] argv) {
        System.out.println(findHalfNum(new int[]{4, 5, 6, 5, 6, 5, 5, 6}));
    }

    public static int findHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
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
        System.out.println("times1 " + times1 + " moreNum1 " + moreNum1);
        System.out.println("times2 " + times2 + " moreNum2 " + moreNum2);
        int moreNum = times1 > times2 ? moreNum1 : moreNum2;
        return moreNum;
    }
}
