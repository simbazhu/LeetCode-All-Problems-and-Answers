class Solution {
    int[][][] dirs = {
                {{0, -1}, {0, 1}},
                {{-1, 0}, {1, 0}},
                {{0, -1}, {1, 0}},
                {{0, 1}, {1, 0}},
                {{0, -1}, {-1, 0}},
                {{0, 1}, {-1, 0}}
    };
    //the idea is you need to check port direction match, you can go to next cell and check whether you can come back.
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int num = grid[x][y] - 1;
            for (int[] dir : dirs[num]) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                //go to the next cell and come back to orign to see if port directions are same
                for (int[] backDir : dirs[grid[nx][ny] - 1])
                    if (nx + backDir[0] == x && ny + backDir[1] == y) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
            }
        }
        return visited[m - 1][n - 1];
    }
}
