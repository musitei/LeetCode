class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];//存放true或false
        String ans = "";//初始化ans
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                //如果字串长度为1，则是回文数
                    dp[i][j] = true;
                } else if (l == 1) {
                //如果字串长度为2，则判断两个元素是否相等
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                //子串长度大于 2时，判断首和尾字符是否相同，且判断s[i+1,j-1]是否时回文子串
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                //最长回文字串
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}


