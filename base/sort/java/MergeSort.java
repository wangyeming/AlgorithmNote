package sort.java;


//归并排序
public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] sortArray = merge(array);
        System.arraycopy(sortArray, 0, array, 0, sortArray.length);
    }

    private static int[] merge(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = new int[mid], right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        return _merge(merge(left), merge(right));
    }

    private static int[] _merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) result[i + j] = right[j++];
            else result[i + j] = left[i++];
        }
        if (i < left.length) System.arraycopy(left, i, result, i + j, left.length - i);
        if (j < right.length) System.arraycopy(right, j, result, i + j, right.length - j);
        return result;
    }
}
