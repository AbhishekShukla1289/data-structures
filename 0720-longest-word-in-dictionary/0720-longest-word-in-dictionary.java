class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            //curr.word = 
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        root = new TrieNode();
        //String res;
        for(String w : words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int k = 25; k >= 0; k--){
                if(curr.children[k] != null && curr.children[k].word != null){
                    q.add(curr.children[k]);
                }
            }
        }
        return curr.word == null ? "" : curr.word;
    }
}