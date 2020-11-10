package HashTable_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:HashTable_01
 * @author:徐东
 * @createTime:2020/11/10 20:48
 * @version:1.0
 */
public class BinaryTreePreorderTraversal_144 {

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


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> treeList = new ArrayList<>();
        treeList.add(root.val);
        treeList.addAll(preorderTraversal(root.left));
        treeList.addAll(preorderTraversal(root.right));
        return treeList;
    }
}
