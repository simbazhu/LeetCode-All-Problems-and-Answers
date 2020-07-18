class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n==1) {
            return arr[0];
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4],arr[n/2],arr[(3*n)/4]));
        for (int element : list) {
            int f = firstOccurrence(arr,element);
            int l = lastOccurrence(arr,element);
            if(l-f+1>n/4) {
                return element;
            }
        }
        return -1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==start || nums[middle-1]<target)) {
                return middle;
            }
            if(target > nums[middle])
                start = middle + 1;
            else
                end = middle;
        }
        return start;

    }

    private int lastOccurrence(int[] nums,int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==end || nums[middle+1]>target)) {
                return middle;
            }
            if(nums[middle] > target)
                end = middle;
            else
                start = middle + 1;
        }
        return start;

    }
}
