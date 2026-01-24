class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n/2;i++){
            maxSum=Math.max(maxSum,nums[i]+nums[n-i-1]);
        }   
        return maxSum;    
    }
}