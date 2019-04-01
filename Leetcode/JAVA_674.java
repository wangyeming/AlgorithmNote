/**
 * 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 */
public class JAVA_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int currentLength = 0;
        int lastNum = nums[0];
        for (int num : nums) {
            if (num <= lastNum) {
                currentLength = 1;
            } else {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
            lastNum = num;
        }
        return maxLength;
    }
}
