/**
 * 盛最多水的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Java_11 {

    /**
     * 左右指针的思路，高度低的一侧向另一侧靠拢
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int max = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            int leftHeight = height[left], rightHeight = height[right];
            int area = (right - left) * Math.min(leftHeight, rightHeight);
            if (area > max) max = area;
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
