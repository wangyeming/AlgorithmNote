import java.util.HashMap;

/**
 * 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class JAVA_128 {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, true);
        }
        int maxLength = 0;
        int currentLength = 0;
        for(int num: nums) {
            if(map.containsKey(num)) {
                currentLength = 1;
                for(int i = num-1;;i--) {
                    if(map.containsKey(i)) {
                        currentLength++;
                        map.remove(i);
                    } else {
                        break;
                    }
                }
                for(int i = num+1;;i++) {
                    if(map.containsKey(i)) {
                        currentLength++;
                        map.remove(i);
                    } else {
                        break;
                    }
                }
                if(currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 0;
            }
        }
        return maxLength;
    }
}
