import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 * <p>
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Java_238 {

    public static void main(String[] argv) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
//
//    public static int[] productExceptSelf(int[] nums) {
//        if (nums == null || nums.length == 0) return null;
//        int[] output = new int[nums.length];
//        int[] product1 = new int[nums.length];
//        int[] product2 = new int[nums.length];
//        product1[0] = 1;
//        product2[nums.length - 1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            product1[i] = nums[i - 1] * product1[i - 1];
//        }
//        for (int i = nums.length - 2; i >= 0; i--) {
//            product2[i] = product2[i + 1] * nums[i + 1];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            output[i] = product1[i] * product2[i];
//        }
//        return output;
//    }

    //常数空间
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] output = new int[nums.length];
        output[0] = 1;
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
