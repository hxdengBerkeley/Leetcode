public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> resulti = new ArrayList<>();
        IpA(result,resulti,s,0);
        return result;
    }
    public void IpA(List<String> result, List<String> resulti, String s, int index) {
        if (resulti.size()==4&&index==s.length()){
            result.add(resulti.get(0)+'.'+resulti.get(1)+'.'+resulti.get(2)+'.'+resulti.get(3));
        }else if (resulti.size()<4&&index<s.length()){
            for (int i = index; i < s.length() && i-index<=2; i++) {
                if (s2int(s.substring(index,i+1))==-1) return;
                if (s2int(s.substring(index,i+1))<=255){
                    List<String> resulticpy = new ArrayList<>(resulti);
                    resulticpy.add(s.substring(index,i+1));
                    IpA(result,resulticpy,s,i+1);
                }
            }
        }
    }

    public int s2int(String s){
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            result = result*10 + Character.getNumericValue(s.charAt(i));
            if (result==0&&s.length()!=1) return -1;
        }
        return result;
    }
}