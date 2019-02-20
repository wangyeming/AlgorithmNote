package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] argv) {


        int[] data = new int[8];
        data[0] = 1;
        data[1] = 2;
        data[2] = 3;
        data[3] = 4;
        data[4] = 5;
        data[5] = 6;
        data[6] = 7;
        data[7] = 8;
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void heapSort(int[] array) {
        /*
         * 第一步：将数组堆化
         * beginIndex = 第一个非叶子节点。
         * 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = array.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len, array);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(0, i, array);
            maxHeapify(0, i - 1, array);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private static void maxHeapify(int index, int len, int[] arr) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;      // 右子节点索引
        int cMax = li;       // 子节点值最大索引，默认左子节点。
        if (li > len) {
            return;    // 左子节点索引超出计算范围，直接返回。
        }
        if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
        {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            swap(cMax, index, arr);   // 如果父节点被子节点调换，
            maxHeapify(cMax, len, arr); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
}
