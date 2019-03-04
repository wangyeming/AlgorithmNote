package chapter2;

import java.util.Arrays;

//合并两个排序数组
public class JAVA_5_2 {

    public static void main(String[] argv) {
        int[] array1 = new int[20];
        array1[0] = 1;
        array1[1] = 5;
        array1[2] = 16;
        array1[3] = 21;
        array1[4] = 31;

        int[] array2 = new int[]{10, 11, 12, 21, 23, 31, 34, 45};
        mergeSortArray(array1, 5, array2);
        System.out.println(Arrays.toString(array1));
    }

    //思路是从两个数组的末端开始比较
    public static void mergeSortArray(int[] array1, int length, int[] array2) {
        int end = length + array2.length - 1;
        int end1 = length - 1;
        int end2 = array2.length - 1;
        for (int i = end; i >= 0; i--) {
            if(end2 < 0) {
                array1[i] = array1[end1];
                end1--;
                continue;
            }
            if(end1 < 0) {
                array1[i] = array2[end2];
                end2--;
                continue;
            }
            if (array2[end2] > array1[end1]) {
                array1[i] = array2[end2];
                end2--;
            } else {
                array1[i] = array1[end1];
                end1--;
            }
        }


    }
}
