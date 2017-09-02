/**
 * Created by denghanxiao on 2017/4/27.
 */
import java.lang.Integer;
import java.lang.Math;

public class Solution9 {
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else {
            int count = getCount(x);
            for (int i = 0; i < count/2; i++) {
                if (geti(x,i)!=geti(x,count-i-1)) return false;
            }
            return true;
        }
    }

    public static int getCount(int x){
        if (x< 0){
            return getCount(-x);
        }
        if(x < 10){
            return 1;
        }else {
            return getCount(x/10)+1;
        }
    }

    public static int geti(int x, int i){
        if (i == 0){
            return x%10;
        }
        if (i == getCount(x)-1)
        {
            int tenx = (int)Math.pow(10,i);
            return x/tenx;
        }
        int tenx = (int)Math.pow(10,i);
        return (x%(tenx*10))/tenx;
    }

    public static void main(String[] args){
        int x = 1410110141;
        System.out.println(isPalindrome(x));
    }
}
