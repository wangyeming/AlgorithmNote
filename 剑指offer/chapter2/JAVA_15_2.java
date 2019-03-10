package chapter2;

/**
 * 判断一个数是否是2的整数次幂
 */
public class JAVA_15_2 {

    public static void main(String[] argv) {
        for (int i = 0; i < 20; i++) {
            System.out.println("数" + i + "是否是2的整数次幂： " + is2Pow(i));
        }
    }

    //利用的原理是 一个数与该数-1做位与，可以把二进制中最右边的1变成0
    public static boolean is2Pow(int number) {
        return (number & (number - 1)) == 0;
    }
}
