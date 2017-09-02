public class Solution {
    public boolean isMatch(String s, String p) {
        int si=0,pi=0,starIdx=-1,match=-1;
        while(si<s.length()){
            if (pi<p.length()){
                if(p.charAt(pi)=='?'||p.charAt(pi)==s.charAt(si)){
                    si++;
                    pi++;
                    continue;
                }
                if (p.charAt(pi)=='*'){
                    starIdx=pi;
                    match = si-1;
                    pi++;
                    continue;
                }
            }
            if(starIdx!=-1){
                match++;
                si = match;
                pi = starIdx+1;
                continue;
            }
            return false;
        }
        while(pi<p.length()&&p.charAt(pi)=='*'){
            pi++;
        }
        return pi==p.length();
    }
}
