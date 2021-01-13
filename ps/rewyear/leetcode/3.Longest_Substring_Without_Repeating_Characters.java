class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sub = "";
        int maxLength = 0;
        int cnt = 0;
        
        if(s.isEmpty()) return maxLength;
        
        for(int i=0; i<s.length(); i++) {  
            for(int j=i; j<s.length(); j++) {
                String str = String.valueOf(s.charAt(j));
                if(sub.contains(str))
                {
                    sub="";
                    cnt=0;
                    break;
                }
                else
                {
                    cnt++;
                    if(cnt > maxLength)
                        maxLength = cnt;                    
                    if(sub == "")
                        sub = str;
                    else
                        sub = sub.concat(str);
                }    
            }
            
        }
        
        return maxLength;
            
    }
}
