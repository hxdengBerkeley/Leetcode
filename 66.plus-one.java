public class Solution {
    public int[] plusOne(int[] digits) {
	int[] result = new int[digits.length+1];
	digits[digits.length-1]+=1;
	System.arraycopy(digits,0,result,1,digits.length);
	for(int i=result.length-1; i>0; i--){
		result[i-1]+=result[i]/10;
		result[i]=result[i]%10;
	}
	if(result[0]==0){
		System.arraycopy(result,1,digits,0,digits.length);
		return digits;
	}else{
		return result;
	}
    }
}
