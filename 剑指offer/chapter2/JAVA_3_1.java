package chapter2;

import java.util.ArrayList;
import java.util.List;

public class JAVA_3_1 {

    public static void main(String[] argv) {
        int[] data = new int[]{1, 2, 3, 4, 5, 7, 8, 8, 9, 1, 2, 3, 4, 6, 6};
        List<Integer> results = findAllRepeatNum(data);
        System.out.println(results);
    }

    public static List<Integer> findAllRepeatNum(int[] array) {
        List<Integer> repeatNumArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                continue;
            }
            while (true) {
                if (array[i] != i) {
                    if (array[i] == array[array[i]]) {
                        repeatNumArray.add(array[i]);
                        break;
                    } else {
                        swap(array, i, array[i]);
                    }
                } else {
                    break;
                }
            }
        }
        return repeatNumArray;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
