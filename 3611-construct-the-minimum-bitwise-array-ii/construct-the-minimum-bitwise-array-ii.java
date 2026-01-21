class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
      int size = nums.size();
		int[] ans = new int[size];
		for(int i=0;i<size;i++){
			int num = nums.get(i);
			if(num==2){
				ans[i]=-1;
			}
			else{

				for(int j = 1;j<32;j++){
					if((num >> j & 1)==0){
						ans[i]= num ^ (1<<(j-1));
						break;
					}
				}
			}
		}
		return ans;
    }
}