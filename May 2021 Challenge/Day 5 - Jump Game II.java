// my solution using BFS Algorithm
// Sol 1
// compexity O(n+m)  // n length if nums   m maximum number of jumps     

public int jump(int[] nums) {
        Queue<Jump> Q=new LinkedList<>();
        int vis[]=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
            Q.add(new Jump(nums[0], 0, 0));
            vis[0]=1;

//        }
        while(!Q.isEmpty()){
            Jump cur=Q.peek();
            Q.remove();
            if(cur.pos == nums.length-1)
                return cur.res;
            if(cur.jump >= (nums.length-1)-cur.pos)
                return cur.res+1;

            for(int step= cur.jump;step>=1;step--){
                if(vis[cur.pos+step]!= 1 && cur.pos+step <= nums.length-1 &&
                        step !=0 && nums[cur.pos+step]!=0){
                    vis[cur.pos+step]=1;
                    Q.add(new Jump(nums[cur.pos+step],cur.pos+step,cur.res+1));
                }
            }

        }
        return 0;
    }

class Jump{
    public int jump;
    public int pos;
    public int res=0;
    Jump (int jump, int pos,int res){
        this.pos=pos;
        this.jump=jump;
        this.res=res;
    }
}

-------------------------------------
   // Sol 2  more optimization
   // compexity O(n*m)  // n length if nums   m maximum number of jumps     
public static int jump(int[] nums) {
        int res[]=new int [nums.length];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0]=0;
    for(int i=0;i<nums.length;i++){
        for(int step=1;step<=nums[i] && i+step < nums.length;step++){
            res[i+step]=Math.min(res[i+step],res[i]+1);
        }
    }
    return res[nums.length-1];
    }
