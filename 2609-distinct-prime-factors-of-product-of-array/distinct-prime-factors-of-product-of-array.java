class Solution {
    Map<Integer,Integer>mp = new HashMap<>();

	 public void primeFactors(int num){
		boolean[] isPrime = new boolean[num+1];
		for(int i=0;i<=num;i++)isPrime[i]=true;
		isPrime[0]=isPrime[1]=false;
		for(int i = 2; i*i<=num;i++){
			if(isPrime[i]){
				// System.out.println(i);
				for(int j=i*i;j<=num;j+=i)
					isPrime[j]=false;
			}
		}
		for(int i=2;i<=num;i++)if(isPrime[i] && num%i==0)mp.put(i, mp.getOrDefault(i, 0)+1);
	 }
	
	 public  int distinctPrimeFactors(int[] nums) {
		for(int n:nums){
			primeFactors(n);
		}
		System.out.println(mp);
		return mp.size();
    }
}