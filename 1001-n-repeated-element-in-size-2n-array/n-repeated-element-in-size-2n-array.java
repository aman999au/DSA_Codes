class Solution {
    public int repeatedNTimes(int[] nums) {
       int n = nums.length;
		Map<Integer,Integer> mp=new HashMap<>();
		
		for(int i=0;i<n;i++){
			mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
			if(mp.get(nums[i])>=2)return nums[i];
		}
		return -1;
    }
}