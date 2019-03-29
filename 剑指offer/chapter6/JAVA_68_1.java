package chapter6;

import support.BinaryTreeNode;

/**
 * 二叉搜索树的最低公共祖先
 * <p>
 * 在一个二叉搜索树中，输入根节点和两个节点，找出两个节点的最低公共祖先。(一个节点的祖先也可以是它自己的祖先。)
 * <p>
 * 考察点：二叉搜索树，递归
 */
public class JAVA_68_1 {

    //                  4
    //          2                 7
    //      1       3         5       8
    //                          6
    public static void main(String[] args) {
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

        System.out.println(findFirstCommonNode(binaryTreeNode4, binaryTreeNode1, binaryTreeNode3));
        System.out.println(findFirstCommonNode(binaryTreeNode4, binaryTreeNode1, binaryTreeNode2));
        System.out.println(findFirstCommonNode(binaryTreeNode4, binaryTreeNode1, binaryTreeNode6));
        System.out.println(findFirstCommonNode(binaryTreeNode4, binaryTreeNode8, binaryTreeNode6));

    }

    //思路很简单，因为二叉搜索树中，任意一个节点的左(右)子树的所有节点值总是比节点小(大)，那么从根节点开始，比较根节点的值和左右节点的值。
    //如果根节点最大，那么找左子树，如果根节点最小，那么找右子树
    //第一次遇到根节点在两者之间的，那么返回根节点即可
    public static BinaryTreeNode findFirstCommonNode(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return root;
        }
        if ((root.value > node1.value && root.value < node2.value) || (
                root.value < node1.value && root.value > node2.value)) {
            return root;
        }
        if (root.value == node1.value || root.value == node2.value) {
            return root;
        }
        if (root.value > node1.value && root.value > node2.value) {
            return findFirstCommonNode(root.leftNode, node1, node2);
        } else {
            return findFirstCommonNode(root.rightNode, node1, node2);
        }
    }
}
