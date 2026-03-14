class Solution {
    // List to store all valid happy strings in lexicographical order
    private List<String> happyStrings = new ArrayList<>();
    // StringBuilder to build the current string during DFS
    private StringBuilder currentString = new StringBuilder();
    // Target length of happy strings
    private int targetLength;
    // The k-th happy string to find
    private int targetIndex;

    /**
     * Returns the k-th lexicographically smallest happy string of length n.
     * A happy string is a string where no two adjacent characters are the same.
     * 
     * @param n the length of the happy string
     * @param k the index (1-based) of the happy string to return
     * @return the k-th happy string, or empty string if less than k happy strings exist
     */
    public String getHappyString(int n, int k) {
        this.targetLength = n;
        this.targetIndex = k;
      
        // Generate all happy strings using DFS
        generateHappyStrings();
      
        // Return the k-th string if it exists, otherwise return empty string
        return happyStrings.size() < k ? "" : happyStrings.get(k - 1);
    }

    /**
     * Recursively generates all happy strings of the target length using DFS.
     * Uses backtracking to explore all valid combinations of 'a', 'b', 'c'.
     */
    private void generateHappyStrings() {
        // Base case: if current string reaches target length, add it to the result list
        if (currentString.length() == targetLength) {
            happyStrings.add(currentString.toString());
            return;
        }
      
        // Optimization: stop generating if we already have k strings
        if (happyStrings.size() >= targetIndex) {
            return;
        }
      
        // Try appending each character 'a', 'b', 'c'
        for (char character : "abc".toCharArray()) {
            // Check if we can append this character (either string is empty or last char is different)
            if (currentString.isEmpty() || currentString.charAt(currentString.length() - 1) != character) {
                // Append the character
                currentString.append(character);
              
                // Recursively generate the rest of the string
                generateHappyStrings();
              
                // Backtrack: remove the last character to try other options
                currentString.deleteCharAt(currentString.length() - 1);
            }
        }
    }
}
