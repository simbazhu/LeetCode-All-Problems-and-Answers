class NumArray {

    private int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int l = i; l <= j; l++) {
            sum += nums[l];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
