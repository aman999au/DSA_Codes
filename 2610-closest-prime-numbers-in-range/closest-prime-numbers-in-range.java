class Solution {
//Aman
static int left = 0, right = 100_00_00;
	static boolean[] isPrime = new boolean[right + 1];
	static {

		for (int i = 0; i <= right; i++)
			isPrime[i] = true;

		isPrime[0] = isPrime[1] = false;

		for (int i = left; (long) i * i <= right; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= right; j += i) {
					isPrime[j] = false;
				}
			}
		}

	}

	public int[] closestPrimes(int left, int right) {
		List<Integer> primes = new ArrayList<>();
		int[] ans = new int[2];
		ans[0] = -1;
		ans[1] = -1;

		for (int i = left; i <= right; i++) {
			if (isPrime[i])
				primes.add(i);
		}
		int n = primes.size();
		if (n == 0 || n == 1)
			return ans;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < primes.size(); i++) {
			int fnum = primes.get(i - 1);
			int snum = primes.get(i);
			int diff = snum - fnum;
			if (diff < minDiff) {
				minDiff = diff;
				ans[0] = fnum;
				ans[1] = snum;
			}
		}
		return ans;


	}
}