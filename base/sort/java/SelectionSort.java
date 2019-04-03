package sort.java;

//选择排序
public class SelectionSort {

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            //每次从剩余没有排序的元素中，找出最小的，放到指定位置
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
