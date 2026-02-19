class Solution {public static boolean binarysearch(int arr[], int m,
                                     int x)
  {
    int l = 0;
    int r = m - 1;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (arr[mid] == x) {
        return true;
      }
      else if (arr[mid] < x) {
        l = mid + 1;
      }
      else {
        r = mid - 1;
      }
    }
   
    return false;
  }
    public int countBinarySubstrings(String s) {
       int index = 0;
        int length = s.length();
      
        List<Integer> groupCounts = new ArrayList<>();
      
       
        while (index < length) {
            int count = 1;
          
            while (index + 1 < length && s.charAt(index + 1) == s.charAt(index)) {
                index++;
                count++;
            }
          
          
            groupCounts.add(count);
            index++;
        }
      
     
        int result = 0;
      
        for (int i = 1; i < groupCounts.size(); i++) {
            result += Math.min(groupCounts.get(i - 1), groupCounts.get(i));
        }
      
        return result;
    }
}