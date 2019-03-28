package chapter6;

import java.util.Arrays;

/**
 * 构建乘积数组
 * <p>
 * 给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法
 * <p>
 * 考察点：发散思维，数组
 */
public class JAVA_66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new int[]{1, 2, 3, 4, 5, 6})));
    }

    //如果可以用除法的话，只需要先计算s = A[0]*A[1]*...*A[n-1]，然后B[i] = s/A[i]
    //不能用除法的话，如果蛮力挨个算，那么会非常耗时O(n^2)
    //这里定义C[i] = A[0]*A[1]*...*A[i-1],定义D[i] = A[n-1]*A[n-2]*...*A[i+1]
    //B[i] = C[i] * D[i]，这里的C[i],D[i]都可以通过上一个值算出来
    //时间复杂度优化为O(n)
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        int[] C = new int[length];
        int[] D = new int[length];
        C[0] = 1;
        D[0] = 1;
        for (int i = 1; i < length; i++) {
            C[i] = A[i - 1] * C[i - 1];
            D[i] = A[length - i] * D[i - 1];
        }
        for (int i = 0; i < length; i++) {
            B[i] = C[i] * D[length - 1 - i];
        }
        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(D));
        return B;
    }
}
