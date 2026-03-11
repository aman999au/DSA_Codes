class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
      
        int result = 0;
        int bitPosition = 0;
      
        while (n != 0) {
            int flippedBit = (n & 1) ^ 1;
          
            result |= flippedBit << bitPosition;
          

            bitPosition++;
          
            n >>= 1;
        }
      
        return result;
    }
}