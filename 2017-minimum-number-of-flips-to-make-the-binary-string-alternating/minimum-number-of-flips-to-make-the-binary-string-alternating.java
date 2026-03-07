public class Solution {
    public int minFlips(String s) {
        int start_1 = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                start_1 += s.charAt(i) == '1' ? 1 : 0;
            } else {
                start_1 += s.charAt(i) == '0' ? 1 : 0;
            }
        }

        int start_0 = n - start_1;
        int ans = Math.min(start_0, start_1);
        if (n % 2 == 0) {
            return ans;
        }

        int dp0 = start_0, dp1 = start_1;
        for (char c : s.toCharArray()) {
            int temp = dp0;
            dp0 = dp1;
            dp1 = temp;
            if (c == '1') {
                dp0++;
                dp1--;
            } else {
                dp0--;
                dp1++;
            }
            ans = Math.min(ans, Math.min(dp0, dp1));
        }

        return ans;
    }
}