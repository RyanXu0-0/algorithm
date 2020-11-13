package Recursion_04;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:HashTable_01
 * @author:徐东
 * @createTime:2020/11/13 0:47
 * @version:1.0
 */
public class ClimbingStairs_70 {
    /**
     * description 方法一：递归
     * param [n]
     * return int
     * author Ryan Xu
     * createTime 2020/11/13 0:48
     **/
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        int f1 = 0, f2 = 1, f3 = 1;
        for (int i = 1; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }
}
