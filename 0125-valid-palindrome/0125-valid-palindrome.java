class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return false;
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        
        int head = 0;
        int tail = s.length()-1;
        
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(head) != s.charAt(tail))
                return false;
            head++;
            tail--;
        }
        return true;
    }
}