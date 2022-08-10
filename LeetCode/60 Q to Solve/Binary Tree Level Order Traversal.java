/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    
    class Pair{
        TreeNode treeNode;
        int lvl;
        Pair(TreeNode treeNode, int lvl){
            this.treeNode = treeNode;
            this.lvl = lvl;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
//         validate input
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res=new ArrayList<>();
        Queue<Pair> Q=new LinkedList<>();
        int lvl=0;
        List<Integer> tmp=new ArrayList<>();
        
        Q.add(new Pair(root,0));
    
        while(!Q.isEmpty()){
            int curLvl = Q.peek().lvl;
            TreeNode curNode = Q.peek().treeNode;
            Q.poll();
            if(curLvl == lvl){
                tmp.add(curNode.val);
            }else{
                res.add(tmp);
                tmp =new ArrayList<>();
                tmp.add(curNode.val);
                lvl=curLvl;
            }
            if(curNode.left != null) Q.add(new Pair(curNode.left, curLvl+1));
            if(curNode.right != null) Q.add(new Pair(curNode.right, curLvl+1));

        }
        res.add(tmp);
        return res;
    }
}
