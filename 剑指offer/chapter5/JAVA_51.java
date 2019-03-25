package chapter5;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数
 * <p>
 * 考察点：归并排序
 */
public class JAVA_51 {

    public static void main(String[] args) {
        int[] data = new int[]{7, 5, 6, 4};
        System.out.println(getInversePairs(data));
        //结束后，原数组变为[5,7,4,6]，copy数组是排好序的[4,5,6,7]
        System.out.println(Arrays.toString(data));
    }

    public static int getInversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return _getInversePairs(data, copy, 0, data.length - 1);
    }

    //借助思想是归并排序,借助O(n)的辅助空间，实现时间复杂度从O(n^2)=>O(nlogn)的下降
    //[7, 5, 6, 4]  => [7,5], [6,4] => [7], [5], [6], [4]
    //[7], [5] => [5,7]  count+1, [6], [4] => [4,6] count+1
    //[5,7], [4,6] => [0,0,0,7] count+2 => [0,0,6,7] => [0,5,6,7] count+1 => [4,5,6,7]
    private static int _getInversePairs(int[] data, int[] copy, int start, int end) {
        if (start == end) {
//            copy[start] = data[end];
            return 0;
        }
        int length = (end - start) / 2;
        //这里需要交换data和copy，目的是，上一次的修改结果，应该是下一次比较时的参靠对象
        //比如说[7, 5, 6, 4]经过第一轮比较后，应该变为[5,7,4,6]，消除已经统计过的逆序组合
        int leftCount = _getInversePairs(copy, data, start, start + length);
        int rightCount = _getInversePairs(copy, data, start + length + 1, end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        //[start, start + length]和[start + length + 1, end]
        //以[5,7]和[4,6]为例，先讲两个指针分别指到两个子数组的末尾(start+length,end)
        //如果是前面的大，说明存在逆序对，并且，逆序对的数量是j - start - length
        //不管谁的大，都将这个元素复制到copy里，并且向前移动copy和大的子数组的指针。
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        //将剩余元素都拷贝到copy里面
        for (; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = data[j];
        }
        return leftCount + rightCount + count;
    }

}