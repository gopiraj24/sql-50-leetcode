class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();

        // Length check (most important) 
        if (n + m != s3.length()) return false;

         // dp[i][j] = can s1[0..i-1] and s2[0..j-1] form s3[0..i+j-1]
         boolean[][] dp = new boolean[n + 1][m + 1];

        //  Base case 
        dp[0][0] = true;

        // Fill first column (only s1 used) 

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        //  Fill first row only (s2 Used) 

        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j - 1); 
        }

        //  Fill rest of fp table 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                
                char c = s3.charAt(i + j - 1);

                boolean froms1 = dp[i-1][j] && s1.charAt(i-1) == c; 
                boolean froms2 = dp[i][j-1] && s2.charAt(j - 1) == c;

                dp[i][j] = froms1 || froms2;
            }
        }

        return dp[n][m];
        
    }
}