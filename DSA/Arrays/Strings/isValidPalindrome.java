/**
 * https://leetcode.com/problems/valid-palindrome/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class isValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)
            return true;
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(!isAlphaNumeric(s.charAt(l)))
                l++;
            else if(!isAlphaNumeric(s.charAt(r)))
                r--;
            else if(!isSame(s.charAt(l),s.charAt(r))){
                 return false; 
            } else{
                l++;
                r--;
            }
        }
        return true;
    }
    private boolean isSame(Character a,Character b){
        if(a==b)
            return true;
        int cha=a;
        int chb=b;
        if(a>='A'&& a<='Z')
            cha=cha-'A';
        else if(a>='a'&& a<='z')
            cha=cha-'a';
        if(b>='A'&& b<='Z')
            chb=chb-'A';
        else if(b>='a'&& b<='z')
            chb=chb-'a';
     
        return cha==chb;
    }
    private boolean isAlphaNumeric(Character ch){
        
        if(ch>='0' && ch<='9')
            return true;
        if(ch>='a' && ch<='z')
            return true;
        if(ch>='A' && ch<='Z')
            return true;
        return false;
    }
}