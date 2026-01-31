class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
			int lo=0,hi=n-1;
			int idx=0;
			while(lo<=hi){
				int mid=lo + (hi-lo)/2;
				if(letters[mid]==target){
					lo=mid+1;
				}else if(letters[mid]<target){
					lo=mid+1;
				}else {
					idx=mid;
					hi=mid-1;};
			}
			return letters[idx];
        }
}