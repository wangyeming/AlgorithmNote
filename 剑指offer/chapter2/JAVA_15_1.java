package chapter2;

/**
 * 二进制中1的个数
 */
public class JAVA_15_1 {

    public static void main(String[] argv) {
        for (int i = 0; i < 10; i++) {
            System.out.println("数" + i + "二进制中1的个数 " + get1Count(i));
        }
    }

    //利用的原理是 一个数与该数-1做位与，可以把二进制中最右边的1变成0
    public static int get1Count(int number) {
        int count = 0;
        while (number != 0) {
            number = number & (number - 1);
            count++;
        }
        return count;
    }
}
