package Backtrack_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:Backtrack_03
 * @author:徐东
 * @createTime:2020/11/19 21:15
 * @version:1.0
 */
public class Subsets_78 {
    /**
     * description 方法一：利用位运算符
     * param [nums]
     * return java.util.List<java.util.List<java.lang.Integer>>
     * author Ryan Xu
     * createTime 2020/11/20 22:32
     **/
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1)== 1) tempList.add(nums[j]);
            }
            res.add(tempList);
        }
        return res;
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    /**
     * description 方法二：递归
     * param [nums] [1, 2, 3]的子集
     *  []
     *      [1]
     *              [2] [1, 2]
     *  [3] [1, 3] [2, 3] [1, 2, 3]
     * return java.util.List<java.util.List<java.lang.Integer>>
     * author Ryan Xu
     * createTime 2020/11/20 22:33
     **/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 什么都不做
        dfs(result, nums, temp, index + 1);
        // 放入当前元素
        temp.add(nums[index]);
        dfs(result, nums, temp, index + 1);

        temp.remove(temp.size() - 1);
    }
}
