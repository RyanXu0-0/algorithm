public class ClimbingStairs_70 {
    //You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//

    //解法一：递归 太费时间，没有通过
    public static int climbStairs(int n) {
        if( n <= 2){ return n; }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //解法二：动态规划
    public static int climbStairs2(int n) {
        if( n <= 2){ return n; }
        int f0 = 1,f1 = 1,f2 = 2;
        for( int i = 3; i < n+1; i++ ){
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs2(n));
    }
}
