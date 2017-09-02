public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String now = tokens[i];
            if (now.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }else if (now.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if (now.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if (now.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                stack.push(str2int(now));
            }
        }
        return stack.peek();
    }

    public int str2int(String number){
        int result = 0;
        if (number.charAt(0)=='-'){
            for (int i = 1; i < number.length(); i++) {
                result = 10*result+Character.getNumericValue(number.charAt(i));
            }
            return -result;
        }else {
            for (int i = 0; i < number.length(); i++) {
                result = 10*result+Character.getNumericValue(number.charAt(i));
            }
            return result;
        }
    }
}