/**
 * 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class JAVA_221 {

    public static void main(String[] argv) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(maximalSquare(matrix));
    }


    //动态规划的思路，对于任意一个点而言，考虑以这个点为右下角的情况，如果他是0，那这个点肯定构不成一个矩形，如果是1，那么需要考虑它的
    //左边，上边和左上角的三个点，以这个点为右下角的最大正方形的边长，一定是上述以三个点为右下角的最大正方形的边长中最小的那个值+1
    //也就是 dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int max = 0;
        for (int i = 0; i < columns; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
