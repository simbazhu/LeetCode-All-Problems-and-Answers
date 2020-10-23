class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0, col[] = new int[n], row[] = new int[m];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (mat[i][j] == 1){
                    col[j]++;
                    row[i]++;
                } 
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) res++;
        return res;
    }
}
