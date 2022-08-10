// Problem 904. Fruit Into Baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int l=0, r=0, maxResult = 0, cur=0, curLength =0;
        Map<Integer, Integer> basket = new HashMap<>();

        while(l<=r && r<fruits.length){
            int rightFruit = fruits[r];
            int leftFruit = fruits[l];
            if(cur < 2 ){
                if(!basket.containsKey(rightFruit) || (basket.containsKey(rightFruit) && basket.get(rightFruit) ==-1)){
                    basket.put(rightFruit, r);
                    cur++;
                }
                r++;
                curLength++;
            }else{
                if(basket.containsKey(rightFruit) && basket.get(rightFruit) != -1){
                    if(rightFruit == leftFruit && fruits[r-1] != rightFruit){
                        l = basket.get(fruits[r-1]);
                        basket.put(leftFruit, r);
                    }
                    r++;
                    curLength++;
                }else{
                    basket.put(leftFruit, -1);
                    basket.put(rightFruit, r);
                    l = basket.get(fruits[r-1]);
                    curLength = r-l+1;
                    r++;
                }
            }
            maxResult = Math.max(maxResult, curLength);
        }
        return maxResult;
    }
}
