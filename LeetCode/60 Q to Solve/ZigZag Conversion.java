// https://leetcode.com/problems/zigzag-conversion/
class Solution {
    public String convert(String s, int numRows) {
          if(numRows == 1 || s.length()<=2 || s.length() <= numRows) return s;
        StringBuilder sb=new StringBuilder();
        int row=0, diff=numRows + numRows-2;
        int tempDiff=diff;
        while(row<numRows){
            sb.append(s.charAt(row));
            if(row==0 || row == numRows-1){
                int ind=row;
                while (ind+diff < s.length()){
                    ind+= diff;
                    sb.append(s.charAt(ind));
                }
            }else{
                int ind = row;
                while(ind + tempDiff < s.length()){
                    ind += tempDiff;
                    sb.append(s.charAt(ind));
                    ind+= diff - tempDiff;
                    if(ind < s.length()) sb.append(s.charAt(ind));
                }
            }
            row++;
            tempDiff-=2;
        }
        return sb.toString();
    }
}
