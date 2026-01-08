class Solution {
    int m,n;
	int[][]dp = new int[501][501];

    public int solve(int []nums1,int []nums2,int i,int j){
		if(i==m|| j==n)return (int)-1e9;
		if(dp[i][j]!=(int)-1e9)return dp[i][j];

		int val = nums1[i]*nums2[j];
		int inc_i_j = (nums1[i] * nums2[j]) + solve(nums1, nums2, i+1, j+1);
		int inc_i = solve(nums1, nums2, i, j+1);
		int inc_j = solve(nums1, nums2, i+1, j);

		return dp[i][j]= Math.max(Math.max(val, inc_i_j),Math.max(inc_i, inc_j));
	}
	public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
		 n = nums2.length;
		for(int[] row:dp){
			Arrays.fill(row, (int)-1e9);
		}

		return solve(nums1, nums2, 0, 0);


    }
}