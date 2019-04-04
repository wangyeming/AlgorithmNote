package binaryTree;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    //递归写法
    public static List<BinaryTreeNode> postOrder1(BinaryTreeNode root) {
        List<BinaryTreeNode> postOrderList = new ArrayList<>();
        _postOrder(root, postOrderList);
        return postOrderList;
    }

    public static void _postOrder(BinaryTreeNode node, List<BinaryTreeNode> postOrderList) {
        if (node == null) return;
        _postOrder(node.leftNode, postOrderList);
        _postOrder(node.rightNode, postOrderList);
        postOrderList.add(node);
    }

    //非递归写法--写法1--借助栈
    public static List<BinaryTreeNode> postOrder2(BinaryTreeNode root) {
        List<BinaryTreeNode> postOrderList = new ArrayList<>();
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode lastVisitedNode = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                BinaryTreeNode top = stack.peek();
                if (top.rightNode == null || top.rightNode == lastVisitedNode) {
                    postOrderList.add(top);
                    lastVisitedNode = stack.pop();
                } else {
                    node = top.rightNode;
                }
            }
        }
        return postOrderList;
    }

    //非递归写法--写法2--先前序的中右左，最后反转整个结果即可
    public static List<BinaryTreeNode> postOrder3(BinaryTreeNode root) {
        List<BinaryTreeNode> postOrderList = new ArrayList<>();
        BinaryTreeNode node = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                postOrderList.add(node);
                stack.push(node);
                node = node.rightNode;
            } else {
                node = stack.pop().leftNode;
            }
        }
        for (int left = 0, right = postOrderList.size() - 1; left < right; left++, right--) {
            BinaryTreeNode tmp = postOrderList.get(left);
            postOrderList.set(left, postOrderList.get(right));
            postOrderList.set(right, tmp);
        }
        return postOrderList;
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
        System.out.println(postOrder1(binaryTreeNode1));
        System.out.println(postOrder2(binaryTreeNode1));
        System.out.println(postOrder3(binaryTreeNode1));
    }
}
