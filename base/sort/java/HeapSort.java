package sort.java;

import java.util.Arrays;

/**
 * 1. 堆是什么？二叉堆是完全二叉树。完全二叉树和满二叉树的区别就是，对于树的深度h，前者只要求1-h-1深度的节点数达到了最大个数。后者额外要求h层也是。
 * 2. 把数组看成堆的层次遍历。对于完全二叉树任意一个节点i，它的左节点是2i+1, 右节点是2i+2，假设总共有n个节点，第一个非叶子节点的index是(n-2)/2
 * 3. 如何构建最大堆？首先要记住是从第一个非叶子节点开始，从下向上保证每个节点都是此刻最大的节点(否则的话，先换上面的，再换下面的时候，上面的又被破坏了)。交换父节点和子节点中最大的节点之后，要额外再递归调用最大的节点的构建最大堆方法，因为交换的时候，下面节点的最大堆特性也被破坏了。
 * 4. 最大堆构建完后，交换堆顶和最后一个元素，此时的完全二叉树结构，只需要对堆顶元素进行最大堆构建就可以了，而不用跟第一次一样从下往上重新构建堆。
 * 5. 由3和4可知，我们构建最大堆的方法，还需要一个额外的长度参数，因为第4步堆的长度是第三步-1
 * 6. 循环执行第4步，最后通过不断构建最大堆，实现了从小到大的排序
 * 7. 因为最大堆构建好之后，每次从堆顶获取到此时堆中最大的元素，所以，堆可以用来计算topK问题
 *
 * 构建初始最大堆的时间复杂度是O(n),而后需要交换n-1次，每次交换完后重建堆的时间复杂度是O(log2(n)),O(log2(n-1)),...,1
 * 所以总的时间复杂度可以认为是O(nlog2(n)),空间复杂度O(1),不稳定
 */
public class HeapSort {

    public static void main(String[] argv) {
//        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
//        heapSort(data);
//        System.out.println(Arrays.toString(data));

        int[] array = {4, 9, 8, 5, 6};
        maxHeapify(0,4, array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        /*
         * 第一步：将数组堆化
         * beginIndex = 第一个非叶子节点。
         * 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int lastNodeIndex = array.length - 1;
        int beginIndex = (lastNodeIndex - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, lastNodeIndex, array);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = lastNodeIndex; i > 0; i--) {
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
     * 调整索引为 index 处的数据，使其符合大顶堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param lastNodeIndex   未排序的堆（数组）的长度
     */
    private static void maxHeapify(int index, int lastNodeIndex, int[] arr) {
        int li = (index << 1) + 1;      // 左子节点索引
        if (li > lastNodeIndex) return; // 左子节点索引超出计算范围，直接返回。
        int ri = li + 1, cMax = li;     // 右子节点索引,子节点值最大索引，默认左子节点。
        // 先判断左右子节点，哪个较大
        if (ri <= lastNodeIndex && arr[ri] > arr[li]) cMax = ri;
        if (arr[cMax] > arr[index]) {
            swap(cMax, index, arr);     // 如果父节点被子节点调换，
            maxHeapify(cMax, lastNodeIndex, arr); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
}
