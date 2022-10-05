class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int n = s.length();
        int match = 0; //count the number of characters matched from p
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < n; i++){
            char in = s.charAt(i);
            //incoming
            if(map.containsKey(in)){
                int cnt =  map.get(in);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(in, cnt);
            }
            //outgoing
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        
            return result;
    }
}