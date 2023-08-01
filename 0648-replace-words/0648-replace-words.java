class Solution {
    class TrieNode{
        boolean isEnd;
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
            if(curr.children[c - 'a'] == null) 
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        String[] split = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        TrieNode curr;
        for(int k = 0; k < split.length; k++){
            curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int m = 0; m < split[k].length(); m++){
                char c = split[k].charAt(m);
                replacement.append(c);
                if(curr.children[c - 'a'] == null ){
                    result.append(split[k]);
                    result.append(" ");
                    break;
                }                
                // else if(curr.children[c - 'a'].isEnd || (!curr.children[c - 'a'].isEnd && m == split[k].length() - 1) ){
                //     result.append(replacement);
                //     result.append(" ");
                //     break;
                // }
                else if(curr.children[c - 'a'].isEnd){
                    result.append(replacement);
                    result.append(" ");
                    break;
                }
                else if(!curr.children[c - 'a'].isEnd && m == (split[k].length() - 1)){
                    result.append(replacement);
                    result.append(" ");
                    break;
                }
                curr = curr.children[c - 'a'];
            }            
        }
        return result.toString().trim();
    }
}