class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i =0; i < len; i++){
            for(int j = i; j < len; j++){
                if(isIncreasingSubArray(nums, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isIncreasingSubArray(int[]nums, int start, int end){
        int len = nums.length;
        int prev = 0;
        for(int i = 0; i < len; i++){
            if(i<=end && i>= start){
                continue;
            }
            if (nums[i] <= prev) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }
}