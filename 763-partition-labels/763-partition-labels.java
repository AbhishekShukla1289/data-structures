class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        List<Integer> partition = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else
            {
                map.put(c,map.get(c)+1);
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            set.add(c);
            map.put(c,map.get(c)-1);
            if(map.get(c) == 0){
                set.remove(c);
            }
            if(set.isEmpty()){
                partition.add((i+1) - sum);
                sum = sum + partition.get(partition.size()-1);
            }
        }
        return partition;
    }
}