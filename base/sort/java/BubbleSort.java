package sort.java;

//冒泡排序
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        boolean didSwap = false;
        for (int i = 0; i < array.length - 1; i++) {
            //每轮比较完，最大的数沉到底部
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    didSwap = true;
                }
            }
            if(!didSwap) {
                return;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
