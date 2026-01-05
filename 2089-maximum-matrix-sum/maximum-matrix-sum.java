class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix[0].length;
		long total =0;
		int totalNeg=0;
		int minAbs = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]<0)++totalNeg;
				int absVal =Math.abs(matrix[i][j]);
				minAbs=Math.min(minAbs, absVal);
				total+=absVal;
			}
		}
		if(totalNeg%2==0)return total;
		return total - 2*minAbs;
    }
}