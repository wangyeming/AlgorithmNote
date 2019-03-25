package chapter5;

/**
 * 丑数
 * <p>
 * 我们把只包含因子2，3和5的数称作丑数(Ugly Number。)求按从小到大的顺序的第1500个丑数。
 */
public class JAVA_49 {

    public static void main(String[] args) {

    }

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int multiply2 = uglyNumbers[0];
        int multiply3 = uglyNumbers[0];
        int multiply5 = uglyNumbers[0];

        while (nextUglyIndex < index) {
            int min = min(multiply2 * 2, multiply3 * 3, multiply5 * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (multiply2 * 2 < uglyNumbers[nextUglyIndex]) {
                multiply2++;
            }
            while (multiply3 * 3 < uglyNumbers[nextUglyIndex]) {
                multiply3++;
            }
            while (multiply5 * 5 < uglyNumbers[nextUglyIndex]) {
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
