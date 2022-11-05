class Node {
    int time;
    String web;
    public Node(int time, String web) {
        this.time = time;
        this.web = web;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        Map<String, List<Node>> map = new HashMap<>();
        int n = username.length;
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Node(timestamp[i], website[i]));
        }

        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            Set<String> set = new HashSet<>();
       
            List<Node> list = map.get(key);
            Collections.sort(list, (a, b)->(a.time - b.time)); // sort by time
       
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(list.get(i).web).append(" ").append( list.get(j).web).append(" ").append(list.get(k).web);
                        String str = sb.toString();
                        if (!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            // make sure the right lexi order
                            res = str;
                        }
                    }
                }
            }
        }
        return Arrays.asList( res.split(" "));
    }
}

/**
["joe","home"  ,1]
["joe","about" ,2]
["joe","career",3],

["james","home",4]
["james","cart",5]
["james","maps",6]
["james","home",7]

["mary","home"  ,8]
["mary","about" ,9]
["mary","career",10].

 */
