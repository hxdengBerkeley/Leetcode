/**
 * Created by denghanxiao on 2017/5/7.
 */
public class Solution12 {
    public static String intToRoman(int num) {
        String[][] db = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        String result = "";
        result += db[3][num/1000];
        result += db[2][num/100%10];
        result += db[1][num/10%10];
        result += db[0][num%10];
        return result;
    }



    public static void main(String[] args){
        System.out.println(intToRoman(4));
    }
}
