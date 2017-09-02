/**
 * Created by denghanxiao on 2017/5/7.
 */

public class Solution11 {
    public static int maxArea(int[] height) {
        int j = height.length-1, i = 0, max =0;
        while(i<j){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args){

    }
}
