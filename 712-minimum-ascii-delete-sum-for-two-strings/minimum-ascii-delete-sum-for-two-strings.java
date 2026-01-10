class Solution {
    int m , n;
    int[][]dp = new int[1001][1001];
	public int solve(char[] s1,char[] s2,int i,int j){
		if(i>m && j>n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
		if(i>m)return dp[i][j]=s2[j]+solve(s1, s2, i, j+1);
		if(j>n)return dp[i][j]=s1[i]+solve(s1, s2, i+1, j);

		if(s1[i]==s2[j])return dp[i][j]=solve(s1, s2, i+1, j+1);

		return dp[i][j]=Math.min(s1[i] + solve(s1, s2, i+1, j) ,s2[j] + solve(s1, s2, i, j+1));
        
			
		
	}
	public int minimumDeleteSum(String s1, String s2) {
        m = s1.length()-1;
		n=s2.length()-1;
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
		return solve(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }
}