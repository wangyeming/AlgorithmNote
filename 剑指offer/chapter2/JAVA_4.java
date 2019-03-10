package chapter2;

import java.util.Arrays;

/**
 * 二维数组中的查找
 * <p>
 * 从左到右递增，从上到下递增的二维数组，给定一个数，返回位置
 * <p>
 * 考察点：一维数组的理解和编程能力
 */
public class JAVA_4 {

    public static void main(String[] argv) {
        int[][] data1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(findPositionInYoungArray(data1, 11)));
        System.out.println(Arrays.toString(findPositionInYoungArray(data1, 17)));

    }

    //思路是：右上角的元素作为起点，如果比target大，那么向左移动一位，如果比target小，那么向下移动一位
    //时间复杂度O(m+n)，空间复杂度O(1)
    public static int[] findPositionInYoungArray(int[][] array, int target) {
        int[] position = new int[]{-1, -1}; //定义如果没找到的坐标值
        //这里x，y理解为平面的直角坐标系，x其实是列数，y是行数
        int x = array[0].length - 1;
        int y = 0;
        while (x >= 0 && y < array.length) {
            int value = array[y][x];
            if (value < target) {
                y++;
            } else if (value > target) {
                x--;
            } else {
                position[0] = y;
                position[1] = x;
                break;
            }
        }
        return position;

    }
}
