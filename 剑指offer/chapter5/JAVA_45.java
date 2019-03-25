package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有的数字中最小的一个。
 * <p>
 * 考察点：排序规则，大数处理
 */
public class JAVA_45 {

    public static void main(String[] args) {
        printMinNumber(new Integer[]{3, 32, 321});
    }

    //这题的思路是这样，假设[m,n]两个数，mn和nm构成的两个数，mn>nm的话，那么[m,n] > [n,m]
    //类推到很多个数时，其实就变成了一个简单的排序
    public static void printMinNumber(Integer[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        MyComparator myComparator = new MyComparator();
        Arrays.sort(numbers, myComparator);
//        System.out.println(Arrays.toString(numbers));
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
        }
        System.out.println(result);
    }

    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            String str1 = String.valueOf(n1);
            String str2 = String.valueOf(n2);
            int value1 = Integer.valueOf(str1 + str2);
            int value2 = Integer.valueOf(str2 + str1);
            return Integer.compare(value1, value2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
