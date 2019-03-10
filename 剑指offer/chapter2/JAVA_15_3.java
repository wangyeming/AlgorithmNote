package chapter2;

/**
 * 计算两个整数二进制中位数值的差异个数
 * <p>
 * 输入m，n，计算要改变m的二进制多少位才能得到n
 */
public class JAVA_15_3 {

    public static void main(String[] argv) {
        System.out.println("10需要调整 " + getChangeCount(10, 13) + "位，就可以变成13");
    }

    //利用的原理是 一个数与该数-1做位与，可以把二进制中最右边的1变成0
    public static int getChangeCount(int m, int n) {
        int value = m ^ n;
        int count = 0;
        while (value != 0) {
            value = value & (value - 1);
            count++;
        }
        return count;
    }
}
