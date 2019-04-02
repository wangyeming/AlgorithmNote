package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找和为定值的多个数
 * <p>
 * 输入两个整数n和sum,要求从数列1,2,3,...,n中随意取出几个数，使得它们的和等于sum，请将所有可能的组合列出来。
 */
public class JAVA_2_3_1 {

    public static void main(String[] argv) {
        List<List<Integer>> results = sumOfK(20, 8);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

    public static List<List<Integer>> sumOfK(int n, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        _sumOfK(n, sum, new ArrayList<>(), results);
        return results;
    }

    //这题用递归的思路，
    //  {假设取第n个数，   _sumOfK(n-1, sum-n)
    //  {假设不取第n个数,  _sumOfK(n-1, sum)
    public static void _sumOfK(int n, int sum, List<Integer> result, List<List<Integer>> results) {
        if (n <= 0 || sum <= 0) {
            return;
        }
        result.add(0, n);
        if (sum == n) {
            results.add(new ArrayList<>(result));
        }
        _sumOfK(n - 1,sum - n,result, results);
        result.remove(0);
        _sumOfK(n - 1, sum, result, results);
    }

}
