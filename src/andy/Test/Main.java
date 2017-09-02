package andy.Test;

import sun.dc.pr.PRError;

import java.util.*;

public class Main {
    public static String fractionToDecimal(int numerator, int denominator) {
        boolean sign1 = false, sign2=false;
        if (numerator<0) sign1=true;
        if (denominator<0) sign2=true;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        String result = "";
        long intPart = num/den;
        Stack<Character> stack = new Stack<>();
        while(intPart!=0){
            stack.push((char)('0'+intPart%10));
            intPart/=10;
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        if (result.length()==0) result+='0';
        den = Math.abs(den);
        long restPart = Math.abs(num%den);
        LinkedList<Long> restList = new LinkedList<>();
        LinkedList<Long> resultList = new LinkedList<>();

        while(restPart!=0&&!restList.contains(restPart)){
            restList.add(restPart);
            resultList.add(restPart*10/den);
            restPart = restPart*10%den;
            if (resultList.size()+result.length()+1==33){
                restPart=0;
            }
        }
        if (restPart==0){
            if (!restList.isEmpty()){
                result+='.';
                while(!resultList.isEmpty()){
                    result+=((char)('0'+resultList.pop()));
                }
            }
        }else {
            result+='.';
            int index = restList.indexOf(restPart);
            for (int i = 0; i < index; i++) {
                result+=((char)('0'+resultList.pop()));
            }
            result+='(';
            while(!resultList.isEmpty()){
                result+=((char)('0'+resultList.pop()));
            }
            result+=')';
        }
        if (sign1^sign2&&!result.equals("0")) return "-"+result;
        return result;
    }




    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,Integer.MIN_VALUE));
    }


























    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

}