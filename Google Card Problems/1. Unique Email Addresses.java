Problem : 929. Unique Email Addresses [https://leetcode.com/problems/unique-email-addresses/]

Solution 1
-----------------------
```
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> results = new HashSet<>();
        for (String s : emails) {
           results.add(getFinalEmail(s));
        }
        return results.size();
    }
    private String getFinalEmail(String email){
        StringBuilder cleanEmail = new StringBuilder();
        boolean Ignore = false;
        int len = email.length();
            for (int i = 0; i < len; i++) {
                char ch = email.charAt(i); 
                if ( ch == '@') {
                    cleanEmail.append(email.substring(i, len));
                    break;
                } else if (ch == '+') {
                    Ignore = true;
                }
                else if (ch != '.' && !Ignore)
                    cleanEmail.append(ch);
            }
            return cleanEmail.toString();
    }
}
```

Solution 2
--------------------------
```
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> results = new HashSet<>();
        for (String email : emails) {
            // split by @             
            String[] parts = email.split("@");            
            // split by +             
            String[] local = parts[0].split("\\+");
            String cleanLocalEmail = local[0].replace(".","");     
            StringBuilder sb =new StringBuilder().append(cleanLocalEmail).append("@").append(parts[1]);               
            results.add( sb.toString());
        }
        return results.size();
    }
}
```
