package Recursion_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:Recursion_01
 * @author:徐东
 * @createTime:2020/11/16 22:27
 * @version:1.0
 */
public class SerializeAndDeserializeBinaryTree_297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = serialize(root);
        System.out.println(data);
        System.out.println(serialize(deserialize(data)));
    }
    /**
     * description 方法一：DFS
     * param [root]
     * return java.lang.String
     * author Ryan Xu
     * createTime 2020/11/16 22:40
     **/
    // Encodes a tree to a single string.StrUtil.join(conjunction, str1, str2, str3);
    public static String serialize(TreeNode root) {
        if (null == root) return "None";
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        return root.val + "," + leftSerialize + "," + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        if (null == queue) return null;
        String val = queue.remove();
        if ("None".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }


}
