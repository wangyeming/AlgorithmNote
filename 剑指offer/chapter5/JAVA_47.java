package chapter5;

/**
 * 礼物的最大价值
 * <p>
 * 在一个mxn的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值(价值大于0)，你可以从棋盘的左上角开始
 * 拿格子里的礼物，并每次向右或者着向下移动一格，直到棋盘的右下角。求最多能拿到多少价值的礼物。
 * <p>
 * 考察点：动态规划
 */
public class JAVA_47 {

    public static void main(String[] args) {
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getMaxValue(values));
    }

    //首先，很容易想到f(i,j)的最大值就是f(i,j-1)和f(i-1,j)中的最大值。(左和上)。可以用递归
    //但是，递归的效率偏低，我们考虑用一个二维数组来做辅助空间，二维数组的辅助空间[i][j]表示第i行，第i列时最大的值。
    //进一步的，我们发现，f(i,j)的最大值只和f(i,j-1)和f(i-1,j)有关
    //  1   2   3   4   5
    //  6   7   *8  *9  *10
    //  *11 *12 #13 14  15
    //  16  17  18  19  20
    //  21  22  23  24  25
    //以上面的例子为例，假设我目前走到了13，那么其实我只需要存[8,9,10,11,12]就可以诶了，也就是说，我可以用一个一维数组来代替我刚才的二维数组
    //[f(i,0),f(i,1),...f(i,j-1),f(i-1,j),f(i-1,j+1), f(i-1, n)]  1*n即可
    public static int getMaxValue(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = i > 0 ? maxValues[j] : 0;
                int left = j > 0 ? maxValues[j - 1] : 0;
                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }
        return maxValues[cols - 1];
    }
}
