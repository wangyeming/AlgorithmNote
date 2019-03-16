package chapter3;

import chapter2.JAVA_7;
import support.BinaryTreeNode;

/**
 * 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构
 * <p>
 * 考察点：二叉树遍历，递归
 */
public class JAVA_26 {

    public static void main(String[] argv) {
        //              1
        //      2               3
        //  4               5       6
        //     7                  8
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode t1 = JAVA_7.rebuildBinaryTree(preOrder, inOrder);
        //      3
        //5             6
        int[] preOrder2 = new int[]{3, 5, 6};
        int[] inOrder2 = new int[]{5, 3, 6};
        BinaryTreeNode t2 = JAVA_7.rebuildBinaryTree(preOrder2, inOrder2);
        System.out.println(hasSubTree(t1, t2));

        //      3
        //5             7
        int[] preOrder3 = new int[]{3, 5, 7};
        int[] inOrder3 = new int[]{5, 3, 7};
        BinaryTreeNode t3 = JAVA_7.rebuildBinaryTree(preOrder3, inOrder3);
        System.out.println(hasSubTree(t1, t3));
    }

    public static boolean hasSubTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        boolean result = false;
        if (t1 != null && t2 != null) {
            if (t1.value == t2.value) {
                result = isTreeInclude(t1, t2);
            }
            if (!result) {
                result = hasSubTree(t1.leftNode, t2);
            }
            if (!result) {
                result = hasSubTree(t1.rightNode, t2);
            }
        }
        return result;
    }

    private static boolean isTreeInclude(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.value != t2.value) {
            return false;
        }
        return isTreeInclude(t1.leftNode, t2.leftNode) &&
                isTreeInclude(t1.rightNode, t2.rightNode);
    }


}
