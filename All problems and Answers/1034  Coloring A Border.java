class Solution {
    private static final int[] d = { 0, 1, 0, -1, 0 }; // neighbors' relative displacements.
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int clr = grid[r0][c0], m = grid.length, n = grid[0].length;
        Set<Integer> component = new HashSet<>(); // put the cell number into Set to avoid visiting again.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ r0, c0 }); // add initial cell.
        component.add(r0 * n + c0); // add initial cell number.
        while (!q.isEmpty()) { // BFS starts.
            int r = q.peek()[0], c = q.poll()[1];
            if (r == 0 || r == m - 1 || c == 0 || c == n - 1) { grid[r][c] = color; } // on grid boundary.
            for (int k = 0; k < 4; ++k) { // travers its 4 neighbors.
                int i = r + d[k], j = c + d[k + 1]; // neighbor coordinates.
                if (i >= 0 && i < m && j >= 0 && j < n && !component.contains(i * n + j)) { // not visited before.
                    if (grid[i][j] == clr) { // its neighbor is of same color, put it into Queue. 
                        component.add(i * n + j); // avoid visiting again.
                        q.offer(new int[]{ i, j }); // put it into Queue. 
                    }else { // its neighbor is of different color, hence it is on component boundary.
                        grid[r][c] = color; 
                    }
                }
            }
        }
        return grid;
    }
}
