package chapter4;

import support.BinaryTreeNode;
import support.LevelOrder;

/**
 * 二叉树的镜像
 * <p>
 * 输入一颗二叉树，输出他的镜像
 * <p>
 * 考察点：画图观察
 */
public class JAVA_27 {

    //             1                                                1
    //      2                 3             =>              3               2
    //  4                 5       6                     6       5               4
    //                  7                                         7
    public static void main(String[] argv) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode3.leftNode = binaryTreeNode5;
        binaryTreeNode3.rightNode = binaryTreeNode6;
        binaryTreeNode5.leftNode = binaryTreeNode7;

        System.out.println(LevelOrder.levelOrderRecursive(binaryTreeNode1));
        mirror(binaryTreeNode1);
        System.out.println(LevelOrder.levelOrderRecursive(binaryTreeNode1));
    }

    public static void mirror(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        if (binaryTreeNode.leftNode == null && binaryTreeNode.rightNode == null) {
            return;
        }
        BinaryTreeNode tmp = binaryTreeNode.leftNode;
        binaryTreeNode.leftNode = binaryTreeNode.rightNode;
        binaryTreeNode.rightNode = tmp;
        mirror(binaryTreeNode.leftNode);
        mirror(binaryTreeNode.rightNode);
    }
}
