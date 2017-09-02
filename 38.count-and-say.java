public class Solution {
    public String countAndSay(int n) {
	if(n==1){
		return "1";
	}else{
		String s2="", s1 = countAndSay(n-1);	
		int i=0,j;
		char now;
		while(i<s1.length()){
			now = s1.charAt(i);
			j=i;
			while(j<s1.length()&&s1.charAt(j)==now){
				j++;
			}
			s2+=(char)('0'+(j-i));
			s2+=now;
			i=j;
		}
		return s2;
	}
    }
}
