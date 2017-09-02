public class Solution {
    public boolean isValid(String s) {
		Stack<Character> read = new Stack<>();
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
				read.push(s.charAt(i));
			}else{
				if (read.empty()){
					return false;
				}else {
					if(read.peek()=='('&&s.charAt(i)==')'||read.peek()=='['&&s.charAt(i)==']'||read.peek()=='{'&&s.charAt(i)=='}'){
						read.pop();
						continue;
					}else {
						return false;
					}
				}
			}

		}
		if(read.empty()){
			return true;
		}else{
			return false;
		}
    }
}
