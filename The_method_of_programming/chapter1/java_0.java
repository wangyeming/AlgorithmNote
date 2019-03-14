package chapter1;

import java.util.Arrays;

public class java_0 {

    public static void main(String[] argv) {
        int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(Find(data, 6)));
    }

    public static int[] Find(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return new int[]{row, col};
            else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return new int[]{-1, -1};
    }
}
