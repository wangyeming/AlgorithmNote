package chapter6;

/**
 * 和为s的连续正数序列
 * <p>
 * 输入一个正数s，打印出所有和为s的连续正数序列(至少含有两个数)
 * 例如输入15 1+2+3+4+5=4+5+6=7+8
 * <p>
 * 考察点：前后指针
 */
public class JAVA_57_2 {

    public static void main(String[] args) {
        printAllContinueSeq(15);
    }

    public static void printAllContinueSeq(int sum) {
        if (sum <= 2) {
            return;
        }
        int small = 1;
        int big = 2;
        int s = small + big;
        while (small <= ((1 + sum) >> 1) && (big - small) >= 1) {
            if (s > sum) {
                s -= small;
                small++;
            } else if (s < sum) {
                big++;
                s += big;
            } else {
                System.out.print("result: ");
                for (int i = small; i <= big; i++) {
                    System.out.print(i);
                    if (i != big) {
                        System.out.print('\t');
                    }
                }
                System.out.println();
                big++;
                s += big;
            }
        }
    }


}
