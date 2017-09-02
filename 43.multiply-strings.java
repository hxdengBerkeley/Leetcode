public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()>num2.length()) return multiply(num2,num1);
        if(num2.length()==0||num1.length()==0) return null;
        int[] nums = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                int now = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                now += nums[i+j+1];
                nums[i+j+1] = now%10;
                nums[i+j] += now/10;
            }
        }
        String result = ""; boolean start=false;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0) start=true;
            if(start){
                result +=(char)(nums[i]+'0');
            }
        }
        if (start) return result;
        return "0";
    }
}
