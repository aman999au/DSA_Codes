class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        
		int n = nums.size();
		int[] ans = new int[n];
		int idx =0;
        for(int num:nums){
			boolean find=false;
			for(int j=1;j<num;j++){
				if((j | (j+1))==num){
					ans[idx]=j;
					idx++;
					find=true;
					break;
				}
			}
			if(!find){
				ans[idx++]=-1;
			}
		}
		return ans;
    }
}