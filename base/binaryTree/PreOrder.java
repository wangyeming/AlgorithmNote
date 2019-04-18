package binaryTree;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class PreOrder {

    //递归写法
    public static List<BinaryTreeNode> preOrder1(BinaryTreeNode root) {
        List<BinaryTreeNode> preOrderList = new ArrayList<>();
        _preOrder(root, preOrderList);
        return preOrderList;
    }

    private static void _preOrder(BinaryTreeNode node, List<BinaryTreeNode> preOrderList) {
        if (node == null) return;
        preOrderList.add(node);
        _preOrder(node.leftNode, preOrderList);
        _preOrder(node.rightNode, preOrderList);
    }

    //非递归写法
    public static List<BinaryTreeNode> preOrder2(BinaryTreeNode root) {
        List<BinaryTreeNode> preOrderList = new ArrayList<>();
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if(node == null) {
                node = stack.pop().rightNode;
            } else {
                preOrderList.add(node);
                stack.push(node);
                node = node.leftNode;
            }
        }
        return preOrderList;
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
        System.out.println(preOrder1(binaryTreeNode1));
        System.out.println(preOrder2(binaryTreeNode1));
    }
}
