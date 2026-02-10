class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
		int mxLen = 0;
		for(int i=0;i<n;i++){
			HashSet<Integer>oddSet = new HashSet<>();
			HashSet<Integer>evenSet = new HashSet<>();
			if((nums[i]&1)==0)evenSet.add(nums[i]);
			else oddSet.add(nums[i]);
			for(int j=i+1;j<n;j++){
				if((nums[j]&1)==0)evenSet.add(nums[j]);
				else oddSet.add(nums[j]);
				int eLen = evenSet.size();
				int oLen = oddSet.size();
				if(eLen==oLen)mxLen=Math.max(mxLen, j-i+1 );
			}
		}
		return mxLen;
    }
}