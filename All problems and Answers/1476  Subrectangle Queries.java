class SubrectangleQueries {

    private final int[][] r;
    private final LinkedList<int[]> histories = new LinkedList<>();
    
    public SubrectangleQueries(int[][] rectangle) { // deep copy the input array - credit to @_xavier_
        r = new int[rectangle.length][0];
        int i = 0;
        for (int[] row : rectangle) {
            r[i++] = row.clone();
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        histories.push(new int[]{row1, col1, row2, col2, newValue});
    }
    
    public int getValue(int row, int col) {
        for (int[] his: histories) {
            if (his[0] <= row && row <= his[2] && his[1] <= col && col <= his[3]) {
                return his[4];
            }
        }
        return r[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
