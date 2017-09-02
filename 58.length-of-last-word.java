public class Solution {
    public int lengthOfLastWord(String s) {
	if(s.length()==0) return 0;
	int end=s.length()-1;
	while(end>=0&&s.charAt(end)==' '){
		end--;
	}
	end=Math.max(0,end);
	int start=end;
	while(start>=0 && s.charAt(start)!=' '){
		start--;
	}
	if(start==0&&end!=0){
		if(s.charAt(start)==' ') return end;
		return end+1;
	}
	if(start==0&&end==0) return 0;
	return end-start;
    }
}
