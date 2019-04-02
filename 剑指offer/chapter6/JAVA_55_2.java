package chapter6;

import base.BinaryTreeNode;

/**
 * 平衡二叉树
 * <p>
 * 输入一颗二叉树的根节点，判断该树是不是平衡二叉树(任意节点的左右子树深度相差不超过1)
 *
 * 考察点：二叉树的后续遍历
 */
public class JAVA_55_2 {

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

        System.out.println(isBalanced(binaryTreeNode4));

        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
        binaryTreeNode6.leftNode = binaryTreeNode9;

        System.out.println(isBalanced(binaryTreeNode4));
    }

    public static boolean isBalanced(BinaryTreeNode node) {
        return _isBalanced(node, new int[]{0});
    }

    //思路是：如果中序遍历的话，每个节点，都要先计算节点的左子树和右子树的深度，而每个子树里面的节点，也需要计算各自子树的深度，会有很多重复。
    //而后续遍历可以先从最小的子树开始，避免了重复计算。
    public static boolean _isBalanced(BinaryTreeNode node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return true;
        }
        int[] leftDepth = new int[1], rightDepth = new int[1];
        if (_isBalanced(node.leftNode, leftDepth) && _isBalanced(node.rightNode, rightDepth)) {
            int diff = leftDepth[0] - rightDepth[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (leftDepth[0] > rightDepth[0] ? leftDepth[0] : rightDepth[0]);
                return true;
            }
        }
        return false;
    }
}
