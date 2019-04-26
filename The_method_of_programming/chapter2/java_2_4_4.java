package chapter2;

/**
 * 长度最小的子数组
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和>=s的长度最小的连续子数组，如果不存在符合条件的连续子数组，返回0。
 */
public class java_2_4_4 {

    public static void main(String[] argv) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                //res = 0是窗口大小初始化，res > r - l + 1是窗口可以进一步缩小
                if(res == 0 || res > r - l + 1) res =  r - l + 1;
                sum -= nums[l++];
            }
        }
        return res;
    }
}
