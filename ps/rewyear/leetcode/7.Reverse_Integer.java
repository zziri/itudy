class Solution {
    public int reverse(int x) {
        StringBuffer str = new StringBuffer(Integer.toString(x));
        
        str.reverse();
        
        if(str.charAt(str.length()-1) == '-'){
            str.deleteCharAt(str.length()-1); // delete minus 
            str.insert(0,'-'); // add minus
        }
            
        long reversed = Long.parseLong(str.toString());
        if(reversed < (int)-2e31 || reversed > (int)2e31 - 1)
            return 0;
        else
            return (int)reversed;
    }
}
