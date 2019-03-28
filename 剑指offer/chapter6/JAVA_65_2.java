package chapter6;

/**
 * 交换两个变量
 * <p>
 * 不使用新的变量，交换两个变量的值
 */
public class JAVA_65_2 {

    public static void main(String[] args) {
        swap1(5, 7);
        swap2(5, 7);
    }

    public static void swap1(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a " + a + " b " + b);
    }

    public static void swap2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a " + a + " b " + b);
    }

}
