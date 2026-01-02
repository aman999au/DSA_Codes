class Solution {
    public int repeatedNTimes(int[] nums) {
       int n = nums.length;
		for(int i=0;i<n;i++){
            if(i+1 <n && nums[i]==nums[i+1])return nums[i];
            if(i+2 < n && nums[i]==nums[i+2])return nums[i];
        }
        return nums[n-1];
    }
}