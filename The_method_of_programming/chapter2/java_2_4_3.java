package chapter2;

/**
 * 乘积最大子序列
 * <p>
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class java_2_4_3 {
    public static void main(String[] argv) {
        int[] nums1 = new int[]{2, 3, -2, 4, -1};
        System.out.println(maxProduct(nums1));
    }


    //动态规划 已知以第i个元素结尾的连续子数组的乘积的最大值PMax(i),最小值为PMin(i)
    //              { max(PMax(i) * nums[i+1],  nums[i+1])  (nums[i+1] >= 0)
    // PMax(i+1) =  {
    //              { max(PMin(i) * nums[i+1],  nums[i+1])  (nums[i+1] < 0)

    //              { min(PMin(i) * nums[i+1],  nums[i+1])  (nums[i+1] >= 0)
    // PMin(i+1) =  {
    //              { min(PMax(i) * nums[i+1],  nums[i+1])  (nums[i+1] < 0)

    //2 > 0 imax = max(1*2, 2) = 2 imin = min(1*2, 2) = 2   max = 2
    //3 > 0 imax = max(2*3, 3) = 6 imin = min(2*3, 2) = 2   max = 6
    //-2 < 0 (swap imax = 2, imin = 6) imax = max(2*(-2), -2) = -2, imin = min(6*(-2), -2) -12   max = 6
    //4 > 0 imax = max(-2*4, 4) = 4 imin = min(-12 * 4, 4) = -48    max = 6
    //-1 < 0(swap imax = -48, imin = 4) imax = max(-48 * (-1), -48) = 48, imin = (4 * (-1), 4) = -4 max = -4
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }

}
