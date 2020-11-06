package StackAndQueue_03;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:StackAndQueue_03
 * @author:徐东
 * @createTime:2020/11/6 20:54
 * @version:1.0
 */
public class LargestRectangleInHistogram_84 {
    public static void main(String[] args) {
        int[] height = new int[]{5,5,1,7,1,1,5,2,7,6};
        largestRectangleArea(height);
    }
    /**
     * description 解法一：暴力解法
     * param [heights]
     * return int
     * author Ryan Xu
     * createTime 2020/11/6 23:17
     **/
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i] ) {
                    width++;
                } else break;
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i] ) {
                    width++;
                } else break;
            }
            area = Math.max(area, heights[i] * width);
        }
        return area;
    }

    /**
     * description 解法二：顺序栈
     *  思路：
     * param [heights]
     * return int
     * author Ryan Xu
     * createTime 2020/11/6 23:33
     **/
    public static int largestRectangleArea1(int[] heights) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            // stack存的就是左边界
            // 当heights[stack.peek()] > heights[i]时，右边界就找到了，直接取出数据计算最大值
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i])
                area = Math.max(area, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            area = Math.max(area, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return area;
    }

    /**
     * description 解法三：顺序栈
     *   这个不算优化，该走的步骤还是会走，只是代码变少了，该走的步骤还是走了
     * param [heights]
     * return int
     * author Ryan Xu
     * createTime 2020/11/6 23:33
     **/
    public static int largestRectangleArea2(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积 ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }
}
