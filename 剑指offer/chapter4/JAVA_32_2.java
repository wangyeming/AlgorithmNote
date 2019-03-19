package chapter4;

import support.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印,不同层需要换行
 * <p>
 * 考察点：二叉树，队列
 */
public class JAVA_32_2 {

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
        levelOrderPrint(binaryTreeNode1);
    }

    public static void levelOrderPrint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            //相比上一题，增加一个size，计算什么时候换行
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode currentNode = q.poll();
                System.out.print(currentNode.value);
                if (currentNode.leftNode != null) {
                    q.add(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    q.add(currentNode.rightNode);
                }
            }
            System.out.println();
        }
    }
}
