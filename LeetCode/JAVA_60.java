import java.util.ArrayList;
import java.util.List;

/**
 * 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
public class JAVA_60 {

    public static void main(String[] argv) {
        System.out.println(getPermutation(4, 14));
    }

    public static String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k < 1 || k > factorial(n)) {
            return "";
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder result = new StringBuilder();
        _getPermutation(nums, k, result);
        return result.toString();
    }

    private static void _getPermutation(List<Integer> nums, int k, StringBuilder result) {
        int n = nums.size();
        if(n == 1) {
            result.append(nums.get(0));
            return;
        }
        for (int i = 1; i <= n; i++) {
            int count = i * factorial(n - 1);
            if (k <= count) {
                result.append(nums.remove(i - 1));
                k -= (i-1) * factorial(n - 1);
                _getPermutation(nums, k, result);
                break;
            }
        }
    }

    private static int factorial(int n) {
        if (n < 1 || n > 9) {
            return -1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
