class Solution {
    public int reverseBits(int n) {
        int result = 0;
      
        // Process all 32 bits
        for (int bitPosition = 0; bitPosition < 32 && n != 0; bitPosition++) {
            // Extract the least significant bit (rightmost) from n
            int currentBit = n & 1;
          
            // Place the extracted bit at the mirrored position from the left
            // (31 - bitPosition) calculates the reverse position
            result |= currentBit << (31 - bitPosition);
          
            // Right shift n by 1 position (unsigned shift to handle negative numbers correctly)
            n >>>= 1;
        }
      
        return result;
    }
}