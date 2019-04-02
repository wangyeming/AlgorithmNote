/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class JAVA_42 {

    //对于每一个柱子，它能接受的雨水的高度取决于左右两边最高的柱子的高度
    public int trap(int[] height) {
        int result = 0;
        for(int i = 1; i< height.length-1;i++) {
            int leftBigestIndex = findBiggest(height, 0, i-1, true);
            if(height[leftBigestIndex] <= height[i]) {
                continue;
            }
            int rightBigestIndex = findBiggest(height, i+1, height.length-1, false);
            if(height[rightBigestIndex] <= height[i]) {
                continue;
            }
            int min = height[leftBigestIndex] > height[rightBigestIndex] ? height[rightBigestIndex] : height[leftBigestIndex];
            result += (min - height[i]);
        }
        return result;
    }

    private static int findBiggest(int[] height, int s, int e, boolean isLeft) {
        int bigestIndex = s;
        for(int i=s;i<=e;i++) {
            if(height[i] == height[bigestIndex]) {
                if(isLeft) bigestIndex = i;
            } else if(height[i] > height[bigestIndex]) {
                bigestIndex = i;
            }
        }
        return bigestIndex;
    }
}
