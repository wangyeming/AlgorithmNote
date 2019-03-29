package chapter6;

import support.BinaryTreeNode2;

/**
 * 包含父节点指针的二叉树的最低公共祖先
 * <p>
 * 在一个包含父节点指针的二叉树中，输入两个节点，找出两个节点的最低公共祖先。(一个节点的祖先也可以是它自己的祖先。)
 * <p>
 * 考察点：二叉树
 */
public class JAVA_68_2 {

    //              1
    //      2               3
    //  4        5      6       7
    //         8   9
    public static void main(String[] args) {
        BinaryTreeNode2 binaryTreeNode1 = new BinaryTreeNode2(1);
        BinaryTreeNode2 binaryTreeNode2 = new BinaryTreeNode2(2);
        BinaryTreeNode2 binaryTreeNode3 = new BinaryTreeNode2(3);
        BinaryTreeNode2 binaryTreeNode4 = new BinaryTreeNode2(4);
        BinaryTreeNode2 binaryTreeNode5 = new BinaryTreeNode2(5);
        BinaryTreeNode2 binaryTreeNode6 = new BinaryTreeNode2(6);
        BinaryTreeNode2 binaryTreeNode7 = new BinaryTreeNode2(7);
        BinaryTreeNode2 binaryTreeNode8 = new BinaryTreeNode2(8);
        BinaryTreeNode2 binaryTreeNode9 = new BinaryTreeNode2(9);
        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.parentNode = binaryTreeNode1;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.rightNode = binaryTreeNode5;
        binaryTreeNode3.parentNode = binaryTreeNode1;
        binaryTreeNode3.leftNode = binaryTreeNode6;
        binaryTreeNode3.rightNode = binaryTreeNode7;
        binaryTreeNode4.parentNode = binaryTreeNode2;
        binaryTreeNode5.parentNode = binaryTreeNode2;
        binaryTreeNode5.leftNode = binaryTreeNode8;
        binaryTreeNode5.rightNode = binaryTreeNode9;
        binaryTreeNode6.parentNode = binaryTreeNode3;
        binaryTreeNode7.parentNode = binaryTreeNode3;
        binaryTreeNode8.parentNode = binaryTreeNode5;
        binaryTreeNode9.parentNode = binaryTreeNode5;

        System.out.println(findFirstCommonNode(binaryTreeNode8, binaryTreeNode6));
        System.out.println(findFirstCommonNode(binaryTreeNode8, binaryTreeNode4));
        System.out.println(findFirstCommonNode(binaryTreeNode2, binaryTreeNode4));
    }

    //因为有指向父节点的指针，所以可以看作链表找最近公共节点(参考第52题)
    public static BinaryTreeNode2 findFirstCommonNode(BinaryTreeNode2 node1, BinaryTreeNode2 node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        int l1 = 0, l2 = 0;
        BinaryTreeNode2 node3 = node1, node4 = node2;
        while (node3.parentNode != null) {
            node3 = node3.parentNode;
            l1++;
        }
        while (node4.parentNode != null) {
            node4 = node4.parentNode;
            l2++;
        }
        node3 = node1;
        node4 = node2;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                node3 = node3.parentNode;
            }
        } else if (l1 < l2) {
            for (int i = 0; i < l2 - l1; i++) {
                node4 = node4.parentNode;
            }
        }
        if (node3 == node4) {
            return node3;
        }
        while (node3.parentNode != null) {
            node3 = node3.parentNode;
            node4 = node4.parentNode;
            if (node3 == node4) {
                return node3;
            }
        }
        return null;
    }
}
