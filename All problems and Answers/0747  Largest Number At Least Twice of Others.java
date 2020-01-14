class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int largest = 0, secondLargest = 0;
        
        if (nums[0] > nums[1]) {
            largest = 0;
            secondLargest = 1;
        }
        else {
            largest = 1;
            secondLargest = 0;
        }
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[largest]) {
                secondLargest = largest;
                largest = i;
            }
            else if (nums[i] > nums[secondLargest]) {
                secondLargest = i;
            }
        }
        
        return nums[largest] >= nums[secondLargest] * 2 ? largest : -1;
    }
}
