public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        Stack<Integer> stHeight = new Stack<>();
        Stack<Integer> stIndex = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stHeight.isEmpty()||heights[i] > stHeight.peek()){
                stHeight.push(heights[i]);
                stIndex.push(i);
            }else if(heights[i]<stHeight.peek()){
                int lastIndex = 0;
                while(!stHeight.isEmpty() && heights[i] < stHeight.peek()){
                    lastIndex = stIndex.pop();
                    int area = stHeight.pop()*(i-lastIndex);
                    max = Math.max(max,area);
                }
                stHeight.push(heights[i]);
                stIndex.push(lastIndex);    //放lastIndex是该高度heights[i]可以最多回溯到的序号，因为这是最后一个比他大的序号
            }
        }
        while(!stHeight.isEmpty()){
            int area = stHeight.pop()*(heights.length-stIndex.pop());
            max = Math.max(max,area);
        }
        return max;
    }
}