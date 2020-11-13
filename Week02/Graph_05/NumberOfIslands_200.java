package Graph_05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 方法一：深度优先
 * @projectName:IDEAProject
 * @see:Graph_05
 * @author:徐东
 * @createTime:2020/11/13 22:16
 * @version:1.0
 */
public class NumberOfIslands_200 {
    public int numIslands (char[][] grid) {
        int numOfIslands = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0;y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    numOfIslands++;
                    dfs(grid, x, y);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs (char[][] grid, int x, int y) {
        int xLength = grid.length;
        int yLength = grid[0].length;

        if (x < 0 || y < 0 || x >= xLength || y >= yLength || grid[x][y] == '0') return;
        grid[x][y] = '0';

        dfs(grid,x - 1, y);
        dfs(grid,x + 1, y);
        dfs(grid,x, y - 1);
        dfs(grid,x, y + 1);
    }

    /**
     * description 方法二：广度优先
     * param [grid, x, y]
     * return void
     * author Ryan Xu
     * createTime 2020/11/14 0:35
     **/
    private void bfs (char[][] grid, int x,int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] tempArr = queue.remove();
            x = tempArr[0];
            y = tempArr[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                grid[x][y] = '0';
                queue.add(new int[]{x, y - 1});
                queue.add(new int[]{x, y + 1});
                queue.add(new int[]{x - 1, y});
                queue.add(new int[]{x + 1, y});
            }
        }
    }
}
