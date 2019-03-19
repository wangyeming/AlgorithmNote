package chapter4;

import support.BinaryTreeNode;

import java.util.Stack;

/**
 * 之字形打印二叉树
 * <p>
 * 从上到下打印每一行，奇数行从左到右，偶数行从右到左打印。
 * <p>
 * 考察点：二叉树和栈
 */
public class JAVA_32_3 {

    public static void main(String[] argv) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode3.leftNode = binaryTreeNode5;
        binaryTreeNode3.rightNode = binaryTreeNode6;
        binaryTreeNode5.leftNode = binaryTreeNode7;
        binaryTreeNode6.rightNode = binaryTreeNode8;
        levelOrderPrint(binaryTreeNode1);
    }

    //借助两个栈来实现
    public static void levelOrderPrint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.value);
                if (node.leftNode != null) {
                    stack2.push(node.leftNode);
                }
                if (node.rightNode != null) {
                    stack2.push(node.rightNode);
                }
            }
            System.out.println();
            while (!stack2.isEmpty()) {
                BinaryTreeNode node = stack2.pop();
                System.out.print(node.value);
                if (node.rightNode != null) {
                    stack1.push(node.rightNode);
                }
                if (node.leftNode != null) {
                    stack1.push(node.leftNode);
                }
            }
            System.out.println();
        }
    }
}
