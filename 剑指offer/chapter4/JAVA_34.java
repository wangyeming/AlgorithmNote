package chapter4;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径.
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 考察点：二叉树的前序遍历
 */
public class JAVA_34 {

    //                  1
    //          2               3
    //      4       13      5       6
    //  9                7
    //
    public static void main(String[] argv) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(13);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);

        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.rightNode = binaryTreeNode8;
        binaryTreeNode3.leftNode = binaryTreeNode5;
        binaryTreeNode3.rightNode = binaryTreeNode6;
        binaryTreeNode5.leftNode = binaryTreeNode7;
        binaryTreeNode4.leftNode = binaryTreeNode9;
        findPath(binaryTreeNode1, 16);
    }

    public static void findPath(BinaryTreeNode binaryTreeNode, int expectedSum) {
        List<BinaryTreeNode> currentPath = new ArrayList<>();
        findPath(binaryTreeNode, expectedSum, 0, currentPath);
    }

    private static void findPath(BinaryTreeNode binaryTreeNode, int expectedSum, int currentSum, List<BinaryTreeNode> currentPath) {
        currentSum += binaryTreeNode.value;
        currentPath.add(binaryTreeNode);
        boolean isLeaf = binaryTreeNode.leftNode == null && binaryTreeNode.rightNode == null;
        if (currentSum == expectedSum && isLeaf) {
            System.out.println("find path: ");
            for (BinaryTreeNode binaryTreeNode1 : currentPath) {
                System.out.print(binaryTreeNode1.value + "\t");
            }
            System.out.println();
            return;
        }
        if (binaryTreeNode.leftNode != null) {
            findPath(binaryTreeNode.leftNode, expectedSum, currentSum, currentPath);
        }
        if (binaryTreeNode.rightNode != null) {
            findPath(binaryTreeNode.rightNode, expectedSum, currentSum, currentPath);
        }
        //结束的时候需要把当前节点移除，才能返回到上一个节点
        currentPath.remove(binaryTreeNode);
    }
}
