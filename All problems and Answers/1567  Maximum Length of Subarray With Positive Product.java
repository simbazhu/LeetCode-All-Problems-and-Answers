class Solution {
    public int getMaxLen(int[] nums) {
        int firstEvenNeg = -1, firstOddNeg = -2, res = 0, negCount = 0;  // treat 0 neg as even
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // reset everytime you met a zero;
                negCount = 0; // neg count after last zero
                firstEvenNeg = i;
                firstOddNeg = -2;
            } else {
                if (nums[i] < 0) negCount++;  // number of negatives from last zero or head of array
                if (negCount == 1 && firstOddNeg == -2) firstOddNeg = i;   // init odd cnt neg;
                if (negCount % 2 == 0) res = Math.max(res, i - firstEvenNeg);  
                else if (firstOddNeg > -2) res = Math.max(res, i - firstOddNeg);  
            }
        }
        return res;
    }
}
