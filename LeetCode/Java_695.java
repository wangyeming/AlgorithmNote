/**
 * 岛屿的最大面积
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class Java_695 {

    //思路是回溯法，也就是深度优先
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int size = deepSearch(grid, i, j);
                if (size > max) max = size;
            }
        }
        return max;
    }

    private static int deepSearch(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + deepSearch(grid, i - 1, j) + deepSearch(grid, i, j - 1) + deepSearch(grid, i + 1, j) + deepSearch(grid, i, j + 1);
    }
}
