package Array_01;

import java.sql.Array;
import java.util.*;

public class ThreeSum_15 {
    /*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    示例：
    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]
*/
    //解法一：暴力解 (超出时间限制)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0) res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(res);
    }

    //解法二：双指针法
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1,k = nums.length-1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while (j < k){
                if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (nums[j] == nums[++j] && j < k);
                    while (nums[k] == nums[--k] && j < k);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
