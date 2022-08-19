/**
"19:34" ->  "19:39" 
"23:59" ->  "22:22"  
"00:01" ->  "00:10" 
"13:55" ->  "15:11"  
*/

class Solution {
   public String nextClosestTime(String time) {

        List<Integer> availableNumers = new ArrayList<>();
        for(char ch: time.toCharArray()){
            if(ch != ':' && !availableNumers.contains(ch-'0'))
                availableNumers.add(ch-'0');
        }
        Collections.sort(availableNumers);
        char[] timeChars = time.toCharArray();

        boolean changed = false; int chagedIndex = -1;
        for(int i=time.length()-1;i>=0;i--){
            char ch = timeChars[i];
            if (ch ==':') continue;
            int replacedNumber = canReplaceChar(i, ch, time,  availableNumers);
            if( replacedNumber != -1){
                timeChars[i]= (char) (replacedNumber+'0');
                chagedIndex = i;
                break;
            }
        }
        if(chagedIndex != -1){
            for(int i=time.length()-1;i>chagedIndex;i--){
                char ch = timeChars[i];
                if (ch ==':') continue;
                int replacedNumber = canReplaceWitMinChar(i, ch, time,  availableNumers);
                if( replacedNumber != -1){
                    timeChars[i]= (char) (replacedNumber+'0');
                }
            }
            return String.valueOf(timeChars);
        }
        for(int i=0;i<time.length();i++){
            char ch = timeChars[i];
            if (ch ==':') continue;
            int replacedNumber = canReplaceWitMinChar(i, ch, time,  availableNumers);
            if( replacedNumber != -1){
                timeChars[i] = (char) (replacedNumber+'0');
            }
        }

        return String.valueOf(timeChars);
    }

  private static int canReplaceChar(int index, char number, String time, List<Integer> availableNumers){
        int maxNumber = 9;
        if(index == 4 || (index == 1 && (time.charAt(0) == '0' || time.charAt(0) == '1'))){
            // 0 - 9
            maxNumber = 9;
        }else if(index == 3 ){
            maxNumber = 5;
        }else if(index == 1 && time.charAt(0) == '2'){
            maxNumber = 3;
        }else if(index == 0){
            maxNumber = 2;
        }

        for(int i=0; i < availableNumers.size();i++){
            if(availableNumers.get(i) <= maxNumber && availableNumers.get(i) > number - '0')
                return availableNumers.get(i);
        }
        return -1;
    }

    private static int canReplaceWitMinChar(int index, char number, String time, List<Integer> availableNumers){
        for(int i=0; i < availableNumers.size();i++){
            if(availableNumers.get(i) < number - '0')
                return availableNumers.get(i);
        }
        return -1;
    }

}
