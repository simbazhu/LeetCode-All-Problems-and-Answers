class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (row > 0 && column > 0
                    && matrix[row - 1][column - 1] != matrix[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
}
