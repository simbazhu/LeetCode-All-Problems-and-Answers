class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) cnt = 0;
            else if (++cnt == 3) return true;
        }
        return false;
    }
}
