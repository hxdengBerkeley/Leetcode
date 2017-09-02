import java.lang.Integer;
public class Solution7 {
    public static int reverse(int x) {
        int y = x,result=0;
        while(y!=0){
        	if(result<Integer.MIN_VALUE/10||result>Integer.MAX_VALUE/10){
            	return 0;
            }
            result=result*10+y%10;
            y=y/10;
        }
        return result;
    }
    public static void main(String[] args) {
    	int x=-2147483648;
    	System.out.println(reverse(x));
    }
}