class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
     int n = arr.length;
		Arrays.sort(arr);
		int minDiff=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++){
			minDiff=Math.min(minDiff,arr[i+1]-arr[i]);
		}

		List<List<Integer>>ans= new ArrayList<>();
		for(int i=1;i<n;i++){
			if(arr[i]-arr[i-1]==minDiff){
				ans.add(Arrays.asList(arr[i-1],arr[i]));
			}
		}
		return ans;   
    }
}