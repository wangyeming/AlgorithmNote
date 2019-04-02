package chapter4;

import base.BinaryTreeNode;

/**
 * 对称二叉树的判断
 * <p>
 * 判断一颗二叉树是否是对称二叉树
 * <p>
 * 考察点：二叉树的理解
 */
public class JAVA_28 {

    public static void main(String[] argv) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(3);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.leftNode = binaryTreeNode5;
        binaryTreeNode3.leftNode = binaryTreeNode6;
        binaryTreeNode3.rightNode = binaryTreeNode7;

        System.out.println(isSymmetrical(binaryTreeNode1));
    }

    //二叉树的前序遍历的先左后右 和 先右后左，一样，才是对称二叉树
    public static boolean isSymmetrical(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return true;
        }
        return _isSymmetrical(binaryTreeNode.leftNode, binaryTreeNode.rightNode);
    }

    private static boolean _isSymmetrical(BinaryTreeNode binaryTreeNode1, BinaryTreeNode binaryTreeNode2) {
        if (binaryTreeNode1 == null && binaryTreeNode2 == null) {
            return true;
        }
        if (binaryTreeNode1 == null || binaryTreeNode2 == null) {
            return false;
        }
        if (binaryTreeNode1.value != binaryTreeNode2.value) {
            return false;
        }
        return _isSymmetrical(binaryTreeNode1.leftNode, binaryTreeNode1.rightNode)
                && _isSymmetrical(binaryTreeNode1.rightNode, binaryTreeNode1.leftNode);
    }


}
