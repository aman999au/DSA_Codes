class Solution {
    public int binaryGap(int n) {
        int mxGap =0;
        int curPosi=0;
        int prevPosi=100;
        while(n>0){
            if((n&1)==1){
                mxGap=Math.max(mxGap,curPosi-prevPosi);
                 prevPosi=curPosi;
            }
            n>>=1;
        curPosi++;
        }
        return mxGap;
    }
}