// my solution using BFS Algorithm
// Sol 1
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
