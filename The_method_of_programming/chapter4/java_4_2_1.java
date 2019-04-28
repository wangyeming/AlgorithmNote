package chapter4;

import java.util.Arrays;

/**
 * 行列递增矩阵的查找
 */
public class java_4_2_1 {

    public static void main(String[] argv) {
        //4行5列
        int[][] matrix = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = i * 5 + j;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("行数 " + matrix.length);
        System.out.println("列数 " + matrix[0].length);
        System.out.println(Arrays.toString(findPositionInMatrix(matrix, 13)));

    }

    public static int[] findPositionInMatrix(int[][] matrix, int searchKey) {
        int[] position = new int[]{-1, -1};
        int ROW = matrix.length;
        int COLUMN = matrix[0].length;
        //初始元素是右上角的元素，第0行，第COLUMN列
        int i = 0;       //列
        int j = COLUMN - 1; //行
        int value = matrix[i][j];
        while (true) {
            if (value == searchKey) {
                position[0] = i;
                position[1] = j;
                break;
            }
            //如果元素比目标值大，向左移动，也就是列数减1
            if (value > searchKey && j > 0) {
                j--;
                value = matrix[i][j];
            } else if (value < searchKey && i < ROW - 1) {
                i++;
                value = matrix[i][j];
            } else {
                break;
            }
        }
        return position;
    }
}
