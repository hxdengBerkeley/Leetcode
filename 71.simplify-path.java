public class Solution {
    public static String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            int start=0,end=0;
            while(start<path.length()){
                if (path.charAt(start)!='/'){
                    end=start;
                    while(end<path.length()&&path.charAt(end)!='/'){
                        end++;
                    }
                    String sign = path.substring(start,end);
                    start=end+1;
                    if(sign.equals(".")){
                        continue;
                    }else if (sign.equals("..")){
                        if (!stack.isEmpty()){
                            stack.pop();
                        }
                        continue;
                    }else {
                        stack.push(sign);
                    }
                }else {
                    start++;
                }
            }
            String result="";
            for (String word:stack) {
                result+="/";
                result+=word;
            }
            if (result.isEmpty()){
                return "/";
            }else {
                return result;
            }
    }
}