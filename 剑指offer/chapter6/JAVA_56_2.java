package chapter6;

import java.security.InvalidParameterException;

/**
 * 数组中唯一只出现一次的数字
 * <p>
 * 在一个数组中除一个数字只出现一次外，其它数字都出现了三次，找到该数字。
 * <p>
 * 考察点：位运算
 */
public class JAVA_56_2 {

    public static void main(String[] args) {
        System.out.println(findAppearOnce(new int[]{2, 3, 4, 2, 3, 7, 4, 2, 3, 4}));
    }

    //思路是，把所有元素按位求和，不能被3整除的位就是只出现一次的数字的位1
    public static int findAppearOnce(int[] array) {
        if (array == null || array.length == 0) {
            throw new InvalidParameterException();
        }
        int[] bits = new int[Integer.SIZE];
        for (int i1 : array) {
            int bitMask = 1;
            for (int j = bits.length - 1; j >= 0; j--) {
                //数组里所有元素二进制的位数按位求和
                int bit = i1 & bitMask;
                if (bit != 0) {
                    bits[j]++;
                }
                // 000001 -> 000010
                bitMask = bitMask << 1;
            }

        }
        int result = 0;
        for (int bit : bits) {
            //从高位向地位赋值，左移
            result = result << 1;
            //不能被3整除，表示该数的该位的值为1
            result += bit % 3;
//            if(bit % 3 != 0) {
//                result += 1;
//            }

        }
        return result;
    }

}
