package chapter4;

import support.BinaryTreeNode;

import static support.LevelOrder.levelOrder1;

/**
 * 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化
 * <p>
 * 考察点：二叉树的遍历
 */
public class JAVA_37 {

    //                  4
    //          2                 7
    //      1       3         5       8
    //                          6
    public static void main(String[] argv) {
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

        String serializedTree = serialize(binaryTreeNode4);
        System.out.println(serializedTree);
        BinaryTreeNode root = deserialize(serializedTree);
        System.out.println(levelOrder1(root));
    }

    //序列化的思路很简单，用特殊符号替代空，用逗号分割节点。保证每个叶节点都后跟$,$
    public static String serialize(BinaryTreeNode root) {
        return _serialize(root, new StringBuilder());
    }

    private static String _serialize(BinaryTreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("$,");
            return result.toString();
        }
        result.append(node.value).append(",");
        _serialize(node.leftNode, result);
        _serialize(node.rightNode, result);
        return result.toString();
    }

    //返序列化的思路也很简单，对于任意一个节点，先还原本身，再还原左子树，再还原右子树，用递归的思路
    public static BinaryTreeNode deserialize(String serializedTree) {
        if (serializedTree == null || serializedTree.isEmpty()) {
            return null;
        }
        return _deserialize(serializedTree.split(","), new int[]{0});
    }

    private static BinaryTreeNode _deserialize(String[] serializedTree, int[] startIdx) {
        if ("$".equals(serializedTree[startIdx[0]])) {
            startIdx[0]++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(serializedTree[startIdx[0]]));
        startIdx[0]++;
        node.leftNode = _deserialize(serializedTree, startIdx);
        node.rightNode = _deserialize(serializedTree, startIdx);
        return node;
    }
}