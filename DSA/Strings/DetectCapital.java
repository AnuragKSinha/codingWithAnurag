package DSA.String;
/**
 * https://leetcode.com/problems/detect-capital/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1)
            return true;
        if(allCapital(word.toCharArray()))
            return true;
        if(correctCapital(word.toCharArray()))
            return true;
        return false;
    }
    public boolean allCapital(char[] ch){
        for(char c: ch){
            if(c>='a' && c<='z')
                return false;
        }
        return true;
    }
    public boolean correctCapital(char[] ch){
        for(int i=1;i<ch.length;i++){
            if(ch[i]>='A' && ch[i]<='Z')
                return false;
        }
        return true;
    }
}