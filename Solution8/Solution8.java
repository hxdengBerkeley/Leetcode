import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.lang.Integer;
import java.lang.Character;

public class Solution8 {
    public static int myAtoi(String str) {
        int result=0,sign=1,flag=0,number=0;
        boolean start=false;
        char now;
        for(int i=0; i<str.length(); i++){
            now = str.charAt(i);
            if (now!='+'&&now!='-'&&now!=' '&&!Character.isDigit(now)) break;
            if (start&&now==' '){
                break;
            }
            if(now=='+'){
                sign=1;
                flag++;
                start =true;
                continue;
            }
            if(now=='-'){
                sign=-1;
                flag++;
                start =true;
                continue;
            }
            if(Character.isDigit(now)){
                number=Character.getNumericValue(now);
                if(sign*result>(Integer.MAX_VALUE-number)/10){
                    return Integer.MAX_VALUE;
                }
                if(sign*result<(Integer.MIN_VALUE+number)/10){
                    return Integer.MIN_VALUE;
                }
                result = result*10+number;
                start=true;
                continue;
            }
        }
        if(flag>1){
            return 0;
        }else{
            return sign*result;
        }
    }

    public static void main(String[] args) {
    	String a = " - 321";
    	System.out.println(myAtoi(a));
    	//System.out.println(-214748364<(Integer.MIN_VALUE+7)/10);
    }
}