// short solution using stream
class Solution {
    public long minimumHealth(int[] damage, int armor) {
    long health = Arrays.stream(damage).asLongStream().sum();
    int mxHealth = Arrays.stream(damage).max().getAsInt();
    return health +1 - Math.min(armor, mxHealth);
    }
}


// solution
class Solution {
    public long minimumHealth(int[] damage, int armor) {
       int mx=0;
       long health = 1;
       for(int d: damage){
           health += d;
           mx = Math.max(d, mx);
       }
       health -= Math.min(mx,armor);
       return health;
    }
}
