class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
		int n = grid[0].length;

		int [][]cells=new int[m*n][2];
		int idx = 0;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				cells[idx][0]=i;
				cells[idx][1]=j;
				idx++;
			}
		}

		Arrays.sort(cells, (a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));

		int [][] cost = new int[m][n];

		for(int []c:cost){
			Arrays.fill(c, Integer.MAX_VALUE);
		}

		for(int t=0;t<k+1;t++){
			int minCost = Integer.MAX_VALUE;
			int start =0;

			for(int i=0;i<cells.length;i++){
				int x=cells[i][0];
				int y=cells[i][1];
				minCost=Math.min(minCost, cost[x][y]);
				if(i+1 <cells.length && grid[x][y]==grid[cells[i+1][0]][cells[i+1][1]])
					continue;

				for(int j=start;j<=i;j++){
					cost[cells[j][0]][cells[j][1]]=minCost;
				}
				start=i+1;

			}

			for(int i=m-1;i>=0;i--){
				for(int j=n-1;j>=0;j--){
					if(i==m-1 && j==n-1)cost[i][j]=0;

					if(i!=m-1){
						cost[i][j]=Math.min(cost[i][j], grid[i+1][j]+cost[i+1][j]);
					}

					if(j!=n-1){
						cost[i][j]=Math.min(cost[i][j], grid[i][j+1]+cost[i][j+1]);
					}
				}

			}
		}
		return cost[0][0];
    }
}