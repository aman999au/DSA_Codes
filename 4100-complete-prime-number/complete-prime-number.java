class Solution {
    public boolean isPrime(int num){
        if(num==0 || num==1)return false;
        if(num==2 || num==3)return true;
        if(num%2==0 || num%3==0)return false;
        for(int i=5;i*i<=num;i+=6){
            if(num%i==0 || num%(i+2)==0)return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
		boolean ans = isPrime(num);
		if(!ans)return false;
        boolean prefix=true;
        boolean suffix=true;
		int preVal =0;
		int suffVal=0;
        String numStr= String.valueOf(num);
		for(int i=0;i<numStr.length()-1;i++){
			int digit = numStr.charAt(i) - '0'; 
			preVal = preVal*10+digit;
			prefix=isPrime(preVal);
			if(!prefix)return false;
		}
		
	int len = (int)Math.pow(10, numStr.length()-1);
		while(num>0 && len>1) {
			num%=len;
			// System.out.println(num+" ");
			suffix=isPrime(num);
			if(!suffix)return false;
			len/=10;
		}
    return ans && prefix && suffix;
    }
}