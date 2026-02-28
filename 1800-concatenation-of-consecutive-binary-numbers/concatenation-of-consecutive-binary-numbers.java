class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
      
        long result = 0;
      
        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            int bitsRequired = 32 - Integer.numberOfLeadingZeros(currentNumber);
          
            
            result = ((result << bitsRequired) | currentNumber) % MOD;
        }      
        return (int) result; 
    }
}