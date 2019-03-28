package chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字(约瑟夫环)
 * <p>
 * 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始,每次从这个圆圈中删除第m个数字，求出这个圆圈里最后剩下的数字。、
 * <p>
 * 考察点：环形链表，数学
 */
public class JAVA_62 {

    public static void main(String[] args) {
        System.out.println(lastRemaining1(5, 3));
        System.out.println(lastRemaining2(5, 3));
        System.out.println(lastRemaining3(5, 3));
    }

    //模拟环状链表,这个方法比较直观，但是效率低
    public static int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        int current = 0;
        while (numbers.size() > 1) {
            for (int i = 1; i < m; i++) {
                current++;
                if (current == numbers.size()) {
                    current = 0;
                }
            }
//            System.out.println("remove " + numbers.get(current));
            numbers.remove(current);
            if (current == numbers.size()) {
                current = 0;
            }
        }
        return numbers.get(current);
    }

    //利用数学公式进行推导:
    //         {0               n=1
    //f(n,m) = {
    //         {[f(n-1)+m]%n    n>1
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    //递归写法
    public static int lastRemaining3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemaining3(n - 1, m) + m) % n;
    }
}
