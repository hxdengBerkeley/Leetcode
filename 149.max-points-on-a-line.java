/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            int straight = 0;
            int repeat = 0;
            Map<Integer,Map<Integer,Integer>> countMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x==p2.x) {
                    if (p1.y == p2.y) repeat++;
                    else straight++;
                } else{
                    int x = p1.x-p2.x;
                    int y = p1.y-p2.y;
                    int gcd =getGCD(x,y);
                    if (gcd!=0){
                        x/=gcd;
                        y/=gcd;
                    }
                    if (countMap.containsKey(x)){
                        if (countMap.get(x).containsKey(y)){
                            countMap.get(x).put(y,countMap.get(x).get(y)+1);
                        }else {
                            countMap.get(x).put(y,1);
                        }
                    }else {
                        countMap.put(x,new HashMap<>());
                        countMap.get(x).put(y,1);
                    }
                }
            }
            max = Math.max(max,straight+repeat);
            for (Map<Integer,Integer> map1:countMap.values()) {
                for (int count:map1.values()) {
                    max = Math.max(max,count+repeat);
                }
            }
        }
        return max;
    }

    public int getGCD(int a, int b){
        if (b==0) return a;
        else return getGCD(b,a%b);
    }
}