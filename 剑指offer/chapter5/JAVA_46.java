package chapter5;

/**
 * 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译成字符串：
 * 0翻译成'a'，1翻译成'b'，11翻译成'l'，...，25翻译成'z'
 * 计算一个数字可能又多少种不同的翻译
 * <p>
 * 考察点：递归效率的理解
 */
public class JAVA_46 {

    public static void main(String[] args) {
        System.out.println(getTranslationCount(12258));
    }

    //本题可以看做斐波那契数列的变种题
    //递归效率会偏低
    //循环的话，从后向前遍历，到第i个数字的时候，
    //          { f(i+1)
    //f(i) =    {
    //          { f(i+1)+f(i+2)     //num[i] + num[i+1] >= 10 <= 25
    //以238为例，23是合法的，所以，2，3，8和23，8两种
    //以382为例，38不合法，所以，只有3，8，2一种
    public static int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        String numStr = String.valueOf(number);
        char[] numChar = numStr.toCharArray();
        int length = numChar.length;
        //count[i]表示以第i个数字开头的数的翻译方法数
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int count = 0;
            count = i < length - 1 ? counts[i + 1] : 1;
            if (i < length - 1) {
                int digit1 = numChar[i] - '0';
                int digit2 = numChar[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    count += i < length - 2 ? counts[i + 2] : 1;
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

}
