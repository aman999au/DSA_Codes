class Solution {
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
				// System.out.println(mp);
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
}