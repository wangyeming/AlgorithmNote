package chapter2;

import java.util.Arrays;

/**
 * 合并两个排序数组
 * <p>
 * 两个排序数组A1，A2，内存在A1的末尾有足够多的多余空间可以荣来A2，把A2中所有的数字插入A1，并且保证排序。
 * <p>
 * 考察点：对内存覆盖的高度警惕，从后向前替换的技巧
 */
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
        //计算最终合并后的长度
        int end = length + array2.length - 1;
        //从后向前比较，所以需要两个尾指针
        int end1 = length - 1;
        int end2 = array2.length - 1;
        for (int i = end; i >= 0; i--) {
            if (end2 < 0) {
                //如果A2已经插入完了，只需要插入A1即可
                array1[i] = array1[end1];
                end1--;
                continue;
            }
            if (end1 < 0) {
                //同理，如果A1已经插入完了，只需要插入A2即可
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
