package chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字符的所有组合
 *
 * 例如abc的所有组合就包括：a,b,c,ab,ac,bc,abc
 */
public class java_1_3_3 {

    public static void main(String[] argv) {
        String str = "ABC";
        List<String> results = getStrAllCombination(str);
        System.out.println(results.size());
        System.out.println(results);
    }

    //这题的思路是用位的0和1表示某个字符是否存在,那么ABC三个字符可以用000，001，010，011，100，101，110，111也就是2^3-1以内的数来表示
    public static List<String> getStrAllCombination(String str) {
        List<String> results = new ArrayList<>();
        int len = str.length();
        int n = 1 << len;   //左移len位也就是2^len
        //从1循环到2^len-1
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            //遍历每一位
            for (int j = 0; j < len; j++) {
                System.out.println("i " + i + " j " + j + " 1<< j " + (1 << j));
                if ((i & (1 << j)) != 0) {
                    //位1表示该字符存在
                    result.append(str.charAt(j));
                }
            }
            if (result.length() != 0) {
                results.add(result.toString());
            }
        }
        return results;
    }

}