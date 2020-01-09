class Solution {
    public int[][] imageSmoother(int[][] M) {
        final int ROWS = M.length;
        final int COLUMNS = M[0].length;
        int[][] answer = new int[ROWS][COLUMNS];
        
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int count = 0;
                for (int neighborRow = row - 1;
                    neighborRow <= row + 1; neighborRow++) {
                    for (int neighborColumn = column - 1;
                        neighborColumn <= column + 1; neighborColumn++) {
                        if (0 <= neighborRow && neighborRow < ROWS &&
                            0 <= neighborColumn && neighborColumn < COLUMNS) {
                            answer[row][column] +=
                                M[neighborRow][neighborColumn];
                            count++;
                        }
                    }
                }
                answer[row][column] /= count;
            }
        }
        
        return answer;
    }
}
