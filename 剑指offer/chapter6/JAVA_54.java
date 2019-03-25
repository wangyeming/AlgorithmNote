package chapter6;

import support.BinaryTreeNode;

/**
 * 二叉搜索树的第k大节点
 * <p>
 * 给定一颗二叉搜索树，请找出其中第k大的节点
 * <p>
 * 考察点：二叉树的中序遍历
 */
public class JAVA_54 {

    //                  4
    //          2                 7
    //      1       3         5       8
    //                          6
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8);

        binaryTreeNode4.leftNode = binaryTreeNode2;
        binaryTreeNode4.rightNode = binaryTreeNode7;

        binaryTreeNode2.leftNode = binaryTreeNode1;
        binaryTreeNode2.rightNode = binaryTreeNode3;

        binaryTreeNode7.leftNode = binaryTreeNode5;
        binaryTreeNode7.rightNode = binaryTreeNode8;

        binaryTreeNode5.rightNode = binaryTreeNode6;

        for (int i = 1; i < 10; i++) {
            System.out.println(getKthNode(binaryTreeNode4, i));
        }
    }

    public static BinaryTreeNode getKthNode(BinaryTreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        return getKthNode(root, new int[]{k});
    }

    public static BinaryTreeNode getKthNode(BinaryTreeNode root, int[] kArray) {
        BinaryTreeNode target = null;
        if (root.leftNode != null) {
            target = getKthNode(root.leftNode, kArray);
        }
        if (target == null) {
            if (kArray[0] == 1) {
                target = root;
            }
            kArray[0] = kArray[0] - 1;
        }
        if (target == null && root.rightNode != null) {
            target = getKthNode(root.rightNode, kArray);
        }
        return target;
    }
}