package chapter6;

import support.MultiTreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 普通树的最近公共祖先
 * <p>
 * 给定一个普通树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 考察点：树
 */
public class JAVA_68_4 {

    //                              0
    //      1               2               3           4
    //  5  6  7  8          9              10       11  12  13
    // 14         15
    //16            17
    public static void main(String[] args) {
        List<MultiTreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= 17; i++) {
            nodes.add(new MultiTreeNode(i));
        }
        nodes.get(0).nodes.add(nodes.get(1));
        nodes.get(0).nodes.add(nodes.get(2));
        nodes.get(0).nodes.add(nodes.get(3));
        nodes.get(0).nodes.add(nodes.get(4));
        nodes.get(1).nodes.add(nodes.get(5));
        nodes.get(1).nodes.add(nodes.get(6));
        nodes.get(1).nodes.add(nodes.get(7));
        nodes.get(1).nodes.add(nodes.get(8));
        nodes.get(2).nodes.add(nodes.get(9));
        nodes.get(3).nodes.add(nodes.get(10));
        nodes.get(4).nodes.add(nodes.get(11));
        nodes.get(4).nodes.add(nodes.get(12));
        nodes.get(4).nodes.add(nodes.get(13));

        nodes.get(5).nodes.add(nodes.get(14));
        nodes.get(14).nodes.add(nodes.get(16));
        nodes.get(8).nodes.add(nodes.get(15));
        nodes.get(15).nodes.add(nodes.get(17));

        System.out.println(lowestCommonAncestor1(nodes.get(0), nodes.get(1), nodes.get(4)));
        System.out.println(lowestCommonAncestor1(nodes.get(0), nodes.get(11), nodes.get(12)));
        System.out.println(lowestCommonAncestor1(nodes.get(0), nodes.get(16), nodes.get(17)));
        System.out.println(lowestCommonAncestor1(nodes.get(0), nodes.get(16), nodes.get(9)));

        System.out.println(lowestCommonAncestor2(nodes.get(0), nodes.get(1), nodes.get(4)));
        System.out.println(lowestCommonAncestor2(nodes.get(0), nodes.get(11), nodes.get(12)));
        System.out.println(lowestCommonAncestor2(nodes.get(0), nodes.get(16), nodes.get(17)));
        System.out.println(lowestCommonAncestor2(nodes.get(0), nodes.get(16), nodes.get(9)));
    }

    //思路和二叉树的自下向上是一样的
    public static MultiTreeNode lowestCommonAncestor1(MultiTreeNode root, MultiTreeNode p, MultiTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        List<MultiTreeNode> multiTreeNodes = new ArrayList<>();
        for (MultiTreeNode node : root.nodes) {
            MultiTreeNode findNode = lowestCommonAncestor1(node, p, q);
            if (findNode != null) {
                multiTreeNodes.add(findNode);
            }
        }
        if (multiTreeNodes.size() == 2) {
            return root;
        } else if (multiTreeNodes.size() == 1) {
            return multiTreeNodes.get(0);
        }
        return null;

    }

    //公共路径法
    //这里不管是二叉树，还是n叉树都是一样的。
    //首先保存两个节点从从根节点到节点的路径，然后找两个路径的最远公共节点即可
    //时间复杂度O(n)，空间复杂度O(n)
    public static MultiTreeNode lowestCommonAncestor2(MultiTreeNode root, MultiTreeNode p, MultiTreeNode q) {
        List<MultiTreeNode> path1 = new ArrayList<>();
        List<MultiTreeNode> path2 = new ArrayList<>();
        getNodePath(root, p, path1);
        getNodePath(root, q, path2);
        return findLastCommonNode(path1, path2);
    }

    //首先借助O(n)的辅助空间，将从根节点到节点的路径保存下来。
    private static boolean getNodePath(MultiTreeNode root, MultiTreeNode p, List<MultiTreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            //如果节点本身可以作为自己的祖先的话
            path.add(root);
            return true;
        }
        path.add(root);
        boolean found = false;
        Iterator<MultiTreeNode> iterator = root.nodes.iterator();
        while (!found && iterator.hasNext()) {
            found = getNodePath(iterator.next(), p, path);
        }
        if (!found) {
            path.remove(root);
        }
        return found;
    }

    //找两个路径的最远公共节点
    private static MultiTreeNode findLastCommonNode(List<MultiTreeNode> path1, List<MultiTreeNode> path2) {
        MultiTreeNode lastCommonNode = null;
        Iterator<MultiTreeNode> iterator1 = path1.iterator();
        Iterator<MultiTreeNode> iterator2 = path2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            MultiTreeNode node1 = iterator1.next();
            MultiTreeNode node2 = iterator2.next();
            if (node1 == node2) {
                lastCommonNode = node1;
            }
        }
        return lastCommonNode;
    }
}
