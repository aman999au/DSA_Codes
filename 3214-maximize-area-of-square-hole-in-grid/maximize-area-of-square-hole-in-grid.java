class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hLen=hBars.length;
        int vLen=vBars.length;
        int hmx=1;
        int vmx=1;
        int hInc=1;
        
        for(int i=0;i<hLen-1;i++){
            if(hBars[i+1]-hBars[i]==1)hInc++;
            else {
                hInc=1;
            }
            hmx=Math.max(hmx,hInc);
        }

        int vInc=1;
        for(int i=0;i<vLen-1;i++){
            if(vBars[i+1]-vBars[i]==1)vInc++;
            else {
                vInc=1;
            }
            vmx=Math.max(vmx,vInc);
        }

        int side = Math.min(vmx,hmx)+1;
        return side*side;
    }
}