class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        //sort the array
        Arrays.sort(nums);

        //find the median for even or odd number of elements
        int median = nums.length%2==0 ? (nums[n/2] + nums[n/2-1])/2 : nums[n/2];
        int steps = 0;

        //calculate the steps - iterate over the nums array
        for(int num: nums){
            steps += Math.abs(num-median); //steps plus the absolute difference of number and median
        }
        return steps;
    }
}