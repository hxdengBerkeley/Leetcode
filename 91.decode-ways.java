public class Solution {
    public static int numDecodings(String s) {
        if (s.length()==0) return 0;
        int[] dp = new int[s.length()];
        if (s.charAt(0)=='0') return 0;
        dp[0]=1;
        if (dp.length>1){
            if (s.charAt(1)=='0'&&s.charAt(0)!='1'&&s.charAt(0)!='2') return 0;
            if (s.charAt(1)!='0'&&(s.charAt(0)-'0')*10+(s.charAt(1)-'0')<=26) dp[1]=2;
            else dp[1]=1;
        }
        for (int i = 2; i < dp.length; i++) {
            int x=0;
            if (s.charAt(i)=='0'&&s.charAt(i-1)!='1'&&s.charAt(i-1)!='2') return 0;
            if (s.charAt(i)!='0') x+=dp[i-1];
            if (s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)-'6'<=0)) x+=dp[i-2];
            dp[i]=x;
        }
        return dp[dp.length-1];
    }
}