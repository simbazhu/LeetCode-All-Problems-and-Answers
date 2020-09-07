class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] sums = new int[n + 1][m + 1];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j];
                if (i - max >= 0 && j - max >= 0 && 
                    sums[i + 1][j + 1] - sums[i - max][j + 1] - sums[i + 1][j - max] + sums[i - max][j - max] <= threshold
                   ) {
                    max += 1;
                }
            }
        }
            
        return max;    
    }
}
