import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class Java_220 {

    public static void main(String[] argv) {
        int[][] data = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] datum : data) {
            List<Integer> array = new ArrayList<>();
            for (int i : datum) {
                array.add(i);
            }
            triangle.add(array);
        }
        System.out.println(minimumTotal(triangle));
    }

    //思路是把三角形倒过来，每一个元素要加上的最小值都是上一行的同列和同列+1中的最小值
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int column = 0; column < row; column++) {
                int min = Math.min(triangle.get(row).get(column), triangle.get(row).get(column + 1));
                int now = triangle.get(row - 1).get(column);
                triangle.get(row - 1).set(column, now + min);
            }
        }
        System.out.println(triangle);
        return triangle.get(0).get(0);
    }
}
