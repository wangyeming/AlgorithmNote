package chapter5;

/**
 * 1~n整数中1出现的次数
 * <p>
 * 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。如n=12，那么包含1的数有1，10，11，12，共5次
 * <p>
 * 考察点：复杂问题的处理，如何按位处理每个数字
 */
public class JAVA_43 {

    public static void main(String[] argv) {
        System.out.println(numberOf1(-1));
        System.out.println(numberOf1(0));
        System.out.println(numberOf1(1));
        System.out.println(numberOf1(9));
        System.out.println(numberOf1(10));
        System.out.println(numberOf1(124));
        System.out.println(numberOf1(12345));
    }

    //假如n=21345，先分为两部分：1~1345，1346~21345
    //对于1346~21345这段，我们先计算万位是1的次数(10000~19999),一共是10^4次
    //对于其它位出现1的次数：也分为两部分：1346~11345，11346~21345
    //每一位都可能是1，其他位0~9,所以总共就是2*4*10^3
    //对于1~1345,可以参考前面的方式，递归处理
    public static int numberOf1(int n) {
        if (n < 1) {
            return 0;
        }
        return _numberOf1(n, toIntArray(n), 0);
    }

    private static int _numberOf1(int n, int[] nums, int startIdx) {
        if (nums == null || nums.length == 0 || startIdx >= nums.length) {
            return 0;
        }
        int first = nums[startIdx];
        int length = nums.length - startIdx;
        if (length == 1 && first == 0) {
            // 0 -> 0
            return 0;
        }
        if (length == 1 && first > 0) {
            // 1-9 -> 1
            return 1;
        }
        //假如是12345，startIdx = 0，那么可以看做 1~1345 1346~21345
        //1346~21345中首位是1的个数
        int numberFirstDigit = 0;
        if (first > 1) {
            //假如n=21345，那么numberFirstDigit就是10^(l-1)
            numberFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            //假如n=11345，那么numberFirstDigit就是1135+1个
            numberFirstDigit = getNum(n, nums, startIdx) + 1;
        }
        //1346~21345中其它位是1的个数,1346~11345 11346~21345  2*4*10^(4-1)
        int numberOtherDigit = first * (length - 1) * powerBase10(length - 2);
        //1~2345中位1的个数
        int numRecursive = _numberOf1(n, nums, startIdx + 1);
        return numberFirstDigit + numberOtherDigit + numRecursive;
    }

    // 10^n
    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    //12345 -> [1,2,3,4,5]
    private static int[] toIntArray(int n) {
        char[] numArr = String.valueOf(n).toCharArray();
        int[] result = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            char num = numArr[i];
            result[i] = num - '0';
        }
        return result;
    }

    //[1,2,3,4,5], 0 -> 2345 , 1 -> 345, 2 -> 45, 3 -> 5
    private static int getNum(int n, int[] num, int startIdx) {
        int length = String.valueOf(n).length();
        if (startIdx >= length) {
            return -1;
        }
        for (int i = 0; i <= startIdx; i++) {
            n -= num[i] * powerBase10(length - 1 - i);
        }
        return n;
    }

}
