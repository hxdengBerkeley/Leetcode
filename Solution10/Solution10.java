/**
 * Created by denghanxiao on 2017/4/27.
 */
public class Solution10 {
    public static boolean isMatch(String s, String p) {             //dp[i+1][j+1] 表示s.substring(0,i)能否与p.substring(0,j)匹配！！！！
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        dp[0][0] =true;

        for (int i = 0; i < p.length(); i++) {                      //s.substring(0,0)能否与p.substring(0,j)匹配！！
            if (p.charAt(i)=='*') dp[0][i+1] = dp[0][i-1];
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i)) dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j) == '.') dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1)!= '.' && p.charAt(j-1)!=s.charAt(i)) {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else {
                        dp[i+1][j+1] = (dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1]); //注意dp[i][j+1]!!! a* acts as multiple a
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        String s ="aasdfasdfasdfasdfas",p ="aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(isMatch(s,p));
    }
}
