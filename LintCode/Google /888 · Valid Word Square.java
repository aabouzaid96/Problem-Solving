Problem https://www.lintcode.com/problem/888/description?fromId=18&_from=collection


public class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // if(words.length != words[0].length()) return false;

        for(int i=0;i<words.length; i++){
            String s1 = words[i];
            StringBuilder s2 = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                if(j >= words.length || i >= words[j].length() ) return false;
                s2.append(words[j].charAt(i));
            }
            System.out.println(s1 +" "+ s2.toString());
            if(!s1.equals(s2.toString())) return false;
        }

        return true;
    }
}
