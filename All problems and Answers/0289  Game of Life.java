class Solution {
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Iterate through board cell by cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                
                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;
                
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        
                        if (!(i == 0 && j == 0)) {
                            int r = row + i;
                            int c = col + j;
                            
                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                                
                // Rule 1 or Rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                } 
            }
        }
                                
        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
