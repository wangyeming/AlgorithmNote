import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class JAVA_448 {

    //思路是：第一遍先遍历数组，把每个元素对应的index的元素取方
    //再次遍历数组，正数对应的index是缺失元素，负数对应的元素取反还原。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                if (nums[num - 1] > 0) {
                    nums[num - 1] = 0 - nums[num - 1];
                }
            } else {
                int index = -num - 1;
                if (nums[index] > 0) {
                    nums[index] = 0 - nums[index];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] = 0 - nums[i];
            }
        }
        return result;
    }
}
