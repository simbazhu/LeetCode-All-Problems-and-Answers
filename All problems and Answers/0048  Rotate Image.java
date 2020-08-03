class Solution {
    public void rotate(int[][] matrix) {
        int firstRow = 0, lastRow = matrix.length - 1;
        while(firstRow < lastRow){
            int[] temp = matrix[firstRow];
            matrix[firstRow] = matrix[lastRow];
            matrix[lastRow] = temp;
            firstRow++; lastRow--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
