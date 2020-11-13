package Heap_03;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * 本题主要需要理解，丑数的范围，丑数都在以下的数字中
 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
 * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
 * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
 * 丑数的规律，丑数乘以丑数还是丑数，1,2,3,4,5都是从小到大的丑数
 * @projectName:IDEAProject
 * @see:HashTable_01
 * @author:徐东
 * @createTime:2020/11/12 0:45
 * @version:1.0
 */
public class UglyNumberII_264 {
/**
 * description 方法一：大根堆
 *  丑数*2 3 5 也是丑数 ，利用小根堆进行出队列和排序
 * param [n]
 * return int
 * author Ryan Xu
 * createTime 2020/11/12 0:46
 **/
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1l);

        for (int i = 1; i < n; i++) {
            long temp = priorityQueue.poll();
            // 将与当前最小丑数相同的丑数出栈
            while (!priorityQueue.isEmpty() && temp == priorityQueue.peek()) priorityQueue.poll();

            priorityQueue.add(temp * 2);
            priorityQueue.add(temp * 3);
            priorityQueue.add(temp * 5);
        }
        return priorityQueue.peek().intValue();
    }

    /**
     * description 方法二：动态规划
     * param [n]
     * return int
     * author Ryan Xu
     * createTime 2020/11/12 23:36
     **/
    public int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0,index3 = 0,index5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[index2] * 2, ugly[index3] * 3), ugly[index5] * 5);
            if (ugly[i] == ugly[index2] * 2) index2++;
            if (ugly[i] == ugly[index3] * 3) index3++;
            if (ugly[i] == ugly[index5] * 5) index5++;
        }
        return ugly[n-1];
    }
}
