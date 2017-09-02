class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean sign1 = false, sign2=false;
        if (numerator<0) sign1=true;
        if (denominator<0) sign2=true;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        String result = "";
        long intPart = num/den;
        Stack<Character> stack = new Stack<>();
        while(intPart!=0){
            stack.push((char)('0'+intPart%10));
            intPart/=10;
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        if (result.length()==0) result+='0';
        den = Math.abs(den);
        long restPart = Math.abs(num%den);
        LinkedList<Long> restList = new LinkedList<>();
        LinkedList<Long> resultList = new LinkedList<>();

        while(restPart!=0&&!restList.contains(restPart)){
            restList.add(restPart);
            resultList.add(restPart*10/den);
            restPart = restPart*10%den;
        }
        if (restPart==0){
            if (!restList.isEmpty()){
                result+='.';
                while(!resultList.isEmpty()){
                    result+=((char)('0'+resultList.pop()));
                }
            }
        }else {
            result+='.';
            int index = restList.indexOf(restPart);
            for (int i = 0; i < index; i++) {
                result+=((char)('0'+resultList.pop()));
            }
            result+='(';
            while(!resultList.isEmpty()){
                result+=((char)('0'+resultList.pop()));
            }
            result+=')';
        }
        if (sign1^sign2&&!result.equals("0")) return "-"+result;
        return result;
    }
}
