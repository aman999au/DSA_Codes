class Solution {
        public int minimumCost(int[] nums) {
             int n = nums.length;
		int minNum=Integer.MAX_VALUE;
		int secMin=Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
			if(nums[i]<minNum){
				secMin=minNum;
				minNum=nums[i];
			}
			else if(nums[i]<secMin)secMin=nums[i];
		}
		
		return nums[0]+secMin+minNum; 
        }
}