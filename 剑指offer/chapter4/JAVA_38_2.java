package chapter4;

import java.util.Stack;

/**
 * 求字符的全组合
 * <p>
 * 输入n个字符，输出所有长度在m(1<=m<=n)的组合
 * <p>
 * 考察点：递归
 */
public class JAVA_38_2 {

    public static void main(String[] argv) {
//        printAllCombination(new char[]{'a', 'b', 'c'});
        printAllCombination2(new char[]{'a', 'b', 'c'});
    }

    //这是递归的解法
    public static void printAllCombination(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        for (int i = 1; i <= chars.length; i++) {
            _printAllCombination(chars, 0, i, new Stack<>());
        }
    }

    private static void _printAllCombination(char[] chars, int idx, int length, Stack<Character> result) {
        if (idx >= chars.length && length != 0) {
            //预期的长度没有达到，但是候选字符用完了
            return;
        }
        if (length == 0) {
            //达到的预期的长度
            for (Character character : result) {
                System.out.print(character + ",");
            }
            System.out.println();
            return;
        }
        result.push(chars[idx]);
        //n-1中组合m-1长度
        _printAllCombination(chars, idx + 1, length - 1, result);
        result.pop();
        //n-1中组合m-1长度
        _printAllCombination(chars, idx + 1, length, result);
    }

    //每个字符存在与否可以用二进制的0，1表示
    //假设「abc」三个字符，那么一共有2^3=8种状态,即000，001，010，011，100，101，110，111
    //然后a,b,c三种状态，可以用2^0,2^1,2^2,即001，010，100来表示
    //通过位与运算(总状态 分别& a,b,c三种状态)，可以得出abc三个字符是否存在
    public static void printAllCombination2(char[] chars) {
        for (int i = 0; i < (1 << chars.length); i++) {
            for (int j = 0; j < chars.length; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(chars[j] + ",");
                }
            }
            System.out.println();
        }
    }
}