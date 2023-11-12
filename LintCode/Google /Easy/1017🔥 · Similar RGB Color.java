https://www.lintcode.com/problem/1017/?fromId=18&_from=collection 

public class Solution {
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
 
        int min = Integer.MAX_VALUE;
 
        String ans = "";
 
        for(int i = 0; i < 16 ; i++){
 
            for (int j = 0; j < 16 ; j++){
 
                for (int k = 0; k < 16 ; k++){
 
                    String test = "#" + Integer.toHexString(i) + Integer.toHexString(i) + Integer.toHexString(j) + Integer.toHexString(j) 
                      + Integer.toHexString(k) + Integer.toHexString(k);
 
                    int currSim = similarity(color, test);
 
                    if (currSim < min){
                        min = currSim;
                        ans = test;
                    }
                }
 
            }
        }
 
        return ans;
    }
 
    int similarity (String color, String test){
 
        int f1 = Integer.parseInt(color.substring(1 , 3) , 16) - Integer.parseInt(test.substring(1 , 3) , 16);
        int f2 = Integer.parseInt(color.substring(3 , 5) , 16) - Integer.parseInt(test.substring(3 , 5) , 16);
        int f3 = Integer.parseInt(color.substring(5 , 7) , 16) - Integer.parseInt(test.substring(5 , 7) , 16);
 
        return Math.abs(f1 * f1 + f2 * f2 + f3 * f3); 
    }
}

/**
0123456789012345
0123456789ABCDEF
**/
