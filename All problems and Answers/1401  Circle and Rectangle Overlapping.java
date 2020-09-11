class Solution {
    public boolean checkOverlap(int radius, int x, int y, int x1, int y1, int x2, int y2) {
        int yy = (y <= y2 && y >= y1) ? 0 : Math.min(Math.abs(y1 - y), Math.abs(y2 - y));
        int xx = (x >= x1 && x <= x2) ? 0 : Math.min(Math.abs(x1 - x), Math.abs(x2 - x));
        return xx * xx + yy * yy <= radius * radius;
    }
}
