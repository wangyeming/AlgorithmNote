package sort.java;


//归并排序
public class MergeSort {

    public static void mergeSort(int[] array) {
        int[] sortArray = merge(array);
        for (int i = 0; i < sortArray.length; i++) {
            array[i] = sortArray[i];
        }
    }

    private static int[] merge(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        return _merge(merge(left), merge(right));
    }

    private static int[] _merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                result[i + j] = right[j];
                j++;
            } else {
                result[i + j] = left[i];
                i++;
            }
        }
        for (; i < left.length; i++) {
            result[i + j] = left[i];
        }
        for (; j < right.length; j++) {
            result[i + j] = right[j];
        }
        return result;
    }
}
