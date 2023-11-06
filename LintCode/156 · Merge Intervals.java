problem link: https://www.lintcode.com/problem/156/?fromId=18&_from=collection

Complexity: Time O(nlogn)   - Space O(1)  
// Better approach
public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) 
            return intervals;
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        Interval prev = null;
        int prevIndex = 0;
        int l =0; 
        for(int r= 1; r< intervals.size();r++){
            Interval left = intervals.get(l), right = intervals.get(r);
            
            if(right.start <= left.end)
                left.end = Math.max(left.end, right.end);
            else{
                l++;
                intervals.set(l, right);
            }
        }

        return  intervals.subList(0, l+1);
    }
}

--------------------------
Another solution

Complexity: Time O(nlogn)   - Space O(n)  
public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        
        if(intervals.isEmpty()) 
            return new  ArrayList<Interval>();
        
        List<Interval> res=  new ArrayList<>();

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval prev = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval cur = intervals.get(i);
            if(cur.start <= prev.end)
                prev = new Interval(prev.start, Math.max(prev.end, cur.end));
            else{
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);

        return res;
    }
}
