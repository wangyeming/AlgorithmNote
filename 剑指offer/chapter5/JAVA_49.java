package chapter5;

/**
 * 丑数
 * <p>
 * 我们把只包含因子2，3和5的数称作丑数(Ugly Number。)求按从小到大的顺序的第1500个丑数。习惯上1作为第一个丑数。
 * <p>
 * 考察点：时间，空间复杂度的计算。
 */
public class JAVA_49 {

    public static void main(String[] args) {
        getUglyNumber(11);
    }

    //一般的做法是遍历每一个数，判断是否为丑数，优点是直观，不占额外空间，缺点是速度慢
    //这里借助了O(n)的辅助空间，假设[1,2,3,4,5,6],持有3个index，分别用于指向第一个*2大于6的数，
    //分别用于指向第一个*3大于6的数和分别用于指向第一个*5大于6的数，每次判断哪个数*对应因数最大，
    //就把结果添加进去，然后对应index+1
    //借助的原理就是：丑数的因子只有2，3，5，丑数一定是丑数的乘积
    public static int getUglyNumber(int index) {
        System.out.println("getUglyNumber " + index);
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        while (nextUglyIndex < index) {
            int min = min(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3,
                    uglyNumbers[multiply5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyIndex]) {
                multiply2++;
            }
            while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyIndex]) {
                multiply3++;
            }
            while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyIndex]) {
                multiply5++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    private static int min(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        min = (min < n3) ? min : n3;
        return min;
    }
}
