class Solution {
    private static final Set<Integer> PRIME_NUMBERS = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

    public int countPrimeSetBits(int left, int right) {
        int primeSetBitCount = 0;
      
        for (int currentNumber = left; currentNumber <= right; currentNumber++) {
            
            int setBitCount = Integer.bitCount(currentNumber);
          
            
            if (PRIME_NUMBERS.contains(setBitCount)) {
                primeSetBitCount++;
            }
        }
      
        return primeSetBitCount;
    }
}