package chapter5;

/**
 * 连续子数组最大的和
 * <p>
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组，求所有子数组中的和最大值。
 * <p>
 * 考察点：动态规划
 */
public class JAVA_42 {

    public static void main(String[] argv) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findMaxSumOfSubArray(data));
    }

    //本题的思路有两种
    //思路1. 按照示例开始推导，1，currentSum=1;-2 currentSum=-1;3 之前currentSum=-1<0,所以，放弃[1,-2,...]这种可能,所以currentSum==3,[3,...]
    //10 currentSum=13，-4 currentSum=9<13,所以我们还需要一个maxSum记录13，用来比较[3,10]和[3.10,-4,...]这两种情况
    //思路2. 动态规划法，状态转移方程为：
    //        { data[i]             i = 0 或 f(i-1) <= 0
    //f(i) =  {
    //        { f(i-1) + data[i]    i != 0 且 f(i-1) > 0
    public static int findMaxSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : array) {
            if (currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

}
