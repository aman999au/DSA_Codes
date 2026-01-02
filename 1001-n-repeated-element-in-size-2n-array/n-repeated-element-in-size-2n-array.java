class Solution {
    public int repeatedNTimes(int[] nums) {
       int n = nums.length;
		boolean[] isRep = new boolean[10001];
    
        for(int num:nums){
            if(!isRep[num]){
                isRep[num]=true;
            }else return num;
        }
		return -1;
    }
}