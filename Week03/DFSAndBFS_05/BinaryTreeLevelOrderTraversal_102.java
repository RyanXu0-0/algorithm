package DFSAndBFS_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:DFSAndBFS_05
 * @author:徐东
 * @createTime:2020/11/24 22:11
 * @version:1.0
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        BFS(result, tempQueue);
        return result;
    }

    public void BFS(List<List<Integer>> result, Queue<TreeNode> queue) {
        if (queue.isEmpty()) return;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        Queue<Integer>  subResult= new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            subResult.add(temp.val);
            if(temp.left != null) tempQueue.add(temp.left);
            if(temp.right != null) tempQueue.add(temp.right);
        }
        result.add(new LinkedList<>(subResult));
        BFS(result, tempQueue);
    }

    /**
     * description 方法二：深度优先遍历
     * param [root]
     * return java.util.List<java.util.List<java.lang.Integer>>
     * author Ryan Xu
     * createTime 2020/11/24 22:29
     **/
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (null == root) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        DFS(result, root, 0);
        return result;
    }

    public void DFS(List<List<Integer>> result, TreeNode root, int high) {
        if (null == root) return;
        if (high >= result.size()) result.add(new ArrayList<>());

        result.get(high).add(root.val);
        DFS(result, root.left, high + 1);
        DFS(result, root.right, high + 1);
    }
}
