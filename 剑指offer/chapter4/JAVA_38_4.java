package chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后问题
 * <p>
 * 在8*8的国际象棋上摆放了8个皇后，使其不能互相攻击，即任意两个皇后不得处于同一行，同一列或者同一对角线上。
 * 求共有多少种摆放方式。
 * <p>
 * 考察点:全排列
 */
public class JAVA_38_4 {

    public static void main(String[] argv) {
        System.out.println(eightQueen());
    }

    //思路是把问题转换成求8个不同数的全排列
    public static int eightQueen() {
        //第i个元素表示第i行，元素值表示第i列
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7};
        List<List<Integer>> results = new ArrayList<>();
        //求全排列也就是求出了所有不同行同列的摆法
        getAllPermutation(data, 0, results);
        int count = 0;
        //检查对角线是否合法
        for (List<Integer> result : results) {
            System.out.println(result);
            if (isValid(result)) {
                count++;
            }
        }
        return count;
    }

    private static void getAllPermutation(int[] data, int index, List<List<Integer>> results) {
        if (index == data.length - 1) {
            //当进行到最后一个字符时，表示所有的交换操作已经结束，这时需要输出结果
            List<Integer> result = new ArrayList<>();
            for (int num : data) {
                result.add(num);
            }
            results.add(result);
            return;
        }
        for (int i = index; i < data.length; i++) {
            //交换index和第i个元素之后，问题转成后面index+1个元素的全排列
            swap(data, index, i);
            getAllPermutation(data, index + 1, results);
            swap(data, i, index);
        }
    }

    private static void swap(int[] data, int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    private static boolean isValid(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (inOneDiagonal(result, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //是否在同一对角线上
    private static boolean inOneDiagonal(List<Integer> result, int i, int j) {
        return (i - j) == (result.get(i) - result.get(j))
                ||
                (j - i) == (result.get(i) - result.get(j));

    }
}