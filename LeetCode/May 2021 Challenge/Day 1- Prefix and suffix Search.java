//Solution using Trie Tree


//Runtime :406 ms    209 MB
class WordFilter {
    private Trie prefix = null;
    private Trie suffix = null;


    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();

        for(int i=0;i<words.length;i++){
            prefix.insert(words[i],i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(),i);
        }
    }

    public int f(String pre, String suff) {
        List<Integer> preList = prefix.startWith(pre);
        List<Integer> suffList = suffix.startWith(new StringBuilder(suff).reverse().toString());
        int i = preList.size()-1, j= suffList.size()-1;
        while(i>=0 && j>=0){
            if(Objects.equals(preList.get(i),suffList.get(j))) return preList.get(i);
            else if(preList.get(i) > suffList.get(j)) i--;
            else j--;
        }

        return -1;
    }
}

class Trie {
    public Trie []t;
    List<Integer> ind;

    Trie(){
        t =new Trie[26];
        ind= new ArrayList<>();
    }

    // insert
    public void insert(String word, int i){
        Trie root = this;
        for(char c : word.toCharArray()){
            if(root.t[c-'a'] == null){
                root.t[c-'a']=new Trie();
            }
            root = root.t[c-'a'];
            root.ind.add(i);
        }
    }

    // get prefix
    public List<Integer> startWith(String word){
        Trie root = this;
        for(char c : word.toCharArray()){
            if(root.t[c-'a']==null){
                return new ArrayList<>();
            }
            root = root.t[c-'a'];
        }
        return root.ind;
    }

}
