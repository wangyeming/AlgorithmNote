package chapter3;

/**
 * 数值的整数次方
 * <p>
 * 不得使用库函数，不考虑大数问题
 * <p>
 * 考察点：代码的全面性
 */
public class JAVA_16 {

    public static void main(String[] argv) {
        System.out.println(power(1, 0));
        System.out.println(power(2, 1));
        System.out.println(power(2, 2));
        System.out.println(power(2, -2));
        System.out.println(power(2, 0));
        System.out.println(power(2.3, -4));
    }

    //基于公式
    //      {   a^(n/2) * a^(n/2)                       n为偶数
    //a^n =
    //      {   a^((n-1)/2)) * a^((n-1)/2)) * a         n为偶数
    private static double power(double base, int exponent) {
        if (exponent < 0 && Double.compare(base, 0.0) == 0) {
            //幂指数小于0，分母不能为0
            throw new RuntimeException();
        }
        int absExponent = exponent > 0 ? exponent : 0 - exponent;
        double result = _power(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private static double _power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //右移替代除以2
        double result = _power(base, exponent >> 1);
        result *= result;
        //利用与1做位与，判断奇偶数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
}
