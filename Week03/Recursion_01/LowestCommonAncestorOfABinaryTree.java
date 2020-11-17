package Recursion_01;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:Recursion_01
 * @author:徐东
 * @createTime:2020/11/17 21:50
 * @version:1.0
 */
public class LowestCommonAncestorOfABinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * description 方法一：DFS
     * param [root, p, q]
     * return Recursion_01.LowestCommonAncestorOfABinaryTree.TreeNode
     * author Ryan Xu
     * createTime 2020/11/17 22:26
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null == left) return right;
        if (null == right) return left;
        return root;
    }
}
