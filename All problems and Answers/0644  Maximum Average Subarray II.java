class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length <k || k<=0) return Integer.MIN_VALUE;
        double min = nums[0], max = nums[0];
        for(int i=0; i<nums.length; i++){
            if (nums[i]<min) min = nums[i];
            if (nums[i]>max) max = nums[i];
        }
        while (min <= max) { //binary search to find the max average between min and max
            double mid = min +(max-min)/2.0;
            if (hasAvgAbove(nums, k, mid)) {
                min = mid + 0.000_005; //error less than 10-5 will be accepted.
            } else max = mid - 0.000_005;
        }
        return max;
    }
    
    private boolean hasAvgAbove(int[] nums, int k, double target) {
        double sum = 0, extraSum =0;
        for(int i=0; i<k; i++){
            sum += nums[i]-target;
        }
        // must have at least k elements; the nums before the last k element should be kept if their sum > 0;
        // else we should remove them from the current sum (equivalent to update the start position)
        int curr = k;
        while (curr < nums.length) {
            if (sum >= 0) return true;
            sum += nums[curr] - target;
            extraSum += nums[curr-k] - target;
            if (extraSum < 0) { //update the start position of the current sum
                sum -= extraSum;
                extraSum = 0;
            }
            curr ++;
        }
        return sum >= 0;
    }
}
