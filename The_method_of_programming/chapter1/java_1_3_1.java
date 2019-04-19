package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串的全排列
 */
public class java_1_3_1 {

    public static void main(String[] argv) {
        String str = "aa";
        List<String> results = permutation1(str);
        System.out.println(results.size());
        System.out.println(results);
    }

    //递归实现
    public static List<String> permutation1(String str) {
        HashSet<String> resultSet = new HashSet<>();
        if (str == null || str.length() <= 0) {
            return new ArrayList<>();
        }
        _permutation1(str.toCharArray(), 0, str.length() - 1, resultSet);
        return new ArrayList<>(resultSet);
    }

    //思路是：第一次第一位固定为a，后面bc，然后交换为cb，第二次第一位固定为b，后面ac，然后交换为ca
    //递归的写法，时间复杂度是O(n!)
    public static void _permutation1(char[] chars, int from, int to, HashSet<String> result) {
        if (from == to) {
            result.add(Arrays.toString(chars));
            return;
        }
        for (int i = from; i <= to; i++) {
            swap(chars, i, from);
            _permutation1(chars, from + 1, to, result);
            swap(chars, from, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        if (i != j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    //解法二的思路是字典序排序，假设1,2,3,4,5,那么12345<12354<12534<...
    //不停的找下一个排列，直到找不到为止。
    public static List<String> permutation2(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        result.add(Arrays.toString(chars));
        while (true) {
            if (nextPermutation(chars)) {
                result.add(Arrays.toString(chars));
            } else {
                break;
            }
        }
        return result;
    }

    //对于任意一个排列，如何求它的下一个排列呢？
    //以21543为例，先从后向前找到第一个右边的数大于自己的数，这里也就是1
    //然后再次从后向前找到第一个比1大的数，也就是3，交换了1和3，也就是23541
    //最后，翻转541->145,也就是23145
    private static boolean nextPermutation(char[] chars) {
        int i = 0;
        for (i = chars.length - 2; i >= 0 && chars[i] >= chars[i + 1]; i--) ;
        if (i < 0) {
            return false;
        }
        int k = 0;
        for (k = chars.length - 1; k > i && chars[k] <= chars[i]; k--) ;
        swap(chars, i, k);
        reverse(chars, i + 1, chars.length - 1);
        return true;
    }

    private static void reverse(char[] str, int s, int e) {
        while (s < e) {
            char tmp = str[s];
            str[s++] = str[e];
            str[e--] = tmp;
        }
    }

//    public static List<String> permutation2(String str) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            map.put(str.charAt(i), 0);
//        }
//        List<String> results = new ArrayList<>();
//        int length = 0;
//        while (length < str.length()) {
//            List<String> newResults = new ArrayList<>();
//            for (Character key : map.keySet()) {
//                if (length > 0) {
//                    for (String result : results) {
//                        newResults.add(result + key);
//                    }
//                } else {
//                    newResults.add(String.valueOf(key));
//                }
//            }
//            length++;
//            results = newResults;
//        }
//        return results;
//    }

}