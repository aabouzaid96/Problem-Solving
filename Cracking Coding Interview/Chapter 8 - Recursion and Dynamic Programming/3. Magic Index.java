/*
Magic Index: A magic index in an array A [ 0 ••• n -1] is defined to be an index such that A[ i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
FOLLOW UP
What if the values are not distinct?
*/

// Solution in O(logn)
public static int magicIndex(int a[]){
        length = a.length;
       return solve( 0, length, a);
}
private static int solve(int start, int end, int a[]){
    if(end > length || start < 0 || start > end ) return -1;

    int mid = (start+ end)/2;
    if(mid == a[mid]) return mid;

    if(a[mid] < mid)
        return solve(mid+1, end, a);
    else
        return solve(start, mid-1, a);
}
