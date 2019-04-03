package sort.java;

/**
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本
 * <p>
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 * <p>
 * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。
 * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，
 * 但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        //这里初始步长选为n/2
        int step = array.length / 2;
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int current = array[i];
                int preIndex = i - step;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + step] = array[preIndex];
                    preIndex -= step;
                }
                array[preIndex + step] = current;
            }
            step = step / 2;
        }
    }
}
