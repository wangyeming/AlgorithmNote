package chapter2;

/**
 * 机器人的运动范围
 * <p>
 * 机器人从[0,0]出发，对于[i.j]，只有i，j的各位数的数字之和小于等于阈值，那么才表示能进入。求总共能进入多少个点。
 * <p>
 * 考察点：回溯法，二维数组的操作
 */
public class JAVA_13 {

    public static void main(String[] argv) {
        System.out.println(getMovingCount(10, 10, 2));
    }

    public static int getMovingCount(int rows, int cols, int threshold) {
        boolean[][] visited = new boolean[rows][cols];
        return getMovingCountCore(rows, cols, threshold, 0, 0, visited);

    }

    private static int getMovingCountCore(int rows, int cols, int threshold, int row, int col,
                                          boolean[][] visited) {
        if (row >= rows || col >= cols || row < 0 || col < 0 || visited[row][col]) {
            return 0;
        }
        int count = 0;
        if (isAllow(threshold, row, col)) {
            //如果能进入[row,col],再判断能否进入上下左右四个点
            visited[row][col] = true;
            count = 1 + getMovingCountCore(rows, cols, threshold, row, col - 1, visited)
                    + getMovingCountCore(rows, cols, threshold, row - 1, col, visited)
                    + getMovingCountCore(rows, cols, threshold, row, col + 1, visited)
                    + getMovingCountCore(rows, cols, threshold, row + 1, col, visited);
        }
        return count;
    }

    private static boolean isAllow(int threshold, int row, int col) {
        return getDigitSum(row) + getDigitSum(col) <= threshold;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
