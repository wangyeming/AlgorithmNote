package binaryTree;

import base.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层级遍历
 */
public class LevelOrder {

    //                      1
    //          2                       3
    //  4                       5                6
    //                      7
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

        System.out.println(levelOrder1(binaryTreeNode1));
        System.out.println(levelOrder2(binaryTreeNode1));
        System.out.println(levelOrderRecursive(binaryTreeNode1));

    }

    //递归的方式，通过指定level来指定元素该压入哪个list
    public static List<List<BinaryTreeNode>> levelOrderRecursive(BinaryTreeNode root) {
        List<List<BinaryTreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        _levelOrderRecursive(root, 0, result);
        return result;
    }

    private static void _levelOrderRecursive(BinaryTreeNode node, int level, List<List<BinaryTreeNode>> result) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node);
        _levelOrderRecursive(node.leftNode, level + 1, result);
        _levelOrderRecursive(node.rightNode, level + 1, result);
    }

    //非递归的方式，借助三个数组协助
    public static List<List<BinaryTreeNode>> levelOrder1(BinaryTreeNode root) {
        List<List<BinaryTreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<BinaryTreeNode> nodes = new ArrayList<>();
        nodes.add(root);//[1]
        while (!nodes.isEmpty()) {
            List<BinaryTreeNode> current = new ArrayList<>();
            List<BinaryTreeNode> next = new ArrayList<>();
            for (BinaryTreeNode stackNode : nodes) {
                current.add(stackNode); //[1]
                if (stackNode.leftNode != null) {
                    next.add(stackNode.leftNode);
                }
                if (stackNode.rightNode != null) {
                    next.add(stackNode.rightNode);
                }

            }
            nodes = next;
            result.add(current);
        }
        return result;
    }

    //非递归的方式，借助队列的先进先出
    public static List<List<BinaryTreeNode>> levelOrder2(BinaryTreeNode root) {
        List<List<BinaryTreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<BinaryTreeNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode currentNode = q.poll();
                currentLevel.add(currentNode);
                if (currentNode.leftNode != null) {
                    q.add(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    q.add(currentNode.rightNode);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }
}
