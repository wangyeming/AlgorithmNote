package chapter2;

/**
 * 矩阵中的路径
 * <p>
 * 二维数组，元素是字母，给定一个单词，能否在数组中找到对应的单词
 * <p>
 * 考察点：回溯法，二维数组的操作
 */
public class JAVA_12 {

    public static void main(String[] argv) {
        char[][] matrix = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        System.out.println(hasPath(matrix, "bfce"));
        System.out.println(hasPath(matrix, "ec"));
        System.out.println(hasPath(matrix, "cde"));
    }

    /**
     * 本题的思路是回溯法
     */
    public static boolean hasPath(char[][] matrix, String target) {
        int rows = matrix.length;
        int cols = matrix.length > 0 ? matrix[0].length : 0;
        if (rows < 1 || cols < 1 || target.length() == 0) {
            return false;
        }
        char[] targetChars = target.toCharArray();
        //记录访问过的点，避免重复访问
        int[] targetStart = {0};
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //每个位置都可能是起点
                if (hasPathCore(matrix, row, col, targetChars, targetStart, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int row, int col, char[] targetChars, int[] targetStart,
                                       boolean[][] visited) {
        //给定任意一个点[row, col]位置，判断当前剩余的targetChars[targetStart[0]:]能否在矩阵中找到
        if (targetStart[0] == targetChars.length - 1) {
            //说明已经全部匹配上了
            return true;
        }
        int rows = matrix.length;
        int cols = matrix.length > 0 ? matrix[0].length : 0;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == targetChars[targetStart[0]]
                && !visited[row][col]) {
            targetStart[0]++;
            visited[row][col] = true;
            //分别找左上右下，顺时针找过去
            hasPath = hasPathCore(matrix, row, col - 1, targetChars, targetStart, visited)
                    || hasPathCore(matrix, row - 1, col, targetChars, targetStart, visited)
                    || hasPathCore(matrix, row, col + 1, targetChars, targetStart, visited)
                    || hasPathCore(matrix, row + 1, col, targetChars, targetStart, visited);
            if (!hasPath) {
                //如果这个点不符合要求，那么需要回溯，撤销这个点的记录
                targetStart[0] -= 1;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
