class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int existingOnesCounts = 0;
      
        for (String binaryString : nums) {
            int onesCount = 0;
          
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    onesCount++;
                }
            }
          
            existingOnesCounts |= (1 << onesCount);
        }
      
        for (int targetOnesCount = 0; ; targetOnesCount++) {
            if ((existingOnesCounts >> targetOnesCount & 1) == 0) {
                return "1".repeat(targetOnesCount) + "0".repeat(nums.length - targetOnesCount);
            }
        }
    }
}