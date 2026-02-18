class Solution {
    public boolean hasAlternatingBits(int n) {
        int x= n>>1;
        int y= x^n;

        return (y&(y+1))==0;
    }
}