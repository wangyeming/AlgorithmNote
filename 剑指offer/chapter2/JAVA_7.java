package chapter2;

//根据二叉树的前序和中序遍历结果，重建二叉树
public class JAVA_7 {

    //              1
    //      2               3
    //  4               5       6
    //     7                  8
    public static void main(String[] argv) {
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        rebuildBinaryTree(preOrder, 0, inOrder, 0, 8);
    }

    /**
     * @param preOrder    前序遍历数组
     * @param preStartIdx 前序遍历当前的节点(子节点[preStartIdx, preStartIdx+length-1])
     * @param inOrder     中序遍历数组
     * @param inStartIdx  中序遍历当前的节点(子节点[inStartIdx, inStartIdx+length-1])
     * @param length      长度
     * @return
     */
    public static BinaryTreeNode rebuildBinaryTree(int[] preOrder, int preStartIdx, int[] inOrder, int inStartIdx, int length) {
        System.out.println("--------");
        System.out.println("前序遍历 " + preStartIdx + " " + length);
        printArray(preOrder, preStartIdx, preStartIdx + length - 1);
        System.out.println("中序遍历 " + inStartIdx + " " + length);
        printArray(inOrder, inStartIdx, inStartIdx + length - 1);
        if (length == 0 ) {
            return null;
        }
        //前序遍历此时的根节点，就是开头的元素
        int currentNode = preOrder[preStartIdx];
        System.out.println("当前节点 " + currentNode);
        BinaryTreeNode firstNode = new BinaryTreeNode(currentNode);
        int nodePosition = -1;
        for (int i = inStartIdx; i < inStartIdx + length; i++) {
            //找到currentNode在中序遍历中的位置(元素值不重复)
            if (inOrder[i] == currentNode) {
                nodePosition = i;
                break;
            }
        }
        System.out.println("中序遍历中的位置 " + nodePosition);
        //对于中序遍历而言，nodePosition左边是该点的左子树，右边是该点的右子树
        //左子树的长度
        int leftLength = nodePosition - inStartIdx;
        //右子树的长度
        int rightLength = (inStartIdx + length - 1) - nodePosition;
        //对于前序遍历而言，左子树起始位置是当前节点的右1(如果存在)
        firstNode.leftNode = rebuildBinaryTree(preOrder, preStartIdx + 1, inOrder, inStartIdx, leftLength);
        //对于前序遍历而言, 右子树起始位置是当前节点的index+左子树的长度+1
        firstNode.rightNode = rebuildBinaryTree(preOrder, preStartIdx + 1 + leftLength, inOrder, nodePosition + 1, rightLength);
        return firstNode;
    }

    public static void printArray(int[] array, int start, int end) {
        if (start < 0 || end > array.length - 1 || end < start) {
            return;
        }
        System.out.print("数组 from " + start + " to " + end + " [");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("]");
    }

}
