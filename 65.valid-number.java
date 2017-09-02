public class Solution {
	int start=0;
        while(start<s.length()&&s.charAt(start)==' '){
		start++;
	}
	s=s.substring(start,s.length());
        if(s.length()==0) return false;
	boolean e=false,point=false;
        for (int i = 0; i < s.length(); i++) {
		if(!Character.isDigit(s.charAt(i))){
			if (s.charAt(i)=='e'){
				if (!e){
					e=true;
					continue;
				}else {
					return false;
				}
			}
			if (s.charAt(i)=='.'){
				if (!point){
					point=true;
					continue;
				}else {
					return false;
				}
			}

		}
	}
}
