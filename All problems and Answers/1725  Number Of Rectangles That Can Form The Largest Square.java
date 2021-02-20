class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int cnt = 0, mx = 0;
        for (int[] rec : rectangles) {
            int side = Math.min(rec[0], rec[1]);
            if (side > mx) {
                cnt = 1;
                mx = side;
            }else if (side == mx) {
                ++cnt;
            }
        }
        return cnt;
    }
}
