public class Solution {
    public String addBinary(String a, String b) {
        if(b.length()>a.length()) return addBinary(b,a);
        int[] sum = new int[a.length()+1];
        for (int i = 0; i < a.length(); i++) {
            int indexa = a.length()-1-i;
            int indexb = b.length()-1-i;
            int x = Character.getNumericValue(a.charAt(indexa));
            int y;
            if(indexb>=0){
                y = Character.getNumericValue(b.charAt(indexb));
            }else {
                y = 0;
            }
            sum[indexa+1]=x+y;
        }
        int x=0;
        for (int i = sum.length-1; i >=0; i--) {
            sum[i]+=x;
            x = sum[i]/2;
            sum[i]=sum[i]%2;
        }
        String result="";
        for (int i = 0; i <sum.length; i++) {
            result+=(char)('0'+sum[i]);
        }
        if (sum[0]==0){
            return result.substring(1,result.length());
        }else {
            return result;
        }
    }
}
