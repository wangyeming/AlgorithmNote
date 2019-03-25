package chapter6;

import support.BinaryTreeNode;

/**
 * 二叉树的深度
 * <p>
 * 输入一颗二叉树，求该树的深度
 * <p>
 * 考察点：递归
 */
public class JAVA_55_1 {

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

        System.out.println(treeDepth(binaryTreeNode4));
    }

    public static int treeDepth(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = treeDepth(treeNode.leftNode);
        int rightDepth = treeDepth(treeNode.rightNode);
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }


}
