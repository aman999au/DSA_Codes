class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
		if(k==1 || n==1)return 0;
		Arrays.sort(nums);
		
		int minDiff=Integer.MAX_VALUE;
		for(int i=0;i<=n-k;i++){
            int curDiff = nums[k+i-1]-nums[i];
            minDiff = Math.min(curDiff,minDiff);
        }

		return minDiff;
    }
}