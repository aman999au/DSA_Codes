class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
 List<Integer>hList = new ArrayList<>();
		hList.add(1);
		hList.add(m);
		for(int v:hFences)hList.add(v);
		
		List<Integer>vList = new ArrayList<>();
		vList.add(1);
		vList.add(n);
		for(int v:vFences)vList.add(v);

		int hLen = hList.size();
		int vLen = vList.size();

		Set<Integer>width = new HashSet<>();

		for(int i=0;i<vLen;i++){
			for(int j=i+1;j<vLen;j++){
				width.add(Math.abs(vList.get(j)-vList.get(i)));
			}
		}
		long mxSide =0;
		for(int i=0;i<hLen;i++){
			for(int j=i+1;j<hLen;j++){
				int height=Math.abs(hList.get(j)-hList.get(i));
				if(width.contains(height)){
					mxSide = Math.max(mxSide, height);
				}
			}
		}

        int MOD=1000000007;
		return mxSide==0?-1:(int)((mxSide*mxSide)%MOD);
 
}
}