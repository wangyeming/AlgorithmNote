package binaryTree;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class InOrder {

    //递归实现
    public static List<BinaryTreeNode> inOrder1(BinaryTreeNode root) {
        List<BinaryTreeNode> inOrderList = new ArrayList<>();
        _inOrder(root, inOrderList);
        return inOrderList;
    }

    private static void _inOrder(BinaryTreeNode node, List<BinaryTreeNode> inOrderList) {
        if (node == null) return;
        _inOrder(node.leftNode, inOrderList);
        inOrderList.add(node);
        _inOrder(node.rightNode, inOrderList);
    }

    //非递归实现
    public static List<BinaryTreeNode> inOrder2(BinaryTreeNode root) {
        List<BinaryTreeNode> inOrderList = new ArrayList<>();
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                BinaryTreeNode stackTopNode = stack.pop();
                inOrderList.add(stackTopNode);
                node = stackTopNode.rightNode;
            }
        }
        return inOrderList;
    }

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
        System.out.println(inOrder1(binaryTreeNode1));
        System.out.println(inOrder2(binaryTreeNode1));
    }
}
