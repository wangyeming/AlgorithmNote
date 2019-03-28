package chapter6;

/**
 * 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用『+』、『-』、『*』、『/』四则运算符号。
 * <p>
 * 考察点：位运算
 */
public class JAVA_65_1 {

    public static void main(String[] args) {
        System.out.println(add(12, 8));
    }

    //两个数相加可以拆分成如下步骤：(以5和7为例)
    //1. 只做各位相加，不做进位（2）
    //2. 只计算进位(10)
    //3. 两数相加(12)
    //同理，二进制的位运算也是一样的步骤(以101和10001为例)
    //1. 只做各位相加，不做进位(10100)
    //2. 只计算进位(10)
    //3. 两数相加(10110)
    //仔细分析，第一个其实就是异或操作，第二步先位与再左移1位，第三步可以递归重复第一，第二步
    public static int add(int number1, int number2) {
        int sum, carry;
        do {
            sum = number1 ^ number2;
            carry = (number1 & number2) << 1;
            number1 = sum;
            number2 = carry;
        } while (number2 != 0);
        return number1;
    }

}
