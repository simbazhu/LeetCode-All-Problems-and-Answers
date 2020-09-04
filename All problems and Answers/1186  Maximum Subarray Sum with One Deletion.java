class Solution {
    public int maximumSum(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int maxNoDeletion = nums[0];
        int maxWithDeletion = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < N; ++i){
            maxWithDeletion = Math.max(maxNoDeletion, maxWithDeletion + nums[i]);
            maxNoDeletion = Math.max(maxNoDeletion + nums[i], nums[i]);
            
            max = Math.max(max, maxNoDeletion);
            max = Math.max(max, maxWithDeletion);
        }
        
        return max;
    }
}
