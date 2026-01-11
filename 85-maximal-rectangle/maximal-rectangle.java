class Solution {
   // Nearest smallest to left
	public int[] getNSL(int[] height){
		int n = height.length;
		int[]ans = new int[n];
		int j=0;
		Stack<Integer>st = new Stack<>();
		for(int i=0;i<n;i++){
			if(st.empty())ans[i]=-1;
			else{
				while (st.size()>0 && height[st.peek()] >=height[i]) 
					st.pop();
				if(st.empty())ans[i]=-1;
				else ans[i]=st.peek();
			}
			st.push(i);
		}
		return ans;
	}

	// nearest smallest to right
	public int[] getNSR(int[]height){
		int n = height.length;
		int[]ans = new int[n];
		int j=0;
		Stack<Integer>st = new Stack<>();
		for(int i=n-1;i>=0;i--){
			if(st.empty())ans[i]=n;
			else{
				while (st.size()>0 &&  height[st.peek()] >=height[i]) 
					st.pop();
				if(st.empty())ans[i]=n;
				else ans[i]=st.peek();
			}
			st.push(i);
		}
		return ans;
		}
	

	public int largetAreaHistogram(int[]arr){
		int[]left = getNSL(arr);
		int[]right = getNSR(arr);
		int ans =0;
		int n = arr.length;
		for(int i=0;i<n;i++){
			int val = right[i]-left[i]-1;
			ans=Math.max(ans, val* arr[i]); 
		}
		return ans;

	}

	public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
		int n = matrix[0].length;
		int[]height = new int[n];
		for(int i=0;i<n;i++){
			height[i]=(matrix[0][i]=='1') ? 1 : 0 ;
		}

		int maxArea =  largetAreaHistogram(height);

		for(int row =1 ;row<m;row++){
			for(int col = 0 ; col<n;col++){
				if(matrix[row][col]=='0')height[col]=0;
				else height[col]+=1;
			}
			maxArea = Math.max(maxArea, largetAreaHistogram(height));
		}
		return maxArea;

    }
}