class Solution {
    public boolean isPerfectSquare(int num) {
        for(long i=1;i*i<=num;i++){
            if((double)num/i==i)return true;
        }
        return false;
    }
}