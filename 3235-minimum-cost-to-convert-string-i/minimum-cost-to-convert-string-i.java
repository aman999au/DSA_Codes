class Solution {

   static class Pair {
	int key;
	char val;
    public Pair(int key, char val) {
        this.key = key;
        this.val = val;
    }
    public int getKey() {
        return key;
    }
    public char getVal() {
        return val;
    }

}

	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		Map<Character,List<Pair>>adjMat=new HashMap<>();

		for(int i=0;i<original.length;i++){
			adjMat.computeIfAbsent(original[i], k->new ArrayList<>()).add(new Pair(cost[i], changed[i]));

		}
		long[][] costMat=new long[26][26];
		for(long[] cs:costMat)Arrays.fill(cs,Integer.MAX_VALUE);

		//Populate costMat using Dijkstra
		for(char ch:original){
			
			dikstra(ch,adjMat,costMat);
		}
		long ans=0;
		for(int i=0;i<source.length();i++){
			char s = source.charAt(i);
			char t = target.charAt(i);

			if(s==t)continue;
			if(costMat[s-'a'][t-'a']==Integer.MAX_VALUE)return -1;
			else ans+=costMat[s-'a'][t-'a'];
		}

		return ans;

	}
	private void dikstra(char source, Map<Character,List<Pair>> adjMat, long[][] costMat) {
		PriorityQueue<Pair>pq= new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
		pq.add(new Pair(0, source));
		
		while(!pq.isEmpty()){
			Pair current = pq.poll();
			int d=current.getKey();
			char node=current.getVal();
			for(Pair child:adjMat.getOrDefault(node, new ArrayList<>())){
				char adjNode = child.getVal();
				int dist = child.getKey();
				if(costMat[source-'a'][adjNode-'a']>dist+d){
					costMat[source-'a'][adjNode-'a']=d+dist;
					pq.add(new Pair(dist+d, adjNode));
				}

			}
		}
	}





    /*
   public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
		long[][]adjMat = new long[26][26];
		for(long[] v:adjMat)Arrays.fill(v, Integer.MAX_VALUE);

		//Floyd Warshall Method
		floydWarshall(adjMat,original,changed,cost);

		long ans = 0;
		for(int i=0;i<source.length();i++){
			char src = source.charAt(i);
			char tg= target.charAt(i);
			if(src==tg)continue;
			if(adjMat[src-'a'][tg-'a'] == Integer.MAX_VALUE){
				return -1;
			}
			ans+=adjMat[src-'a'][tg-'a'];
			}

			return ans;
    }

	private void floydWarshall(long[][] adjMat, char[] original, char[] changed, int[] cost) {
		for(int i=0;i<original.length;i++){
			int s = original[i] -'a';
			int t = changed[i]-'a';
			adjMat[s][t]=Math.min(adjMat[s][t], (long)cost[i]);
		}

		// Apply Floyd Warshall

		for(int k=0;k<26;++k){

			for(int i=0;i<26;++i){

				for(int j=0;j<26;++j){
					adjMat[i][j]=Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);
				}

			}
		}
		
	}

    */
}