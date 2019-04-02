package chapter6;

import base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 考察点：二叉树
 */
public class JAVA_68_3 {

    //                  1
    //          2               3
    //      4       5       6       7
    //   8            9        10
    //    11
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(1);

        binaryTreeNode1.leftNode = binaryTreeNode2;
        binaryTreeNode1.rightNode = binaryTreeNode3;
        binaryTreeNode2.leftNode = binaryTreeNode4;
        binaryTreeNode2.rightNode = binaryTreeNode5;
        binaryTreeNode3.leftNode = binaryTreeNode6;
        binaryTreeNode3.rightNode = binaryTreeNode7;
        binaryTreeNode4.leftNode = binaryTreeNode8;
        binaryTreeNode5.rightNode = binaryTreeNode9;
        binaryTreeNode6.rightNode = binaryTreeNode10;
        binaryTreeNode8.rightNode = binaryTreeNode11;

        System.out.println(lowestCommonAncestor1(binaryTreeNode1, binaryTreeNode10, binaryTreeNode11));
        System.out.println(lowestCommonAncestor1(binaryTreeNode1, binaryTreeNode11, binaryTreeNode9));
        System.out.println(lowestCommonAncestor1(binaryTreeNode1, binaryTreeNode8, binaryTreeNode2));

        System.out.println(lowestCommonAncestor2(binaryTreeNode1, binaryTreeNode10, binaryTreeNode11));
        System.out.println(lowestCommonAncestor2(binaryTreeNode1, binaryTreeNode11, binaryTreeNode9));
        System.out.println(lowestCommonAncestor2(binaryTreeNode1, binaryTreeNode8, binaryTreeNode2));
    }

    //自下向上的查找，区别于自上向下的查找O(n^2)的效率，自下向上的只需要O(n)
    //自上向下:从根节点开始，判断p和q是不是位于根节点的左右子树当中，如果都在左子树，那么再继续查找左子树。时间复杂度是O(n^2)
    //自下向上:分别从两个节点开始向上出发，去查找LCA，一旦遇到节点等于p或者q，则将其向上传递给它的父节点，父节点会判断它的左右子树是否都包含其中一个节点
    //如果是，那么父节点就是p和q的LCA
    //因为没有指向父节点的指针，所以，我们自下向上的实现方式是自上向下的递归。
    public static BinaryTreeNode lowestCommonAncestor1(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        BinaryTreeNode left = lowestCommonAncestor1(root.leftNode, p, q);
        BinaryTreeNode right = lowestCommonAncestor1(root.rightNode, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    //公共路径法
    //这里不管是二叉树，还是n叉树都是一样的。
    //首先保存两个节点从从根节点到节点的路径，然后找两个路径的最远公共节点即可
    //时间复杂度O(n)，空间复杂度O(n)
    public static BinaryTreeNode lowestCommonAncestor2(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        List<BinaryTreeNode> path1 = new ArrayList<>();
        List<BinaryTreeNode> path2 = new ArrayList<>();
        getNodePath(root, p, path1);
        getNodePath(root, q, path2);
        return findLastCommonNode(path1, path2);
    }

    //首先借助O(n)的辅助空间，将从根节点到节点的路径保存下来。
    private static boolean getNodePath(BinaryTreeNode root, BinaryTreeNode p, List<BinaryTreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            //如果节点本身可以作为自己的祖先的话
            path.add(root);
            return true;
        }
        boolean found = false;
        path.add(root);
        if (root.leftNode != null) {
            found = getNodePath(root.leftNode, p, path);
        }
        if (found) {
            return true;
        }
        if (root.rightNode != null) {
            found = getNodePath(root.rightNode, p, path);
        }
        if (!found) {
            path.remove(root);
        }
        return found;
    }

    //找两个路径的最远公共节点
    private static BinaryTreeNode findLastCommonNode(List<BinaryTreeNode> path1, List<BinaryTreeNode> path2) {
        BinaryTreeNode lastCommonNode = null;
        Iterator<BinaryTreeNode> iterator1 = path1.iterator();
        Iterator<BinaryTreeNode> iterator2 = path2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            BinaryTreeNode node1 = iterator1.next();
            BinaryTreeNode node2 = iterator2.next();
            if (node1 == node2) {
                lastCommonNode = node1;
            }
        }
        return lastCommonNode;
    }
}
