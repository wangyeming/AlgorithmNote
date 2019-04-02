package chapter4;

import base.BinaryTreeNode;

/**
 * 二叉搜索树与双向链表
 * <p>
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表，要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * 考察点：递归，二叉树，双向链表
 */
public class JAVA_36 {

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

        BinaryTreeNode head = convert(binaryTreeNode4);
        while (head != null) {
            System.out.print(head.value);
            if (head.rightNode != null) {
                System.out.print("->");
            }
            head = head.rightNode;
        }
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNode = _convert(root, null);
//        BinaryTreeNode[] lastNodeArray = new BinaryTreeNode[]{null};
//        _convert(root, lastNodeArray);
//        BinaryTreeNode lastNode = lastNodeArray[0];
        while (lastNode != null && lastNode.leftNode != null) {
            lastNode = lastNode.leftNode;
        }
        return lastNode;
    }

    //借鉴了指针的概念
//    private static void _convert(BinaryTreeNode node, BinaryTreeNode[] lastNodeArray) {
//        if (node == null) {
//            return;
//        }
//        System.out.println(node);
//        if (node.leftNode != null) {
//            //处理左子树
//            _convert(node.leftNode, lastNodeArray);
//        }
//        //父节点和左子树   左右关联  lastNode--(right)-->node
//        //                       node<--(left)--lastNode
//        System.out.println("connect " + lastNodeArray[0] + " and " + node);
//
//        node.leftNode = lastNodeArray[0];
//        if (lastNodeArray[0] != null) {
//            lastNodeArray[0].rightNode = node;
//        }
//
//        lastNodeArray[0] = node;
//        System.out.println("lastNodeArray " + lastNodeArray[0] );
//
//        if (node.rightNode != null) {
//            //处理右子树
//            _convert(node.rightNode, lastNodeArray);
//        }
//    }

    //思路是首先分析根节点，把左子树的最大元素<->root,再处理root<->右子树的最小元素，
    //可以用递归的方式去做：
    //对于每个节点而言，先递归处理左子树，保证该结点左边全都排序，然后，把该结点当做上一个元素，递归处理下一个节点
    private static BinaryTreeNode _convert(BinaryTreeNode node, BinaryTreeNode lastNode) {
        if (node == null) {
            return null;
        }
        System.out.println(node);
        if (node.leftNode != null) {
            //处理左子树
            lastNode = _convert(node.leftNode, lastNode);
        }
        //父节点和左子树   左右关联  lastNode--(right)-->node
        //                       node<--(left)--lastNode
        System.out.println("connect " + lastNode + " and " + node);

        node.leftNode = lastNode;
        if (lastNode != null) {
            lastNode.rightNode = node;
        }

        lastNode = node;
        System.out.println("lastNodeArray " + lastNode);

        //当前节点的左子树关系已经处理好了，现在处理右子树，需要手动传入当前节点
        if (node.rightNode != null) {
            //处理右子树
            lastNode = _convert(node.rightNode, lastNode);
        }
        return lastNode;
    }
}
