class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int pos = n-1;

        while(pos>=0 && digits[pos]==9){
            digits[pos]=0;
            pos--;
        }
        int[] ans = null;
        if(pos<0){
            ans= new int[n+1];
            ans[0]=1;
            for(int i=0;i<n-1;i++){
                ans[i+1]=digits[i];
            }
            System.out.println(Arrays.toString(ans));
            return ans;
            // digits[0]=1;
            // digits[1]=0;
        }else digits[pos]++;
    return digits;

    }
}