public class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0]=1;
        right[right.length-1]=1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
            else left[i]=1;
            int j = ratings.length-1-i;
            if (ratings[j]>ratings[j+1]) right[j]=right[j+1]+1;
            else right[j]=1;
        }
        int result=0;
        for (int i = 0; i < ratings.length; i++) {
            result+=Math.max(left[i],right[i]);
        }
        return result;
    }
}