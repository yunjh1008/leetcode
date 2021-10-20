// 53. Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        // Get maximum sub array sum of the given array in O(n) by using Kadane's Algorithm
		    // Learn more: https://r4bb1t.tistory.com/10
        int currentMaxSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
        }
        
        return maxSum;
    }
}
