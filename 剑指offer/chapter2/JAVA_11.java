package chapter2;

//旋转数组中的最小数字
public class JAVA_11 {

    public static void main(String[] argv) {
        int[] raw_array = new int[]{1, 2, 3, 4, 5};
        int[] raw_array2 = new int[]{2, 3, 4, 5, 1};
        int[] raw_array3 = new int[]{3, 4, 5, 1, 2};
        int[] raw_array4 = new int[]{4, 5, 1, 2, 3};
        int[] raw_array5 = new int[]{5, 1, 2, 3, 4};
        int[] raw_array6 = new int[]{1, 0, 1, 1, 1};
        int[] raw_array7 = new int[]{1, 1, 1, 0, 1};

//        System.out.println(findMin(raw_array));
        System.out.println(findMin(raw_array2));
        System.out.println(findMin(raw_array3));
        System.out.println(findMin(raw_array4));
        System.out.println(findMin(raw_array5));
        System.out.println(findMin(raw_array6));
        System.out.println(findMin(raw_array7));
    }

    public static int findMin(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int start = 0;
        int end = array.length - 1;
        int middle = (end + start) / 2;
        if (array[start] < array[end]) {
            //例如[1,2,3,4,5] => [1,2,3,4,5]
            //说明没有旋转(旋转值为0）
            return array[start];
        } else if (array[start] == array[end] && array[middle] == array[start]) {
            //[0,1,1,1,1] => [1,0,1,1,1],[1,1,1,0,1]
            //这种情况只能顺序查找
            int min = array[0];
            for (int value : array) {
                if (value < min) {
                    min = value;
                }
            }
            return min;
        }
        while (array[start] >= array[end]) {
            System.out.println("start " + start + " end " + end + " middle " + middle);
            if (end - start == 1) {
                middle = end;
                break;
            }
            if (array[middle] < array[start]) {
                //[5,1,2,3,4], 2<5,说明最小值在[start, middle]中间
                end = middle;
            } else {
                //[3,4,5,1,2], 5>3,说明最小值在[middle, end]中间
                start = middle;
            }
            middle = (end + start) / 2;
        }
        System.out.println("start " + start + " end " + end + " middle " + middle);
        return array[middle];

    }

}
