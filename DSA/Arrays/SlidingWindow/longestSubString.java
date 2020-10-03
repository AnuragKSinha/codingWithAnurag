package DSA.Array.SlidingWindow;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time Complexity:O(n)
 * Space Complexity:O(n)
 */
class longestSubString {
    Set<Character> set=new HashSet<>();
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int res=0;
        int i=0,j=0;
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res=Math.max(res,set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}