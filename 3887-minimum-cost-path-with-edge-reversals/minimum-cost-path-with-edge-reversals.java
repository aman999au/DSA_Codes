class Pair {
	int node;
	int dist;

	public Pair(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}
class Solution {
    public int minCost(int n, int[][] edges) {

		Map<Integer, List<Pair>> adj = new HashMap<>();

		for (int[] edge : edges) {
			// int[] edge;
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];

			adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, wt));
			adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u,2* wt));

		}
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		pq.offer(new Pair(0, 0));

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			int node = cur.node;
			int d = cur.dist;

			if (d > dist[node])
				continue;
			if (node == n - 1)
				return d;

			if (!adj.containsKey(node))
				continue;

			for (Pair ne1 : adj.get(node)) {
				int nextNode = ne1.node;
				int weight = ne1.dist;

				if (d + weight < dist[nextNode]) {
					dist[nextNode] = d + weight;
					pq.offer(new Pair(nextNode, dist[nextNode]));
				}
			}

		}
		return -1;        
    }
}