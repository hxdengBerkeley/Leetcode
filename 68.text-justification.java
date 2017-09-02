public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        if (words.length==1){
            stack.add(words[0]);
            result.add(lineJustify(stack,maxWidth));
            return result;
        }
        int length=0;
        int index=0;
        while(index<words.length){
            if(length==0){
                stack.clear();
                stack.add(words[index]);
                length=words[index].length();
                index++;
                continue;
            }else{
                if (length+1+words[index].length()<=maxWidth){
                    stack.add(words[index]);
                    length+=1+words[index].length();
                    index++;
                    continue;
                }else {
                    result.add( lineJustify(stack,maxWidth) );
                    stack.clear();
                    length=0;
                    continue;
                }
            }
        }
        if (!stack.empty()){
            String flag = "";
            int blank = maxWidth;
            for (String word:stack) {
                blank-=word.length();
            }
            blank-=stack.size();
            for (int i = 0; i < blank; i++) {
                flag+=" ";
            }
            stack.add(flag);
            result.add(lineJustify(stack,maxWidth));
        }
        return result;
    }

    public String lineJustify(Stack<String> stack, int maxWidth){
        String result = "";
        if (stack.size()==1){
            result+=stack.peek();
            for (int i = 0; i < maxWidth-stack.peek().length(); i++) {
                result+=" ";
            }
        }else {
            int total=0;
            for (String word:stack) {
                total+=word.length();
            }
            int rest=(maxWidth-total)%(stack.size()-1),single=(maxWidth-total)/(stack.size()-1);
            int now;
            for (String word:stack) {
                result+=word;
                if (word==stack.peek()) break;
                for (int i = 0; i < single; i++) {
                    result+=" ";
                }
                if (rest>0){
                    result+=" ";
                    rest--;
                }
            }
        }
        return result;
    }
}