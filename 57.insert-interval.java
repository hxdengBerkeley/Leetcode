/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals.size()==0) {
            result.add(newInterval);
            return result;
        }
        //insert
        int k=0;
        while(k<intervals.size()){
            if (intervals.get(k).start>newInterval.start){
                intervals.add(k,newInterval);
                break;
            }
            k++;
        }
        if(k==intervals.size()) intervals.add(newInterval);

        // copy
        result.add(intervals.get(0));
        for (int i = 1; i < Math.max(1,k-1); i++) {
            result.add(intervals.get(i));
        }

        // merge
        for (int i = Math.max(1,k-1); i < intervals.size(); i++) {
            if(intervals.get(i).start<=result.get(result.size()-1).end){
                result.set(result.size()-1, new Interval(result.get(result.size()-1).start, Math.max(intervals.get(i).end,result.get(result.size()-1).end)));
            }else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }
}
