package chapter6;

import java.util.Arrays;

/**
 * 数组中数字出现的次数
 * <p>
 * 一个整型数组里除两个数字外，其它数字都出现了两次。请写出程序找出这两个数字。要求时间复杂度是O(n),空间复杂度是O(1)
 * <p>
 * 考察点：二进制和位运算
 */
public class JAVA_56_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoNumberAppearOnce(new int[]{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 4, 5})));
    }

    //这题巧妙之处在于，如何把找两个只出现一次的数字转换成找一个。
    //找一个可以用异或，找两个的话，可以先用异或的结果来讲数组一分为二，保证两个数单独落在两个区间
    public static int[] findTwoNumberAppearOnce(int[] array) {
        int[] result = new int[2];
        if (array == null || array.length < 2) {
            return result;
        }
        int resultXor = 0;
        for (int num : array) {
            resultXor ^= num;
        }
        //两个不同int值的异或的值，二进制里至少有1位是1，我们找到结果中最右边第一个1
        int bitIndex = findFirstBitIs1(resultXor);
        int num1 = 0, num2 = 0;
        for (int num : array) {
            if (isBit1(num, bitIndex)) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        result[0] = num1;
        result[1] = num2;
        return result;
    }

    //找到number二进制中最低位的1的index
    private static int findFirstBitIs1(int number) {
        int bitIndex = 0;
        while ((number & 1) == 0 && bitIndex < Integer.SIZE) {
            number = number >> 1;
            bitIndex++;
        }
        return bitIndex;
    }

    private static boolean isBit1(int number, int bitIndex) {
        number = number >> bitIndex;
        return (number & 1) == 1;
    }
}
