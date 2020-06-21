class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, dir = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (dir == 1 && j == n - 1) {
                dir = -1;
                i--;
            } else if (dir == -1 && j == 0) {
                dir = 1;
                i--;
            } else {
                j += dir;
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        int start = arr[0] > -1 ? arr[0] - 1 : 0;
        q.offer(0);
        visited[0] = true;
        if (start != 0) {
            q.offer(start);
            visited[start] = true;
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == n * n - 1) {
                    return step;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
