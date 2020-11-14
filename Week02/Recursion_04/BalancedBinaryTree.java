package Recursion_04;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:Recursion_04
 * @author:徐东
 * @createTime:2020/11/14 21:52
 * @version:1.0
 */
public class BalancedBinaryTree {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * description 深度优先算法，自顶向下
     * param [root]
     * return boolean
     * author Ryan Xu
     * createTime 2020/11/14 22:05
     **/
    public boolean isBalanced(TreeNode root) {
        if(null == root) return true;
        return !(Math.abs(dfsDeep(root.right) - dfsDeep(root.left)) > 1 ) && isBalanced(root.right) && isBalanced(root.left);
    }

    private int dfsDeep (TreeNode root) {
        if (null == root) return 0;
        return Math.max(dfsDeep(root.left), dfsDeep(root.right)) + 1;
    }

    /**
     * description 方法二：自底向上
     * param [root]
     * return boolean
     * author Ryan Xu
     * createTime 2020/11/14 22:31
     **/
    public boolean isBalanced1(TreeNode root) {
        if(null == root) return true;
        return recur(root) != -1;
    }

    private int recur (TreeNode node) {
        if (null == node) return 0;
        int rightDepth = recur(node.right);
        int leftDepth = recur(node.left);
        if (rightDepth == -1 || leftDepth == -1 || Math.abs(rightDepth - leftDepth) > 1) return -1;
        return Math.max(recur(node.left), recur(node.right)) + 1;
    }
}
