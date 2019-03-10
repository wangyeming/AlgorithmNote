package chapter2;

import support.BinaryTreeNode2;

/**
 * 二叉树的下一个节点
 * <p>
 * 给定一颗二叉树(节点包含父节点信息)和其中一个节点，找出中序遍历序列的下一个节点。
 * <p>
 * 考察点：二叉树的中序遍历深刻理解
 */
public class JAVA_8 {

    //              1
    //      2               3
    //  4        5      6       7
    //         8   9
    public static void main(String[] argv) {
//        int[] inOrder = new int[]{4, 2, 8, 5, 9, 1, 6, 3, 7};

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

        printNextNode(binaryTreeNode1);
        printNextNode(binaryTreeNode2);
        printNextNode(binaryTreeNode3);
        printNextNode(binaryTreeNode4);
        printNextNode(binaryTreeNode5);
        printNextNode(binaryTreeNode6);
        printNextNode(binaryTreeNode7);
        printNextNode(binaryTreeNode8);
        printNextNode(binaryTreeNode9);
    }

    private static void printNextNode(BinaryTreeNode2 binaryTreeNode) {
        BinaryTreeNode2 nextNode = findNextNodeByInOrder(binaryTreeNode);
        System.out.println(binaryTreeNode.value + " next node is " + (nextNode == null ? "null" : nextNode.value));
    }


    //解题思路：找规律，分情况考虑
    //1. 如果该节点有右子树，那么下一个节点就是右子树的最左节点
    //2. 如果该结点没有右子树，
    //      2.1 且该结点的父节点是空，那么他(是根节点)，没有下一个节点
    //      2.2 该结点是父节点的左子节点, 那么下一个节点就是他的父节点
    //      2.3 该结点是父节点的右子节点，那么下一个节点比较复杂(沿着父节点方向找，找到一个节点是它父节点的左子节点的时候，它的父节点就是下一个节点)
    public static BinaryTreeNode2 findNextNodeByInOrder(BinaryTreeNode2 binaryTreeNode) {
        if (binaryTreeNode == null) {
            return null;
        }
        BinaryTreeNode2 rightNode = binaryTreeNode.rightNode;
        if (rightNode != null) {
            //如果节点有右子树，那么下一个节点就是右子树的最左节点
            while (rightNode.leftNode != null) {
                rightNode = rightNode.leftNode;
            }
            return rightNode;
        }
        BinaryTreeNode2 parentNode = binaryTreeNode.parentNode;
        if (parentNode == null) {
            //如果该结点没有右子树，且该结点的父节点是空，那么他(是根节点)，没有下一个节点
            return null;
        }
        if (parentNode.leftNode == binaryTreeNode) {
            //如果该结点是父节点的左节点
            return parentNode;
        } else {
            if (parentNode.parentNode == null) {
                return null;
            }
            //如果该结点是父节点的右节点
            while (parentNode != parentNode.parentNode.leftNode) {
                //判断其父节点是不是它的父节点左节点
                parentNode = parentNode.parentNode;
                if (parentNode.parentNode == null) {
                    //还没找到的时候，就发现它没有父节点了，说明是最后一个节点
                    return null;
                }
            }
            return parentNode.parentNode;
        }
    }
}
