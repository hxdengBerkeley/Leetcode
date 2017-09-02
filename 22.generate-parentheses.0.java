public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
	backtrack(result, "" , 0, 0, n);
	return result;	
    }
    
	public static void backtrack(List<String> list, String str, int left, int right, int max){
		if(str.length() == max*2){
			list.add(str);
			return;
		}
		if(left<max){
			backtrack(list, str+"(", left+1, right, max);
		}
		if(right<left){
			backtrack(list,str+")", left, right+1, max);
		}
	}
}
