package chapter4;

/**
 * 顺时针打印矩阵
 * <p>
 * 考察点：观察临界调节
 */
public class JAVA_29 {

    public static void main(String[] argv) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
        };
        printMatrixClockwisely(matrix);
    }

    //首先判断什么时候圈停止
    //每圈的起点是(0,0),(1,1),(2,2)...，如果5*5的话，2*2是最后一圈的起点，7*7,3*3是最后一圈起点
    //起点(k, k) 总要满足 k*2 < column and k*2 < rows
    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int columns = matrix[0].length;
        int rows = matrix.length;
        //圈数
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printCircle(matrix, start);
            start++;
        }
    }

    //打印一圈，最后一圈可能不完整，可能只有一边，两边，三边
    public static void printCircle(int[][] matrix, int start) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        //此时起点的坐标是(start, start)
        //每转一圈，这一圈最终结束的行和列分别需要减去start
        int endRow = rows - 1 - start;
        int endColumn = columns - 1 - start;

        //从左向右  →   (start, start)  ->  (start, endColumn)
        for (int i = start; i <= endColumn; i++) {
            System.out.println(matrix[start][i]);
        }


        //从上向下  ↓   (start+1, endColumn) -> (endRow, endColumn)
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.println(matrix[i][endColumn]);
            }
        }

        //从右向左  ←   (endRow, endColumn-1) -> (endRow, start)
        if (start < endColumn && start < endRow) {
            for (int i = endColumn - 1; i >= start; i--) {
                System.out.println(matrix[endRow][i]);
            }
        }

        //从下向上   ↑  (endRow - 1, start) -> (start + 1, start)
        if (start < endRow && start < endColumn - 1) {
            for (int i = endRow - 1; i >= start + 1; i--) {
                System.out.println(matrix[i][start]);
            }
        }
    }
}
