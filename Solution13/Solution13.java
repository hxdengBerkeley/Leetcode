/**
 * Created by denghanxiao on 2017/5/7.
 */
import java.util.HashMap;
public class Solution13 {
    public static int romanToInt(String s) {
        String[][] romandb = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        
        HashMap<String,Integer> roman2num = new HashMap<String, Integer>(31);

        for (int i = 1; i < romandb[0].length; i++) {
            roman2num.put(romandb[0][i],i);
            roman2num.put(romandb[1][i],10*i);
            roman2num.put(romandb[2][i],100*i);
            if (i < 4) {
                roman2num.put(romandb[3][i],1000*i);
            }
        }
        int result = 0,i=0,j;
        String now;
        while(i<s.length()){
            j=i+1;
            now = s.substring(i,j);   //取得是s.charAt(i)

            while(j<s.length()+1&&roman2num.containsKey(s.substring(i,j))){
                j++;
            }
            j--;
            now = s.substring(i,j);
            result +=roman2num.get(now);
            i=j;
        }
        return result;
    }
    public static void main(String[] args){

        System.out.println(romanToInt("DCXXI"));
    }
}
