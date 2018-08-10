/**
 * Creator : wts
 * Date : 7/2/18
 * Title : 132. Palindrome Partitioning II
 * Description :
 * Analysis :
 */

class NaiveDP {
    private int cut = Integer.MAX_VALUE;
    private int[] dp;
    private int total;
    public int minCut(String s) {
        if(s.equals("")){
            return 0;
        }
        total = s.length();
        dp = new int[s.length() + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        helper(s);
        return dp[0];
    }

    public int helper(String s){

        if(dp[total - s.length()] != Integer.MAX_VALUE)
            return dp[total - s.length()];

        if(s.length() == 0){
            dp[total - s.length()] = -1;
            return -1;
        }

        for(int i = 0; i < s.length(); i++){
            if(ispalindrome(s.substring(0,i + 1))){
                dp[total - s.length()] = Math.min(dp[total - s.length()], 1 + helper(s.substring(i + 1)));
            }
        }

        return dp[total - s.length()];

    }

    public boolean ispalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}

class HighVoteDP{
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
