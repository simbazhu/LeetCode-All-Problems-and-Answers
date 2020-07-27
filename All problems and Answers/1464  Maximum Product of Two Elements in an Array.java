class Solution {
    public int maxProduct(int[] nums) {
        int m = Integer.MIN_VALUE, n = m;
        for (int num: nums) {
            if (num >= m) {
                n = m;
                m = num;
            }else if (num > n) {
                n = num;
            }
        } 
        return (m - 1) * (n - 1);
    }
}
