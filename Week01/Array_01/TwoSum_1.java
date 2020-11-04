package Array_01;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//             
//
//    示例:
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]



//    注意看题，每个解只有一个答案

    //解法一：暴力解
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }



    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) return null;
        int[] a = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    //解法二：两遍hash表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int component = target - nums[i];
            if(map.containsKey(component) && map.get(component) != i){
                return new int[]{i,map.get(component)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //解法三：一遍Hash，注意返回时的格式
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if(map.containsKey(component) && map.get(component) != i){
                return new int[]{map.get(component),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
