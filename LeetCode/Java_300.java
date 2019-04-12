import java.util.Arrays;

/**
 * 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Java_300 {

    public static void main(String[] argv) {
//        System.out.println(lengthOfLIS(new int[]{}));
//        System.out.println(lengthOfLIS(new int[]{1}));
//        System.out.println(lengthOfLIS(new int[]{1, 2}));

        System.out.println(lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));

    }

    //动态规划的思路，复杂度是O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for (int value : dp) {
            if (value > max) max = value;
        }
        return max;
    }

    //贪心加二分，时间复杂度是O(nlogn),空间复杂度O(n)
    public static int lengthOfLIS2(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int left = 0, right = maxL;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (dp[mid] < num)
                    left = mid + 1;
                else
                    right = mid;
            }
            dp[left] = num;
            if (left == maxL) maxL++;

        }
        return maxL;
    }
}
