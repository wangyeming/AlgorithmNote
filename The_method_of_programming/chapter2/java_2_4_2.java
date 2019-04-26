package chapter2;

/**
 * 二维数组最大连续子数组
 * <p>
 * 有一个包含正数和负数的二维数组，找出和最大的连续子数组的和。
 */
public class java_2_4_2 {

    public static void main(String[] argv) {
        int[][] matrix = {
                {0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, -2}
        };
        System.out.println("max sum is " + maxSum(matrix));
    }

    //思路是将二维数组的最大子矩阵转换成求一维数组的最大连续子数组和。
    //先按照行遍历，求SMax(第一行), SMax(第一行+第二行), ..., SMax(第一行+第二行 + ...)
    //接着求SMax(第二行), SMax(第二行+第三行), ..., SMax(第二行+第三行 + ...)
    //最后SMax(第m行）
    //时间复杂度是O(n^3)
    public static int maxSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int col = matrix[0].length, row = matrix.length;
        for (int i = 0; i < row; i++) {
            int[] arr = new int[col];
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    arr[k] += matrix[j][k];
                }
                int arrMaxSum = maxSum(arr);
                max = Math.max(arrMaxSum, max);
//                System.out.println("i: " + i + " j: " + j + " arr " + Arrays.toString(arr) +
//                        " arrMaxSum " + arrMaxSum + " max " + max);
            }
        }
        return max;
    }

    //一维数组求连续子数组最大值
    private static int maxSum(int[] arr) {
        int max = 0, sum = 0;
        for (int value : arr) {
            if (sum <= 0) {
                sum = value;
            } else {
                sum += value;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
