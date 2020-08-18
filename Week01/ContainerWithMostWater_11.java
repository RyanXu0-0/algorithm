public class ContainerWithMostWater_11 {
    //解法一：暴力解，便利循环
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i+1; j < height.length; j++ ){
                int area = (j - i) * Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }


//解法二：快慢指针 双指针法
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = height.length-1;
        for(int right = 0; right < left ;){
            int area = (left - right) * Math.min(height[right],height[left]);
            maxArea = Math.max(maxArea,area);
            if(height[left] > height[right]) right++; else left--;
        }
        return maxArea;
    }
}
