// Binary Search 
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int st=0, end= letters.length -1;
        while(st<=end){
            int mid = (st +end )/2;
            if(letters[mid] <= target) 
                st = mid +1;
            else
                end =mid -1;
        }
        if(st == letters.length) return letters[0];
        return letters[st];
    }
}
