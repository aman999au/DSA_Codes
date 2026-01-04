class Solution {
    // Optimal Approch
  public boolean isPrime(int num){
        if(num==1)return false;
        if(num==2 || num==3)return true;
        if(num%2==0 || num%3==0)return false;
        for(int i=5;i*i<=num;i+=6){
            if(num%i==0 || num%(i+2)==0)return false;
        }
        return true;
    }
    public  int sumFourDivisors(int[] nums) {
       int total=0;
		for(int num:nums){
			// for cube root -> 1+p+p^2+p^3
			int p = (int)Math.round(Math.cbrt(num));
			if((long)p*p*p == num && isPrime(p)){
				total+=(1+p+p*p+num);
				continue;
			}

			//  coprime p*q
			for(int i=2;i*i<=num;i++){

				if(num%i==0){
					int j = num/i;
					if(i!=j && isPrime(i) && isPrime(j))
						total+=1+i+j+num;
					break;
				}
			}
		}
		return total;
	}
    
    // Brute Force Approch
    /* 
    public int sumFourDivisors(int[] nums) {

       
          Map<Integer,HashSet<Integer>>mp = new HashMap<>();
		int ans = 0;

		for(int num:nums){
			if(!mp.containsKey(num))
			mp.put(num, new HashSet<>());
			HashSet<Integer>hset = mp.get(num);
			if(hset.size()==0 ){
				for(int i=1;i*i<=num;i++){
					if(num%i==0){
						if(num/i == i){
							hset.add(i);
						}else{
							hset.add(i);
							hset.add(num/i);
						} 
						
					}
				}
			}
		}
		
		for(int num:nums){
			HashSet<Integer>st = mp.get(num);
			if(st.size()==4){
				ans+=st.stream().mapToInt(Integer::intValue).sum();
			}
		}
		return ans;
        }
        */


    
}