package chapter2;

import java.util.Arrays;

public class JAVA_4 {

    public static void main(String[] argv) {
        int[][] data = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(findPositionInYoungArray(data, 11)));

    }

    public static int[] findPositionInYoungArray(int[][] array, int target) {
        int[] position = new int[]{-1, -1};
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
