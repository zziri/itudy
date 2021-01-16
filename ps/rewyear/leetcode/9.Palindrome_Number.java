class Solution {
    public boolean isPalindrome(int x) {
        StringBuffer str = new StringBuffer(Integer.toString(x));
        StringBuffer reverse = new StringBuffer(str.reverse().toString());
        str.reverse(); // reverse to origin
        
        return str.toString().equals(reverse.toString());
    }
}
