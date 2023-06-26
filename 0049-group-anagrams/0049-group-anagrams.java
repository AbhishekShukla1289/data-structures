class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String x : strs){
            char[] ch = x.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if(!map.containsKey(str)) 
                map.put(str, new ArrayList());
            map.get(str).add(x);
        }
        return new ArrayList(map.values());
    }
}