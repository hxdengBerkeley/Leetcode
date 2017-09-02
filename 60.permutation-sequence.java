public class Solution {
	public String getPermutation(int n, int k) {
		String result = "";
		List<Character> number = new ArrayList<>();
		for (int i = 1; i <=n ; i++) {
			number.add((char)('0'+i));
		}
		k--;
		for(int i=n-1; i>=1; i--){
			int order = k/jiecheng(i);
			result+=(number.get(order));
			number.remove(order);
			k = k%jiecheng(i);
		}
		result+=(number.get(0));
		return result;

	}
	public int jiecheng(int n){
		if(n==0) return 1;
		else return n*jiecheng(n-1);
	}
}
