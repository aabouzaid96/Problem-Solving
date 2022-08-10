// Problem: License Key Formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int  numberOfNoAlphaNumeric = 0;
        int indexOfLastAlphaNumeric =0;
        for (int i=0; i< s.length(); i++ ) {
            char c= s.charAt(i);
            if (c != '-') { numberOfNoAlphaNumeric++; indexOfLastAlphaNumeric = i;}
        }

        int cntOfFirstPart = numberOfNoAlphaNumeric % k;
        int cnt = 0;
        StringBuilder reformattedString = new StringBuilder();
        for (int i=0;i<=indexOfLastAlphaNumeric;i++) {
            char ch = s.charAt(i);
            if (ch != '-') {
                char C = Character.toUpperCase(ch);
                if(cntOfFirstPart != 0){
                    reformattedString.append(C);
                    cntOfFirstPart--;
                    if(cntOfFirstPart == 0 && i < indexOfLastAlphaNumeric) reformattedString.append('-');
                }else{
                    reformattedString.append(C);
                    cnt++;
                    if(cnt == k && i < indexOfLastAlphaNumeric) {cnt=0; reformattedString.append('-');}
                }
            }
        }

        return reformattedString.toString();
    }
}
