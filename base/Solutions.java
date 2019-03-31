import java.util.ArrayList;
import java.util.List;

public class Solutions {

    public static void main(String[] argv) {
//        int[] data = {7, 3, 2, 4, 8, 2, 3, 1};
        int[] data = {3, 11, 8, 16, 4, 15, 4, 17, 14, 14, 6, 6, 2, 8, 3, 12, 15, 20, 20, 5};
        System.out.println(findDuplicates(data));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int num : nums) {
            if (num < 1 || num > nums.length) {
                return result;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                if(nums[i] == -1) {
                    break;
                }
                if (nums[nums[i] - 1] == nums[i]) {
                    result.add(nums[i]);
                    nums[nums[i] - 1] = -1;
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}