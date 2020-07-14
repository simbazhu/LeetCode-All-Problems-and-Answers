class Solution {
    public int minCostToMoveChips(int[] chips) {
        int[] cnt = new int[2];
        for (int chip : chips)
            ++cnt[chip % 2];
        return Math.min(cnt[0], cnt[1]);
    }
}
