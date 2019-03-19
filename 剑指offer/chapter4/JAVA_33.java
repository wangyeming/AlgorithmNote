package chapter4;

/**
 * 二叉树的后续遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果。数组任意两个数字互不相同。
 */
public class JAVA_33 {

    //二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
    // 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    // 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    // 它的左、右子树也分别为二叉排序树。
    public static void main(String[] argv) {
        System.out.println(isSequenceOfBST(new int[]{}));
        System.out.println(isSequenceOfBST(new int[]{1}));
        System.out.println(isSequenceOfBST(new int[]{3, 1}));
        System.out.println(isSequenceOfBST(new int[]{2, 3, 1}));
        System.out.println(isSequenceOfBST(new int[]{3, 2, 1}));
        System.out.println(isSequenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(isSequenceOfBST(new int[]{7, 4, 6, 5}));
    }

    //思路是：根节点在末尾，左子树都比根节点小，左子树都比根节点大，所以找到第一个比根节点大的节点，区分左右子树，然后遍历右子树，
    //如果右子树有比根节点小的，那么就不合法
    public static boolean isSequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return _isSequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean _isSequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int rightStartIdx = start;

        for (; rightStartIdx < end; rightStartIdx++) {
            if (sequence[rightStartIdx] > root) {
                break;
            }
        }
        for (int i = rightStartIdx; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return _isSequenceOfBST(sequence, start, rightStartIdx - 1) && _isSequenceOfBST(sequence, rightStartIdx, end - 1);
    }

}
